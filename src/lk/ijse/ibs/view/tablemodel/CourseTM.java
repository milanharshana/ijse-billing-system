package lk.ijse.ibs.view.tablemodel;

public class CourseTM {
    private String courseid;
    private String coursename;
    private String coursetype;
    private String duration;
    private String coursefee;

    public CourseTM() {
    }

    public CourseTM(String courseid, String coursename, String coursetype, String duration, String coursefee) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursetype = coursetype;
        this.duration = duration;
        this.coursefee = coursefee;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCoursefee() {
        return coursefee;
    }

    public void setCoursefee(String coursefee) {
        this.coursefee = coursefee;
    }
}
