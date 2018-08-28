package lk.ijse.ibs.dto;

public class StudentDto extends SuperDto {
    private String studentid;
    private String nameinitials;
    private String fullname;
    private String nic;
    private String address;
    private int homeno;
    private int contact;
    private String email;
    private String dob;
    private String gender;
    private String school;
    private String uni;
    private String fac;
    private String higherquli;

    public StudentDto() {
    }

    public StudentDto(String studentid, String nameinitials, String fullname, String nic, String address, int homeno, int contact, String email, String dob, String gender, String school, String uni, String fac, String higherquli) {
        this.studentid = studentid;
        this.nameinitials = nameinitials;
        this.fullname = fullname;
        this.nic = nic;
        this.address = address;
        this.homeno = homeno;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.school = school;
        this.uni = uni;
        this.fac = fac;
        this.higherquli = higherquli;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getNameinitials() {
        return nameinitials;
    }

    public void setNameinitials(String nameinitials) {
        this.nameinitials = nameinitials;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHomeno() {
        return homeno;
    }

    public void setHomeno(int homeno) {
        this.homeno = homeno;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getHigherquli() {
        return higherquli;
    }

    public void setHigherquli(String higherquli) {
        this.higherquli = higherquli;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentid='" + studentid + '\'' +
                ", nameinitials='" + nameinitials + '\'' +
                ", fullname='" + fullname + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", homeno=" + homeno +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", uni='" + uni + '\'' +
                ", fac='" + fac + '\'' +
                ", higherquli='" + higherquli + '\'' +
                '}';
    }
}
