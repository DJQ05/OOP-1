import static java.lang.System.out;
import java.util.ArrayList;

public class StudentRecording {

    public static void main(String[] args) {

        boolean isExit = false;
        ArrayList<Student> alStudents = new ArrayList<>();

        Controller.loadStudentsFromFile(alStudents);

        out.println("STUDENT GRADE RECORDING APPLICATION");

        do {
            switch (Controller.displayMenu()) {
                case 'A':
                case 'a':
                    out.println(">> Add Student");
                    if (Controller.addStudent(alStudents)) {
                        out.println("\n>> New student is successfully added.");
                    }
                    break;

                case 'B':
                case 'b':
                    out.println(">> Update Student Info");
                    if (Controller.updateStudent(alStudents)) {
                        out.println("\n>> Student info is successfully updated");
                    }
                    break;

                case 'C':
                case 'c':
                    out.println(">> Delete Student Info");
                    if (Controller.deleteStudent(alStudents)) {
                        out.println("\n>> Student info is successfully deleted");
                    }
                    break;

                case 'D':
                case 'd':
                    out.println(">> Display Student List (Sorted by Name)");
                    Controller.displayStudentSortedName(alStudents, true);
                    break;

                case 'E':
                case 'e':
                    out.println(">> Display Student List (Sorted by GWA)");
                    Controller.displayStudentSortedGWA(alStudents, true);
                    break;

                case 'F':
                case 'f':
                    out.print(">> Display Student List (Top N Students)");
                    Controller.displayStudentTop(alStudents, true);
                    break;

                case 'X':
                case 'x':
                    isExit = true;
                    break;

                default:
                    out.println(">> INPUT ERROR: Invalid Choice");
            }

            if (isExit) {
                Controller.saveStudentsToFile(alStudents);
                out.println(">> Thank you for using our application");
                break;
            }
        } while (true);
    }
}