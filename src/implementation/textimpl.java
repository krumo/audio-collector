package implementation;

import database.DBconnector;
import pojo.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krumo on 2016/3/16.
 */
public class textimpl {
    public void updatetext(text txt)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=txt.getTextID();
        String sql="update text set sentence=?,emotion = ?, frequency= ?,maleread=?,femaleread=?,skip=? where textID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt.getSentence());
            pst.setString(2,txt.getEmotion());
            pst.setString(3,txt.getFrequency());
            pst.setInt(4,txt.getMaleread());
            pst.setInt(5,txt.getFemaleread());
            pst.setInt(6,txt.getSkip());
            pst.setInt(7,txt.getTextID());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void modifytext(text txt)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=txt.getTextID();
        String sql="update text set maleread=?,femaleread=? where textID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,txt.getMaleread());
            pst.setInt(2,txt.getFemaleread());
            pst.setInt(3,txt.getTextID());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void updateskiptext(text txt)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=txt.getTextID();
        String sql="update text set skip=skip+1 where textID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,txt.getTextID());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void deletetext(int ID)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="delete from text where textID = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ID);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<text> querytext(text txt)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        List<text> list=new ArrayList<text>();
        String sql="select * from text where 1=1 ";
        if(txt!=null)
        {
            if(txt.getTextID()>0)
                sql+=" and textID = '"+txt.getTextID()+"'";
            if(txt.getSentence()!=null&&txt.getSentence().length()>0)
                sql+=" and sentence = '"+txt.getSentence()+"'";
            if(txt.getEmotion()!=null&&txt.getEmotion().length()>0)
                sql+=" and emotion = '"+txt.getEmotion()+"'";
            if(txt.getFrequency()!=null&&txt.getFrequency().length()>0)
                sql+=" and frequency ='"+txt.getFrequency()+"'";
            if(txt.getMaleread()>-1)
                sql+=" and maleread = '"+txt.getMaleread()+"'";
            if(txt.getFemaleread()>-1)
                sql+=" and femaleread = '"+txt.getFemaleread()+"'";
            if(txt.getSkip()>-1)
                sql+=" and skip = '"+txt.getSkip()+"'";
            System.out.println(sql);
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                text txts=null;
                while (rs.next())
                {
                    txts=new text();
                    txts.setTextID(rs.getInt(1));
                    txts.setSentence(rs.getString(2));
                    txts.setEmotion(rs.getString(3));
                    txts.setFrequency(rs.getString(4));
                    txts.setMaleread(rs.getInt(5));
                    txts.setFemaleread(rs.getInt(6));
                    txts.setSkip(rs.getInt(7));
                    list.add(txts);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public void savetext(text txt)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="insert into text(textID,sentence,emotion,frequency,maleread,femaleread,skip) values(?,?,?,?,?,?,?)";
        //String sql="insert into users(userID,login_name,password,illegal_time) values('hi','hi','pwd',0)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,txt.getTextID());
            pst.setString(2,txt.getSentence());
            pst.setString(3,txt.getEmotion());
            pst.setString(4,txt.getFrequency());
            pst.setInt(5,txt.getMaleread());
            pst.setInt(6,txt.getFemaleread());
            pst.setInt(7,txt.getSkip());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<text> gettext2read(int textID,int num,String type)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int i=0;
        List<text> list=new ArrayList<text>();
        String sql="select * from text where 1=1 ";
        if(type.equals("普通用户"))
            sql+=" and frequency='常用'";
        else if(type.equals("超级用户"))
        {

        }
        else
        {

        }
            if(textID>0)
                sql+=" and textID >"+textID;

            System.out.println(sql);
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                text txts=null;
                while (rs.next()&&i++<num)
                {
                    txts=new text();
                    txts.setTextID(rs.getInt(1));
                    txts.setSentence(rs.getString(2));
                    txts.setEmotion(rs.getString(3));
                    txts.setFrequency(rs.getString(4));
                    txts.setMaleread(rs.getInt(5));
                    txts.setFemaleread(rs.getInt(6));
                    txts.setSkip(rs.getInt(7));

                    list.add(txts);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return list;
    }
    public List<text> gettexthaveread(int textID,int num,String type)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        List<text> list=new ArrayList<text>();
        int i=0;
        String sql="select * from text where 1=1 ";
        if(type.equals("普通用户"))
            sql+=" and frequency='常用'";
        else if(type.equals("超级用户"))
        {

        }
        else
        {

        }
        if(textID>0)
            sql+=" and textID <"+textID;
        sql+=" order by textID desc";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            text txts=null;
            while (rs.next()&&i++<num)
            {
                txts=new text();
                txts.setTextID(rs.getInt(1));
                txts.setSentence(rs.getString(2));
                txts.setEmotion(rs.getString(3));
                txts.setFrequency(rs.getString(4));
                txts.setMaleread(rs.getInt(5));
                txts.setFemaleread(rs.getInt(6));
                txts.setSkip(rs.getInt(7));
                list.add(txts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
