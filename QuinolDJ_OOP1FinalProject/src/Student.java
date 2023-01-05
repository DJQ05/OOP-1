public class Student {
    // Fields
    private String studentNo;
    private String lastname;
    private String firstname;
    private String middlename;
    private char gender;
    private int gradeST;
    private int gradeMAT;
    private int gradeENG;
    private int gradeFIL;
    private int gradeMAK;
    private double avg;

    // Constructors
    public Student(String studentNo, String lastname, String firstname,
                   String middlename, char gender) {
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.gender = Character.toUpperCase(gender);
    }

    public Student(String studentNo) {
        this(studentNo, "", "", "", 'X');
    }

    public Student(String studentNo, String lastname, String firstname) {
        this(studentNo, lastname, firstname, "N/A", 'X');
    }

    public Student(String studentNo, String lastname, String firstname,
                   char gender) {
        this(studentNo, lastname, firstname, "N/A", gender);
    }

    // Getters and Setters
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = Character.toUpperCase(gender);
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = ((gradeST * 2) + (gradeMAT * 2) + (gradeENG * 1.5) + (gradeFIL * 1.5) + (gradeMAK * 4)) / 11;
    }

    public int getGradeMAK() {
        return gradeMAK;
    }

    public void setGradeMAK(String data) {
        this.gradeMAK = Integer.valueOf(data);
    }

    public int getGradeFIL() {
        return gradeFIL;
    }

    public void setGradeFIL(String data) {
        this.gradeFIL = Integer.valueOf(data);
    }

    public int getGradeENG() {
        return gradeENG;
    }

    public void setGradeENG(String data) {
        this.gradeENG = Integer.valueOf(data);
    }

    public int getGradeMAT() {
        return gradeMAT;
    }

    public void setGradeMAT(String data) {
        this.gradeMAT = Integer.valueOf(data);
    }

    public int getGradeST() {
        return gradeST;
    }

    public void setGradeST(String data) {
        this.gradeST = Integer.valueOf(data);
    }

    // public method
    public String getProperName() {
        return lastname.toUpperCase() + ", " + firstname.toUpperCase()
                + " " + getInitials(middlename);
    }

    public int compareToName(Student s) {
        return this.getProperName().compareTo(s.getProperName());
    }


    // private method
    private String getInitials(String name) {
        String initials = "";
        name = name.toUpperCase().trim();
        int space_index = name.indexOf(" ");
        while (space_index > 0) {
            String word = name.substring(0, space_index);
            initials = initials + word.charAt(0) + ".";

            name = name.substring(space_index + 1);
            space_index = name.indexOf(" ");
        }
        return initials + name.charAt(0) + ".";
    }
}