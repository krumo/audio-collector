package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import implementation.TextAudioimpl;
import implementation.textimpl;
import implementation.userimpl;
import pojo.TextAudio;
import pojo.text;
import pojo.user;

/**
 * Created by krumo on 2016/3/3.
 */
@WebServlet(name = "RecServ")
@MultipartConfig
public class RecServ extends HttpServlet {
    private final String path = "C:\\Users\\krumo\\Documents\\Bachelor\\";
    private String[] text2read;
    private int length;
    private int curmark, beforemark;
    private boolean back, initial;
    private TextAudioimpl taimpl = new TextAudioimpl();
    private textimpl txtimpl = new textimpl();
    private userimpl urimpl = new userimpl();
    private List<text> txts;

    @Override
    public void init() throws ServletException {
        super.init();
        initial = true;
        length = 10;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String status = request.getParameter("status");
        String type = (String) request.getSession().getAttribute("type");
        int uid = (int) request.getSession().getAttribute("userID");
        int lasttext = (int) request.getSession().getAttribute("lasttext");
        String sex = (String) request.getSession().getAttribute("sex");
        if (status.equals("upload")) {
            Part filePart = request.getPart("filee"); // Retrieves <input type="file" name="file">
            //InputStream fileContent = filePart.getInputStream();
            String relativeAddress = path + uid + "\\";
            File dirFile = new File(relativeAddress);
            if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
                boolean createdir = dirFile.mkdirs();
                if (createdir)
                    System.out.println("dir created succ");
                else
                    System.out.println("dir created fail");
            }
            if (sex.equals("male")) {
                relativeAddress = relativeAddress + txts.get(beforemark).getTextID() + "-" + uid + ".wav";
                txts.get(beforemark).setMaleread(txts.get(beforemark).getMaleread() + 1);
            } else {
                relativeAddress = relativeAddress + txts.get(beforemark).getTextID() + "-" + uid + ".wav";
                txts.get(beforemark).setFemaleread(txts.get(beforemark).getFemaleread() + 1);
            }
            System.out.println(relativeAddress + " before:" + beforemark + " current: " + curmark);
            File uploads = new File(relativeAddress);
            //File file = File.createTempFile("RecAudio-", ".wav", uploads);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, uploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            //Files.copy(fileContent, uploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
            //更新textaudio数据库
            TextAudio ta = new TextAudio();
            ta.setUserID(uid);
            ta.setTextID(txts.get(beforemark).getTextID());
            ta.setRelativeAddress(relativeAddress);
            taimpl.savetextaudio(ta);
            //更新text数据库
            txtimpl.modifytext(txts.get(beforemark));
            //更新user数据库
            user ur = new user();
            ur.setUserID(uid);
            ur.setAudionum(-1);
            List<user> urs = urimpl.queryuser(ur);
            if (urs.isEmpty())
                System.out.println("user更新失败");
            ur = urs.get(0);

            if (ur.getLasttext() < txts.get(beforemark).getTextID()) {
                ur.setLasttext(txts.get(beforemark).getTextID());
                ur.setAudionum(ur.getAudionum() + 1);
                //request.getSession().setAttribute("lasttext",txts.get(beforemark).getTextID());
            }
            urimpl.updateuserlasttext(ur);
        } else if (status.equals("next")) {
            //if(initial)
            {
                readnextsentences(uid, lasttext, type);
                initial = false;
            }
            //else
            {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                if (back)
                    curmark++;
                back = false;
                beforemark = curmark;
                System.out.println("before: " + beforemark);
                System.out.println(txts.get(curmark).getSentence());
                request.getSession().setAttribute("lasttext", txts.get(beforemark).getTextID());
                out.println("<h2>" + txts.get(curmark++).getSentence() + "<h2>");
                out.flush();
                out.close();
            }

        } else if (status.equals("previous")) {
            readprevioussentences(uid, lasttext, type);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>" + txts.get(curmark).getSentence() + "<h2>");
            beforemark = curmark;
            request.getSession().setAttribute("lasttext", txts.get(beforemark).getTextID());
            back = true;
            out.flush();
            out.close();
        } else if (status.equals("skip")) {
            //写出数据库 skip数
            txtimpl.updateskiptext(txts.get(beforemark));
            System.out.println("skip:" + txts.get(beforemark).getSentence());
            readnextsentences(uid, lasttext, type);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (back)
                curmark++;
            back = false;
            beforemark = curmark;
            System.out.println("before: " + beforemark);
            System.out.println(txts.get(curmark).getSentence());
            request.getSession().setAttribute("lasttext", txts.get(beforemark).getTextID());
            out.println("<h2>" + txts.get(curmark++).getSentence() + "<h2>");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private boolean readnextsentences(int uid, int lasttext, String type) {

        txts = txtimpl.gettext2read(lasttext, length, type);
        curmark = 0;
        beforemark = 0;
        back = false;
        if(txts.isEmpty())
            return false;
        else
            return true;
    }

    private void readprevioussentences(int uid, int lasttext, String type) {
        //读数据库上一条
        if (lasttext < 2)
            txts = txtimpl.gettexthaveread(lasttext + 1, length, type);
        else
            txts = txtimpl.gettexthaveread(lasttext, length, type);
        curmark = 0;
        beforemark = 0;
    }
}
