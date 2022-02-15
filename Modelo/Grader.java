package Modelo;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Grader {
    
    public void showMain() throws IOException{
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<GradeRecord> grades = new ArrayList<GradeRecord>();
        CSV_File_Manager csv = new CSV_File_Manager();
        boolean wasGraded = false;
        boolean wasCreated = false;
        if(csv.readStudentList(students,"Alumnos.csv")){
            while(option != 3){
                System.out.println("Ingresa el numero de la accion de quedea realizar \n");
                System.out.println("1.Capturar calificaciones \n");
                System.out.println("2.Generar CSV \n");
                System.out.println("3.salir \n");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        recordGrades(students,grades);
                        wasGraded = true;
                        break;
                    case 2:
                        if(wasGraded){
                            csv.writeGradeList(grades);
                            wasCreated =true;
                        }else{
                            System.out.println("No puede gnenerar el CSV si no ha registrado todas las calificaciones");
                        }
                        break;
                    case 3:
                        if(wasGraded){
                            if(wasCreated == false){
                                System.out.println("¿Estas seguro que quiere salir?, No se ha generado el archivo de califiaciones");
                                System.out.println("3. Si, 0. No");
                                option = scanner.nextInt();
                            }
                        }
                        break;
                    default:
                        System.out.println("No existe esa opción, vuelva a intentarlo");
                        break;
                }
            }
        }else{
            System.out.println("No se puden capturar las calificaciones si no hay datos del CSV de alumnos");
        } 
    }

    public void recordGrades(ArrayList<Student> students, ArrayList<GradeRecord> grades){
        Scanner scanner = new Scanner(System.in);
        int grade = 0;
        for(Student student: students){
            System.out.println("ingrese la calificación del alumno: " + student.getEnrollment()+ "\n");
            grade = scanner.nextInt();
            while(grade > 100 || grade < 0){
                System.out.println("Calificación incorrecta, vuelva intentarlo");
                grade = scanner.nextInt();
            }
            GradeRecord gradeRecord = new GradeRecord(student.getEnrollment(), "Diseño de software", grade);
            grades.add(gradeRecord);
        }
    }
}