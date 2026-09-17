/**
 * Represents a Name
 * 
 * @author Jessica Young Schmidt
 */
public class Name {

    /** First name */
    private String firstName;

    /** Middle initial */
    private char middleInitial;

    /** Last name */
    private String lastName;

    /**
     * Constructor for Name
     * 
     * @param firstName first name
     * @param middleInitial middle initial
     * @param lastName last name
     */
    public Name(String firstName, char middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    /**
     * Sets firstName to first
     * 
     * @param first first name
     */
    public void setFirstName(String first) {
        firstName = first;
    }

    /**
     * Getter method for firstName
     * 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets lastName to last
     * 
     * @param last last name
     */
    public void setLastName(String last) {
        lastName = last;
    }

    /**
     * Getter method for lastName
     * 
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets middleInitial to mid
     * 
     * @param mid middle initial
     */
    public void setMiddle(char mid) {
        middleInitial = mid;
    }

    /**
     * Getter method for middleInitial
     * 
     * @return middle initial
     */
    public char getMiddle() {
        return middleInitial;
    }

    /**
     * String representation of Name in normal order
     * 
     * @return String representation of Name in normal order
     */
    public String getNormalOrder() {
        return firstName + " " + middleInitial + ". " + lastName;
    }

    /**
     * String representation of Name in reverse order
     * 
     * @return String representation of Name in reverse order
     */
    public String getReverseOrder() {
        return lastName + ", " + firstName + " " + middleInitial + ".";
    }

    /**
     * String representation of Name
     * 
     * @return String representation
     */
    public String toString() {
        return getNormalOrder();
    }

    /**
     * Whether this is equal to o
     * 
     * @param o another object
     * @return whether this is equal to o
     */
    public boolean equals(Object o) {
        if (o instanceof Name) {
            Name that = (Name) o;
            return this.firstName.equals(that.getFirstName())
                    && this.lastName.equals(that.getLastName())
                    && this.middleInitial == that.getMiddle();
        } else {
            return false;
        }
    }
}
