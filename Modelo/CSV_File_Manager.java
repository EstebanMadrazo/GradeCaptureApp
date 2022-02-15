package Modelo;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_File_Manager {
    public static final String SPLIT=",";


    public boolean readStudentList(ArrayList<Student> students, String path)throws IOException{
        boolean wasSaved = false;
        BufferedReader br = null;
        try {
            File file = new File(path);
            if(this.isEmpty(file)){
                System.out.println("El archivo esta vacio, no se puede obtener la lista de alumnos \n");
                wasSaved = false;
            }else{
                br =new BufferedReader(new FileReader(path));
                String line = br.readLine();
                boolean firstTime = true;
                while (null!=line) {
                    if(firstTime){
                        line = br.readLine();
                        firstTime = false;
                    }
                    String [] row = line.split(SPLIT);
                    String enrollment = row[0];
                    String lastName = row[1];
                    String mothersLastName = row[2];
                    String names = row[3];

                    if(enrollment.length() != 0){
                        if(lastName != null){
                            if(mothersLastName != null){
                                if(names != null){
                                    Student student = new Student(enrollment,lastName,mothersLastName,names);
                                    students.add(student);
                                    line = br.readLine();
                                    wasSaved = true;
                                }else{
                                    System.out.println("La columna de los nombres esta vacia, no se puede capturar");
                                    wasSaved = false;
                                }
                            }else{
                                System.out.println("La columna del apellido materno esta vacia, no se puede capturar");
                                wasSaved = false;
                            }
                        }else{
                            System.out.println("La columna de el apellido paterno esta vacia, no se puede capturar");
                            wasSaved = false;
                        }
                    }else{
                        System.out.println("La columna de la matricula esta vacia, no se puede capturar");
                        wasSaved = false;
                    }
                }
            }
            
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            if (null!=br) {
                br.close();
            }
        }
        return wasSaved;
    } 

    public void writeGradeList(ArrayList<GradeRecord> grades)throws IOException{
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(new File("Calificaciones.csv"));
            bw = new BufferedWriter(fw);
            for(GradeRecord gradeRecord : grades){
                String data = gradeRecord.getString();
                bw.write(data);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (null!=bw) {
                bw.close();
            }
        }
    }
    public boolean isEmpty(File file){
        return file.length() == 0;
    }
}