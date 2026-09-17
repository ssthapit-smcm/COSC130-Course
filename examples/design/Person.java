/**
 * Representation of a person
 * 
 * @author Jessica Young Schmidt
 */
public class Person implements Comparable<Person> {
    
    /** Name of person */
    private Name name;
    
    /** Age of person */
    private int age;

    /**
     * Constructor for Person
     * 
     * @param name name of the person
     * @param age age of the person
     */
    public Person(Name name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructor of Person
     * 
     * @param firstName first name of person
     * @param middleInitial middle initial of person
     * @param lastName last name of person
     * @param age age of person
     */
    public Person(String firstName, char middleInitial, String lastName, int age) {
        this(new Name(firstName, middleInitial, lastName), age);
    }

    /**
     * Get name of person
     * 
     * @return name of person
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Get age of person
     * 
     * @return age of person
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Increase age of person by one
     */
    public void increaseAge() {
        this.age++;
    }

    /**
     * Returns String representation of person
     * @return String representation of person [name (age)]
     */
    public String toString() {
        return name.toString() + " (" + age + ")";
    }

    /**
     * This method is used for sorting the Persons. Decreasing age then by full
     * name
     * 
     * @param other The Person object to which this Person is being compared.
     * @return negative value if this Person should be before the other Person,
     *         positive value if this Person should be after the other Person.
     */
    public int compareTo(Person other) {
        if (this.age != other.age) {
            return other.age - this.age;
        } else {
            return this.name.toString().compareTo(other.getName().toString());
        }
    }

    /**
     * Whether this and o are equal
     * 
     * @param o Object to compare to this
     * @return true, if both Persons have same name and age. false, otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person that = (Person) o;
            return this.name.equals(that.getName()) && this.age == that.getAge();
        } else {
            return false;
        }
    }

}
