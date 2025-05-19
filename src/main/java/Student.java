public class Student {

    private String first_name;
    private String last_name;
    private String email;
    private String birth_date;


    public Student(String first_name, String last_name, String email, String birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birth_date = birth_date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth_date() {
        return birth_date;
    }


}
