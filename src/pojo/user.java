package pojo;

/**
 * Created by krumo on 2016/3/16.
 */
public class user {
    private int userID;
    private String userName;
    private String userPwd;
    private String userSex;
    private String userAge;
    private String userBirthplace;
    private String userType;
    private int lasttext;
    private int audionum;

    public user() {
    }

    public user(int userID, String userName, String userPwd, String userSex, String userAge, String userBirthplace, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userBirthplace = userBirthplace;
        this.userType = userType;
        this.lasttext=0;
    }

    public user(int userID, String userName, String userPwd, String userSex, String userAge, String userBirthplace, String userType, int lasttext) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userBirthplace = userBirthplace;
        this.userType = userType;
        this.lasttext = lasttext;
    }

    public user(int userID, String userName, String userPwd, String userSex, String userAge, String userBirthplace, String userType, int lasttext, int audionum) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userBirthplace = userBirthplace;
        this.userType = userType;
        this.lasttext = lasttext;
        this.audionum = audionum;
    }

    public int getAudionum() {
        return audionum;
    }

    public void setAudionum(int audionum) {
        this.audionum = audionum;
    }

    public int getLasttext() {
        return lasttext;
    }

    public void setLasttext(int lasttext) {
        this.lasttext = lasttext;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserBirthplace() {
        return userBirthplace;
    }

    public void setUserBirthplace(String userBirthplace) {
        this.userBirthplace = userBirthplace;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
