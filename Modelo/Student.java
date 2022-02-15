package Modelo;

public class Student {
    private String enrollment;
    private String lastName;
    private String mothersLastName;
    private String names;

    public Student(String enrollment, String lastName, String mothersLastName, String names){
        setEnrollment(enrollment);
        setLastName(lastName);
        setMothersLastName(mothersLastName);
        setNames(names);
    }

    public void setEnrollment(String enrollment){
        this.enrollment = enrollment;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMothersLastName(String mothersLastName){
        this.mothersLastName = mothersLastName;
    }

    public void setNames(String names){
        this.names = names;
    }

    public String getEnrollment(){
        return enrollment;
    }

}