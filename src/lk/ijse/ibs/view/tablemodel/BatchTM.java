package lk.ijse.ibs.view.tablemodel;

public class BatchTM {
    private String batchid;
    private String batchname;
    private String course;
    private String status;
    private String startdate;

    public BatchTM() {
    }

    public BatchTM(String batchid, String batchname, String course, String status, String startdate) {
        this.batchid = batchid;
        this.batchname = batchname;
        this.course = course;
        this.status = status;
        this.startdate = startdate;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
}
