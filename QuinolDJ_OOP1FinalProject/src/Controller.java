import static java.lang.System.out;
import java.util.ArrayList;
import java.io.*;

public class Controller {
    public static char displayMenu() {
        out.println("-----------------------------------");
        out.println("\nMain Menu:");
        out.println("\t[A] Add Student Grade Record");
        out.println("\t[B] Update Student Grade Record");
        out.println("\t[C] Delete Student Grade Record");
        out.println("\t[D] View Student Grade Records");
        out.println("\t[E] View Student Grade Ranking");
        out.println("\t[F] View Top N Students");
        out.println("\t[X] Quit Application\n");

        out.print("\t>> What would you like to do?: ");
        char choice = KeyInput.getCharUserInput();
        out.println("-----------------------------------");

        return choice;
    }

    // will add a student info
    public static boolean addStudent(ArrayList<Student> alStudents) {
        String studID; // temp var for student no
        String name; // temp var for lastname, firstname and middlename
        char gender; // temp var for gender
        String grade; // temp var for subject grades

        out.println(">> Please enter Student Information ");
        studID = KeyInput.getStringUserInput("Enter Student No.: ");
        Student student = new Student(studID);

        name = KeyInput.getStringUserInput("Enter Lastname: ");
        student.setLastname(name);
        name = KeyInput.getStringUserInput("Enter Firstname: ");
        student.setFirstname(name);
        name = KeyInput.getStringUserInput("Enter Middlename: ");
        student.setMiddlename(name);

        gender = KeyInput.getCharUserInput("\nEnter Gender: ");
        student.setGender(gender);

        grade = KeyInput.getStringUserInput("\nGrade in Science and Technology: ");
        student.setGradeST(grade);
        grade = KeyInput.getStringUserInput("Grade in Mathematics: ");
        student.setGradeMAT(grade);
        grade = KeyInput.getStringUserInput("Grade in English: ");
        student.setGradeENG(grade);
        grade = KeyInput.getStringUserInput("Grade in Filipino: ");
        student.setGradeFIL(grade);
        grade = KeyInput.getStringUserInput("Grade in Makabayan: ");
        student.setGradeMAK(grade);
        student.setAvg();

        alStudents.add(student);

        return true;
    }

    public static boolean updateStudent(ArrayList<Student> alStudents) {
        out.print("Enter Student No.: ");
        String studNo = KeyInput.getStringUserInput(); // get the student no to update

        int index = searchStudent(alStudents, studNo);
        if (index < 0) {
            out.println("\n>> The Student does not exists in the list.");
            return false;
        }
        Student s = alStudents.get(index);

        return modifyStudentField(s);
    }

    // will update the student info
    public static boolean modifyStudentField(Student s) {
        /*
         * FIELD
         * - it is the info that can be updated
         *
         * e.g.
         * lastname, firstname, middlename, gender, subject grade
         */

        boolean isModified = false; // check if already modified

        do {
            displayStudentDetails(s); // call student details
            out.print("\n>> Enter the field no. to edit (Enter '0' to Exit): ");
            int ch = KeyInput.getIntUserInput(); // get what field to update

            String[] field = { "Student No.", "Lastname", "Firstname",
                    "Middlename", "Gender", "Science and Technology grade", "Mathematics grade", "English grade",
                    "Filipino grade", "Makabayan grade" }; // array to prompt the fields

            if (ch >= 1 && ch <= 10) {
                //out.print();
                String stringInput = KeyInput.getStringUserInput("\nEnter the new " + field[ch - 1] + ": "); // update the value by string

                switch (ch) {
                    case 1:
                        s.setStudentNo(stringInput);
                        break;
                    case 2:
                        s.setLastname(stringInput);
                        break;
                    case 3:
                        s.setFirstname(stringInput);
                        break;
                    case 4:
                        s.setMiddlename(stringInput);
                        break;

                    case 6:
                        s.setGradeST(stringInput);
                        break;
                    case 7:
                        s.setGradeMAT(stringInput);
                        break;
                    case 8:
                        s.setGradeENG(stringInput);
                        break;
                    case 9:
                        s.setGradeFIL(stringInput);
                        break;
                    case 10:
                        s.setGradeMAK(stringInput);
                        break;
                }

                isModified = true;
                out.println("\n>>" + field[ch - 1] + " is succesfully modified");

            } else if (ch == 5) {
                char charInput = KeyInput.getCharUserInput("\nEnter the new " + field[ch - 1] + ": "); // update the value by char
                s.setGender(charInput);
                isModified = true;
                out.println("\n>>" + field[ch - 1] + " is succesfully modified");
            } else if (ch == 0)
                break;
            else {
                out.println("\n>> ERROR: Invalid Choice");
            }

        } while (true);
        return isModified;
    }

