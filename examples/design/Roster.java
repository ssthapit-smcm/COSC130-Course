import java.util.Arrays;

/**
 * Represents a class roster
 * 
 * @author Jessica Young Schmidt
 */
public class Roster {

    /** Current number of students in class */
    private int numStudents;

    /** Students in the class */
    private Student[] students;

    /**
     * Constructs an empty class with enrollment maximum: numStudents
     * 
     * @param numStudents maximum number of students that can enroll in the class
     * @throws IllegalArgumentException if numStudents < 1
     */
    public Roster(int numStudents) {
        if (numStudents < 1) {
            throw new IllegalArgumentException("Invalid number of students");
        }
        this.numStudents = 0;
        students = new Student[numStudents];
    }

    /**
     * Constructs full class with students passed to constructor. It is assumed that
     * all elements of students are non-null.
     * 
     * @param students array of students
     */
    public Roster(Student[] students) {
        this.students = students;
        numStudents = this.students.length;
    }

    /**
     * Adds a student to the class
     * 
     * @param s student who is added to the class
     * @return true, if s is added to the class. false, if s is not added to the
     *         class because the maximum enrollment has already been met
     */
    public boolean addStudent(Student s) {
        if (numStudents < students.length) {
            students[numStudents] = s;
            numStudents++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * String representation of roster
     * 
     * @return String version of roster
     */
    public String toString() {
        String ret = "Roster:";
        for (int i = 0; i < numStudents; i++) {
            ret = ret + "\n" + students[i];
        }
        return ret;
    }

    /**
     * Students that are major students
     * 
     * @param major major examining
     * @return String of all students majoring in major
     */
    public String studentWithMajor(String major) {
        String ret = "Students majoring in " + major + ":";
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getMajor().equals(major)) {
                ret = ret + "\n" + students[i];
            }
        }
        return ret;
    }

    /**
     * Returns number of students in roster
     * 
     * @return number of students in roster
     */
    public int getNumStudents() {
        return numStudents;
    }

    /**
     * Returns Array of Students in Roster
     * 
     * @return students in roster
     */
    private Student[] getStudents() {
        return students;
    }

    /**
     * Returns whether rosters are equal
     * 
     * @param o object to compare to this
     * @return true, if this and o have same students & number of students. false,
     *         otherwise
     */
    public boolean equals(Object o) {
        if (o instanceof Roster) {
            Roster that = (Roster) o;
            return this.numStudents == that.getNumStudents()
                    && Arrays.equals(this.students, that.getStudents());
        } else {
            return false;
        }
    }

}
