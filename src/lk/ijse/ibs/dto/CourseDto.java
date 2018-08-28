package lk.ijse.ibs.dto;

public class CourseDto extends SuperDto{
    private String course_id;
    private String course_name;
    private String course_type;
    private String course_fee;
    private String duration;

    public CourseDto() {
    }

    public CourseDto(String course_id, String course_name, String course_type, String course_fee, String duration) {
        this.setCourse_id(course_id);
        this.setCourse_name(course_name);
        this.setCourse_type(course_type);
        this.setCourse_fee(course_fee);
        this.setDuration(duration);
    }


    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(String course_fee) {
        this.course_fee = course_fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
