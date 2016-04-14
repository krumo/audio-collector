package implementation;

import database.DBconnector;
import pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krumo on 2016/3/16.
 */
public class userimpl {
    public void updateuser(user ur)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=ur.getUserID();
        String sql="update user set userName = ?, userPwd= ?, userSex= ? ,userAge=?,userBirthplace=? where userID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,ur.getUserName());
            pst.setString(2,ur.getUserPwd());
            pst.setString(3,ur.getUserSex());
            pst.setString(4,ur.getUserAge());
            pst.setString(5,ur.getUserBirthplace());
            //pst.setString(6,ur.getUserType());
            pst.setInt(6,ur.getUserID());
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
    public void updateuserlasttext(user ur)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        int id=ur.getUserID();
        String sql="update user set lasttext=?,audionum=? where userID= ?";
        System.out.println(sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ur.getLasttext());
            pst.setInt(2,ur.getAudionum());
            pst.setInt(3,ur.getUserID());
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
    public void deleteuser(int userID)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="delete from user where userID = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,userID);
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
    public List<user> queryuser(user ur)
    {
        ArrayList<user> buses=new ArrayList<user>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        List<user> list=new ArrayList<user>();
        String sql="select * from user where 1=1 ";
        if(ur!=null)
        {
            if(ur.getUserID()>0)
                sql+=" and userID = '"+ur.getUserID()+"'";
            if(ur.getUserName()!=null&&ur.getUserName().length()>0)
                sql+=" and userName like '%"+ur.getUserName()+"%'";
            if(ur.getUserPwd()!=null&&ur.getUserPwd().length()>0)
                sql+=" and userPwd ='"+ur.getUserPwd()+"'";
            if(ur.getUserSex()!=null&&ur.getUserSex().length()>0)
                sql+=" and userSex ='"+ur.getUserSex()+"'";
            if(ur.getUserAge()!=null&&ur.getUserAge().length()>0)
                sql+=" and userAge = '"+ur.getUserAge()+"'";
            if(ur.getUserBirthplace()!=null&&ur.getUserBirthplace().length()>0)
                sql+=" and userBirthplace ='"+ur.getUserBirthplace()+"'";
            if(ur.getUserType()!=null&&ur.getUserType().length()>0)
                sql+=" and userType ='"+ur.getUserType()+"'";
            if(ur.getLasttext()>0)
                sql+=" and lasttext = "+ur.getLasttext();
            if(ur.getAudionum()>-1)
                sql+=" and audionum = "+ur.getAudionum();
            System.out.println(sql);
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                user urs=null;
                while (rs.next())
                {
                    urs=new user();
                    urs.setUserID(rs.getInt(1));
                    urs.setUserName(rs.getString(2));
                    urs.setUserPwd(rs.getString(3));
                    urs.setUserSex(rs.getString(4));
                    urs.setUserAge(rs.getString(5));
                    urs.setUserBirthplace(rs.getString(6));
                    urs.setUserType(rs.getString(7));
                    urs.setLasttext(rs.getInt(8));
                    urs.setAudionum(rs.getInt(9));
                    list.add(urs);
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

    public List<user> checkuser(user ur)
    {
        ArrayList<user> buses=new ArrayList<user>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        List<user> list=new ArrayList<user>();
        String sql="select * from user where 1=1 ";
        if(ur!=null)
        {
            if(ur.getUserID()>0)
                sql+=" and userID = '"+ur.getUserID()+"'";
            if(ur.getUserName()!=null&&ur.getUserName().length()>0)
                sql+=" and userName = '"+ur.getUserName()+"'";
            if(ur.getUserPwd()!=null&&ur.getUserPwd().length()>0)
                sql+=" and userPwd ='"+ur.getUserPwd()+"'";
            if(ur.getUserSex()!=null&&ur.getUserSex().length()>0)
                sql+=" and userSex ='"+ur.getUserSex()+"'";
            if(ur.getUserAge()!=null&&ur.getUserAge().length()>0)
                sql+=" and userAge = '"+ur.getUserAge()+"'";
            if(ur.getUserBirthplace()!=null&&ur.getUserBirthplace().length()>0)
                sql+=" and userBirthplace ='"+ur.getUserBirthplace()+"'";
            if(ur.getUserType()!=null&&ur.getUserType().length()>0)
                sql+=" and userType ='"+ur.getUserType()+"'";
            if(ur.getLasttext()>0)
                sql+=" and lasttext = "+ur.getLasttext();
            if(ur.getAudionum()>-1)
                sql+=" and audionum = "+ur.getAudionum();
            System.out.println(sql);
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                user urs=null;
                while (rs.next())
                {
                    urs=new user();
                    urs.setUserID(rs.getInt(1));
                    urs.setUserName(rs.getString(2));
                    urs.setUserPwd(rs.getString(3));
                    urs.setUserSex(rs.getString(4));
                    urs.setUserAge(rs.getString(5));
                    urs.setUserBirthplace(rs.getString(6));
                    urs.setUserType(rs.getString(7));
                    urs.setLasttext(rs.getInt(8));
                    urs.setAudionum(rs.getInt(9));
                    list.add(urs);
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
    public void saveuser(user ur)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="insert into user(userID,userName,userPwd,userSex,userAge,userBirthplace,userType,lasttext,audionum) values(?,?,?,?,?,?,?,?,?)";
        //String sql="insert into users(userID,login_name,password,illegal_time) values('hi','hi','pwd',0)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ur.getUserID());
            pst.setString(2,ur.getUserName());
            pst.setString(3,ur.getUserPwd());
            pst.setString(4,ur.getUserSex());
            pst.setString(5,ur.getUserAge());
            pst.setString(6,ur.getUserBirthplace());
            pst.setString(7,ur.getUserType());
            pst.setInt(8,ur.getLasttext());
            pst.setInt(9,ur.getAudionum());
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

    public void createuser(user ur)
    {
        Connection conn=null;
        PreparedStatement pst=null;
        DBconnector dbcon=new DBconnector();
        conn=dbcon.getConnection();
        String sql="insert into user(userName,userPwd,userSex,userAge,userBirthplace,userType,lasttext,audionum) values(?,?,?,?,?,?,?,?)";
        //String sql="insert into users(userID,login_name,password,illegal_time) values('hi','hi','pwd',0)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,ur.getUserName());
            pst.setString(2,ur.getUserPwd());
            pst.setString(3,ur.getUserSex());
            pst.setString(4,ur.getUserAge());
            pst.setString(5,ur.getUserBirthplace());
            pst.setString(6,ur.getUserType());
            pst.setInt(7,ur.getLasttext());
            pst.setInt(8,ur.getAudionum());
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
