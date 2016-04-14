package implementation;

import database.DBconnector;
import pojo.TextAudio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krumo on 2016/3/16.
 */
public class TextAudioimpl {
    public void updatetextaudio(TextAudio ta)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=ta.getAudioID();
        String sql="update TextAudio set userID = ?, textID= ?,relativeAddress=? where AudioID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ta.getUserID());
            pst.setInt(2,ta.getTextID());
            pst.setString(3,ta.getRelativeAddress());
            pst.setInt(4,ta.getAudioID());
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
    public void deletetextaudio(int ID)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="delete from TextAudio where AudioID = ?";
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
    public List<TextAudio> querytextaudio(TextAudio ta)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        List<TextAudio> list=new ArrayList<TextAudio>();
        String sql="select * from TextAudio where 1=1 ";
        if(ta!=null)
        {
            if(ta.getTextID()>0)
                sql+=" and textID = '"+ta.getTextID()+"'";
            if(ta.getUserID()>0)
                sql+=" and userID = '"+ta.getUserID()+"'";
            if(ta.getRelativeAddress()!=null&&ta.getRelativeAddress().length()>0)
                sql+=" and relativeAddress ='"+ta.getRelativeAddress()+"'";
            if(ta.getAudioID()>0)
                sql+=" and AudioID = '"+ta.getAudioID()+"'";

            System.out.println(sql);
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                TextAudio tas=null;
                while (rs.next())
                {
                    tas=new TextAudio();
                    tas.setAudioID(rs.getInt(1));
                    tas.setTextID(rs.getInt(2));
                    tas.setUserID(rs.getInt(3));
                    tas.setRelativeAddress(rs.getString(4));
                    list.add(tas);
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
    public void savetextaudio(TextAudio ta)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="insert into TextAudio(textID,userID,relativeAddress) values(?,?,?)";
        //String sql="insert into users(userID,login_name,password,illegal_time) values('hi','hi','pwd',0)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ta.getTextID());
            pst.setInt(2,ta.getUserID());
            pst.setString(3,ta.getRelativeAddress());
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

    public void createtextaudio(TextAudio ta)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="insert into TextAudio(AudioID,textID,userID,relativeAddress) values(?,?,?,?)";
        //String sql="insert into users(userID,login_name,password,illegal_time) values('hi','hi','pwd',0)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ta.getAudioID());
            pst.setInt(2,ta.getTextID());
            pst.setInt(3,ta.getUserID());
            pst.setString(4,ta.getRelativeAddress());
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
}
