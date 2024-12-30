package cineplex_accademy.dto;



public class StudentDto {
    private int id;
    private String fname;
    private String lname;
    private String address;
    private String number;
    private int age;
    private String grade;
    private String email;
    private String department;
    private String position;

    public StudentDto() {
    }

    public StudentDto(int id, String fname, String lname, String address, String number, int age, String grade, String email, String department, String position) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.number = number;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.department = department;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
