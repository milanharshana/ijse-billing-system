package lk.ijse.ibs.dto;

public class GuardiantDto extends SuperDto {

    private String guardiantid;
    private String studentid;
    private String guardiantname;
    private String homeno;
    private String contact;
    private String designation;
    private String workingplace;
    private String address;


    public GuardiantDto() {
    }

    public GuardiantDto(String guardiantid, String studentid, String guardiantname, String homeno, String contact, String designation, String workingplace, String address) {
        this.guardiantid = guardiantid;
        this.studentid = studentid;
        this.guardiantname = guardiantname;
        this.homeno = homeno;
        this.contact = contact;
        this.designation = designation;
        this.workingplace = workingplace;
        this.address = address;
    }

    public String getGuardiantid() {
        return guardiantid;
    }

    public void setGuardiantid(String guardiantid) {
        this.guardiantid = guardiantid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getGuardiantname() {
        return guardiantname;
    }

    public void setGuardiantname(String guardiantname) {
        this.guardiantname = guardiantname;
    }

    public String getHomeno() {
        return homeno;
    }

    public void setHomeno(String homeno) {
        this.homeno = homeno;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWorkingplace() {
        return workingplace;
    }

    public void setWorkingplace(String workingplace) {
        this.workingplace = workingplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "GuardiantDto{" +
                "guardiantid='" + guardiantid + '\'' +
                ", studentid='" + studentid + '\'' +
                ", guardiantname='" + guardiantname + '\'' +
                ", homeno='" + homeno + '\'' +
                ", contact='" + contact + '\'' +
                ", designation='" + designation + '\'' +
                ", workingplace='" + workingplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