    // will display student details for update
    public static void displayStudentDetails(Student s) {
        out.println("\n>> Student Details:");
        out.println("[1] StudentNo: " + s.getStudentNo());
        out.println("[2] Lastname: " + s.getLastname());
        out.println("[3] Firstname: " + s.getFirstname());
        out.println("[4] Middlename: " + s.getMiddlename());
        out.println("[5] Gender: " + s.getGender());
        out.println("[6] Science and Technology: " + s.getGradeST());
        out.println("[7] Mathematics: " + s.getGradeMAT());
        out.println("[8] English: " + s.getGradeENG());
        out.println("[9] Filipino: " + s.getGradeFIL());
        out.println("[10] Makabayan: " + s.getGradeMAK());
    }

    // will get the student position for update and delete
    public static int searchStudent(ArrayList<Student> alStudents, String studentNo) {
        for (int i = 0; i < alStudents.size(); i++) {
            if (alStudents.get(i).getStudentNo().equals(studentNo))
                return i;
        }
        return -1;
    }

    // will delete the student info
    public static boolean deleteStudent(ArrayList<Student> alStudents) {
        out.print("Enter the Student No: ");
        String studNo = KeyInput.getStringUserInput(); // get the student no to delete

        int index = searchStudent(alStudents, studNo);

        // check if student no exist
        if (index < 0) {
            out.println("\n>> The Student does not exists in the list.");
            return false;
        }

        Student s = alStudents.get(index); // get the student info
        displayStudentDetails(s);
        out.print("\n>> Delete Student (Enter 'Y' to delete)?: "); // confirm to delete

        char choice = KeyInput.getCharUserInput();

        if (choice == 'Y' || choice == 'y') {
            alStudents.remove(s);
            return true;
        }
        return false;
    }

    public static void displayStudentSortedName(final ArrayList<Student> alStudents,
                                                boolean isSorted) {

        // check if already sorted
        if (isSorted) {
            ArrayList<Student> alSortedStudents = new ArrayList<>(alStudents);
            sortStudentName(alSortedStudents); // call to sort name
            displayStudents(alSortedStudents); // call to display
        } else {
            displayStudents(alStudents); // call to display
        }

    }

    private static void sortStudentName(ArrayList<Student> alStudents) {
        // use bubble sort for sorting the lastname
        for (int i = 0; i < alStudents.size(); i++) {
            for (int j = i + 1; j < alStudents.size(); j++) {
                Student s1 = alStudents.get(i);
                Student s2 = alStudents.get(j);
                if (s1.compareToName(s2) > 0) {
                    alStudents.set(i, s2);
                    alStudents.set(j, s1);
                }
            }
        }
    }

    public static void displayStudentSortedGWA(final ArrayList<Student> alStudents,
                                               boolean isSorted) {

        // check if already sorted
        if (isSorted) {
            ArrayList<Student> alSortedStudents = new ArrayList<>(alStudents);
            sortStudentGWA(alSortedStudents); // call to sort GWa
            displayStudents(alSortedStudents); // call to display
        } else {
            displayStudents(alStudents); // call to display
        }
    }

    private static void sortStudentGWA(final ArrayList<Student> alStudents) {
        // use bubble sort for sorting the GWA
        for (int i = 0; i < alStudents.size(); i++) {
            for (int j = i + 1; j < alStudents.size(); j++) {
                if (alStudents.get(i).getAvg() < alStudents.get(j).getAvg()) {
                    Student temp1 = alStudents.get(i);
                    Student temp2 = alStudents.get(j);
                    alStudents.set(i, temp2);
                    alStudents.set(j, temp1);
                }
            }
        }
    }

