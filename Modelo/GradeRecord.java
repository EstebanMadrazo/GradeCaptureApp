package Modelo;

public class GradeRecord {
    private String enrollment;
    private String subjetc;
    private int grade;

    public GradeRecord(String enrollment, String subjetc, int grade){
        setEnrollment(enrollment);
        setSubject(subjetc);
        setGrade(grade);
    }

    public void setEnrollment(String enrollment){
        this.enrollment = enrollment;
    }

    public void setSubject(String subjetc){
        this.subjetc = subjetc;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public String getEnrollment(){
        return enrollment;
    }

    public String getSubject(){
        return subjetc;
    }

    public int getGrade(){
        return grade;
    }

    public String getString(){
        String data = getEnrollment() + "," + getSubject() + "," + String.valueOf(getGrade());
        return data;
    }
}