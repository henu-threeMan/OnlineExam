package domain;

public class Exam {
    private int id;
    private String examName;
    private String startTime;
    private String owner;
    private int isPageExist;
    private int isAutoStart;
    private int isStarting;
    private int isFinished;
    private int isFiled;
    private int isCleaned;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getIsPageExist() {
        return isPageExist;
    }

    public void setIsPageExist(int isPageExist) {
        this.isPageExist = isPageExist;
    }

    public int getIsAutoStart() {
        return isAutoStart;
    }

    public void setIsAutoStart(int isAutoStart) {
        this.isAutoStart = isAutoStart;
    }

    public int getIsStarting() {
        return isStarting;
    }

    public void setIsStarting(int isStarting) {
        this.isStarting = isStarting;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public int getIsFiled() {
        return isFiled;
    }

    public void setIsFiled(int isFiled) {
        this.isFiled = isFiled;
    }

    public int getIsCleaned() {
        return isCleaned;
    }

    public void setIsCleaned(int isCleaned) {
        this.isCleaned = isCleaned;
    }
}
