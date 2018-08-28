package lk.ijse.ibs.dto;

public class RegistrationDto extends SuperDto {
    private String regid;
    private String studentid;
    private String regdate;
    private String regfee;
    private String batchid;

    public RegistrationDto() {
    }

    public RegistrationDto(String regid, String studentid, String regdate, String regfee, String batchid) {
        this.regid = regid;
        this.studentid = studentid;
        this.regdate = regdate;
        this.regfee = regfee;
        this.batchid = batchid;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getRegfee() {
        return regfee;
    }

    public void setRegfee(String regfee) {
        this.regfee = regfee;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "regid='" + regid + '\'' +
                ", studentid='" + studentid + '\'' +
                ", regdate='" + regdate + '\'' +
                ", regfee='" + regfee + '\'' +
                ", batchid='" + batchid + '\'' +
                '}';
    }
}