    private static void displayStudents(final ArrayList<Student> alStudents) {
        out.println(
                "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");
        out.println(
                "| STUD NO. | NAME                                | M/F |  S&T  |  MAT  |  ENG  |  FIL  |  MAK  |  GWA  |");
        out.println(
                "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");

        // use for each to display
        for (Student s : alStudents) {
            out.print("| " + s.getStudentNo() + " | " + leftFormat(s.getProperName().trim(), 35) + " |  "
                    + s.getGender() + "  |  ");
            out.printf("%3d", s.getGradeST());
            out.print("  |  ");
            out.printf("%3d", s.getGradeMAT());
            out.print("  |  ");
            out.printf("%3d", s.getGradeENG());
            out.print("  |  ");
            out.printf("%3d", s.getGradeFIL());
            out.print("  |  ");
            out.printf("%3d", s.getGradeMAK());
            out.print("  | ");
            out.printf("%5.1f", s.getAvg());
            out.println(" |");
            out.println(
                    "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");
        }
    }

    private static String leftFormat(String s, int length) {
        // for formatting
        for (int i = s.length(); i < length; i++)
            s = s + " ";
        return s;
    }

    public static void displayStudentTop(final ArrayList<Student> alStudents, boolean isSorted) {
        // check if already sorted
        if (isSorted) {
            ArrayList<Student> alSortedStudents = new ArrayList<>(alStudents);
            sortStudentGWA(alSortedStudents); // call to sort GWa
            displayTopStudent(alSortedStudents); // call to display top student
        } else {
            displayTopStudent(alStudents); // call to display top student
        }
    }

    private static void displayTopStudent(final ArrayList<Student> alStudents) {
        int topN = 0;

        out.print("Enter Top N Student: ");
        topN = KeyInput.getIntUserInput(); // get the top n students

        out.println(
                "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");
        out.println(
                "| STUD NO. | NAME                                | M/F |  S&T  |  MAT  |  ENG  |  FIL  |  MAK  |  GWA  |");
        out.println(
                "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");

        // use for loop to display
        for (int i = 0; i < topN; i++) {
            out.print("| " + alStudents.get(i).getStudentNo() + " | "
                    + leftFormat(alStudents.get(i).getProperName().trim(), 35) + " |  "
                    + alStudents.get(i).getGender() + "  |  ");
            out.printf("%3d", alStudents.get(i).getGradeST());
            out.print("  |  ");
            out.printf("%3d", alStudents.get(i).getGradeMAT());
            out.print("  |  ");
            out.printf("%3d", alStudents.get(i).getGradeENG());
            out.print("  |  ");
            out.printf("%3d", alStudents.get(i).getGradeFIL());
            out.print("  |  ");
            out.printf("%3d", alStudents.get(i).getGradeMAK());
            out.print("  | ");
            out.printf("%5.1f", alStudents.get(i).getAvg());
            out.println(" |");
            out.println(
                    "+----------+-------------------------------------+-----+-------+-------+-------+-------+-------+-------+");
        }
    }

    //will load the file from StudentRecord.txt
    public static boolean loadStudentsFromFile(ArrayList<Student> alStudents) {

        try {
            FileReader fr = new FileReader("Student_Record.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                String[] data = line.split("\\|");
                Student student = new Student(data[0]);
                student.setLastname(data[1]);
                student.setFirstname(data[2]);
                student.setMiddlename(data[3]);
                student.setGender(data[4].charAt(0));
                student.setGradeST(data[5]);
                student.setGradeMAT(data[6]);
                student.setGradeENG(data[7]);
                student.setGradeFIL(data[8]);
                student.setGradeMAK(data[9]);
                student.setAvg();

                alStudents.add(student);

                line = br.readLine();
            }
            br.close();
            fr.close();

            return true;
        }

        catch (FileNotFoundException e) {
            out.println("There is no existing records.");
            return false;
        } catch (IOException e) {
            out.println("Unable to access the file.");
            return false;
        }
    }

    //will save the file to Student_Record.txt
    public static boolean saveStudentsToFile(ArrayList<Student> alStudents) {

        try {
            FileWriter fw = new FileWriter("Student_Record.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (Student s : alStudents) {
                String line = s.getStudentNo() + "|" + s.getLastname() + "|" +
                        s.getFirstname() + "|" + s.getMiddlename() + "|" + s.getGender() + "|" + s.getGradeST() + "|"
                        + s.getGradeMAT() + "|" + s.getGradeENG() + "|" + s.getGradeFIL() + "|"
                        + s.getGradeMAK() + "|" + s.getAvg() + "|";

                pw.println(line);
            }
            pw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            out.println("Error on Saving to the file");
            return false;
        }
    }
}