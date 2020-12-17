package domain;

public class Student {
    private String sno;
    private String studentName;
    private String password;
    private String className;
    private String ip;
    private int examId;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getIsExamStarting() {
        return isExamStarting;
    }

    public void setIsExamStarting(int isExamStarting) {
        this.isExamStarting = isExamStarting;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public int getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(int isCommit) {
        this.isCommit = isCommit;
    }

    private int isExamStarting;
    private int isLogin;
    private int isCommit;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", className='" + className + '\'' +
                ", ip='" + ip + '\'' +
                ", examId=" + examId +
                ", isExamStarting=" + isExamStarting +
                ", isLogin=" + isLogin +
                ", isCommit=" + isCommit +
                '}';
    }
}
