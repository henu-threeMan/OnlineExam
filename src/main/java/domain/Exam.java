package domain;

public class Exam {
    private int id;
    private String examName;
    private String startTime;
    private String owner;
    private boolean isPageExist;
    private boolean isAutoStart;
    private boolean isStarting;
    private boolean isFinished;
    private boolean isFiled;
    private boolean isCleaned;

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

    public boolean isPageExist() {
        return isPageExist;
    }

    public void setPageExist(boolean pageExist) {
        isPageExist = pageExist;
    }

    public boolean isAutoStart() {
        return isAutoStart;
    }

    public void setAutoStart(boolean autoStart) {
        isAutoStart = autoStart;
    }

    public boolean isStarting() {
        return isStarting;
    }

    public void setStarting(boolean starting) {
        isStarting = starting;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFiled() {
        return isFiled;
    }

    public void setFiled(boolean filed) {
        isFiled = filed;
    }

    public boolean isCleaned() {
        return isCleaned;
    }

    public void setCleaned(boolean cleaned) {
        isCleaned = cleaned;
    }
}
