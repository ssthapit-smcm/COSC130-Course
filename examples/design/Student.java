/**
 * Class representing student
 * 
 * @author Jessica Young Schmidt
 */
public class Student {

    /** Name of student */
    private Name name;

    /** Major of student */
    private String major;

    /** Graduation year of student */
    private int gradYear;

    /**
     * Student constructor
     * 
     * @param name name of student
     * @param major major of student
     * @param gradYear graduation year of student
     */
    public Student(Name name, String major, int gradYear) {
        this.name = name;
        this.major = major;
        this.gradYear = gradYear;
    }

    /**
     * Student constructor - major is null, graduation year is 0
     * 
     * @param name name of student
     */
    public Student(Name name) {
        this(name, null, 0);
    }

    /**
     * Return student name
     * 
     * @return student name
     */
    public Name getName() {
        return name;
    }

    /**
     * Set major of student
     * 
     * @param major given major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Return major of student
     * 
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set graduation year of student
     * 
     * @param gradYear given graduation year
     */
    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * Return graduation year
     * 
     * @return graduation year
     */
    public int getGradYear() {
        return gradYear;
    }

    /**
     * String representation of student
     * 
     * @return String representation of student
     */
    public String toString() {
        return name + ": " + major + " (" + gradYear + ")";
    }

    /**
     * Whether o and this are equivalent (equal names, graduation years, majors)
     * 
     * @param o other object
     * @return whether o and this are equivalent
     */
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student that = (Student) o;
            return this.name.equals(that.getName()) && this.gradYear == that.getGradYear()
                    && this.major.equals(that.getMajor());
        } else {
            return false;
        }
    }

}
