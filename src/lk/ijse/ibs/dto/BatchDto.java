package lk.ijse.ibs.dto;

public class BatchDto extends SuperDto {

    private String Batchid;
    private String courseid;

    private String batchname;
    private int studentlimit;
    private String status;
    private String startdate;

    public BatchDto() {
    }

    public BatchDto(String batchid, String courseid, String batchname, int studentlimit, String status, String startdate) {
        Batchid = batchid;
        this.courseid = courseid;
        this.batchname = batchname;
        this.studentlimit = studentlimit;
        this.status = status;
        this.startdate = startdate;
    }

    public String getBatchid() {
        return Batchid;
    }

    public void setBatchid(String batchid) {
        Batchid = batchid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public int getStudentlimit() {
        return studentlimit;
    }

    public void setStudentlimit(int studentlimit) {
        this.studentlimit = studentlimit;
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

    @Override
    public String toString() {
        return "BatchDto{" +
                "Batchid='" + Batchid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", batchname='" + batchname + '\'' +
                ", studentlimit=" + studentlimit +
                ", status='" + status + '\'' +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}
