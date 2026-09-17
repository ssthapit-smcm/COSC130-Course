import java.util.Arrays;

/**
 * Representation of Family
 * 
 * @author Jessica Young Schmidt
 */
public class Family implements Comparable<Family> {
    
    /** Family members */
    private Person[] familyMembers;
    
    /** Street address */
    private String streetAddress;
    
    /** City */
    private String city;
    
    /** State */
    private String state;
    
    /** Zip code */
    private String zipCode; // String since some start with 0

    /**
     * Constructor with all fields
     * 
     * @param familyMembers family members
     * @param streetAddress street address
     * @param city city
     * @param state state
     * @param zipCode zip code
     */
    public Family(Person[] familyMembers, String streetAddress, String city, String state,
            String zipCode) {
        this.familyMembers = familyMembers;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        Arrays.sort(this.familyMembers); // keep family sorted by age
    }

    /**
     * Constructor with address only. No family members.
     * 
     * @param streetAddress street address
     * @param city city
     * @param state state
     * @param zipCode zip code
     */
    public Family(String streetAddress, String city, String state, String zipCode) {
        // empty array of family member and members will be added with the add
        // method
        this(new Person[0], streetAddress, city, state, zipCode);
    }

    /**
     * Adding person to family. Will have to crete a new array in order to add
     * another person.
     * 
     * @param member family member to add
     */
    public void add(Person member) {
        // new array will have one more person
        Person[] updatedFamMembers = new Person[familyMembers.length + 1];
        for (int i = 0; i < familyMembers.length; i++) {
            updatedFamMembers[i] = familyMembers[i];
        }
        updatedFamMembers[updatedFamMembers.length - 1] = member;
        this.familyMembers = updatedFamMembers;
        Arrays.sort(this.familyMembers);// keep family sorted by age
    }

    /**
     * Returns String representation of family
     * 
     * @return String representation of family
     */
    public String toString() {
        String ret = "Family members at " + this.getAddress() + ":";
        for (int i = 0; i < familyMembers.length; i++) {
            ret = ret + "\n" + familyMembers[i];

        }
        return ret;
    }

    /**
     * Whether this and o are equal
     * 
     * @param o Object to compare to this
     * @return true, if both Families have same address and family members. false,
     *         otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Family) {
            Family that = (Family) o;
            // Makes sure that both families are sorted
            Arrays.sort(this.familyMembers);
            Arrays.sort(that.getFamilyMembers());
            return this.streetAddress.equals(that.getStreetAddress())
                    && this.city.equals(that.getCity()) && this.state.equals(this.getState())
                    && this.zipCode.equals(that.getZipCode())
                    && Arrays.equals(this.familyMembers, that.getFamilyMembers());
        } else {
            return false;
        }
    }

    /**
     * Get zip code
     * 
     * @return zip code
     */
    private String getZipCode() {
        return zipCode;
    }

    /**
     * Get state
     * 
     * @return state
     */
    private String getState() {
        return state;
    }

    /**
     * Get city
     * 
     * @return city
     */
    private String getCity() {
        return city;
    }

    /**
     * Get street address
     * 
     * @return street address
     */
    private String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Get family members
     * 
     * @return family members
     */
    private Person[] getFamilyMembers() {
        return familyMembers;
    }

    /**
     * Get full address
     * 
     * @return full address (streetAddress + ", " + city + ", " + state + " " +
     *         zipCode)
     */
    public String getAddress() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode;
    }

    /**
     * This method is used for sorting the Families based on address
     * 
     * @param other The Family object to which this Family is being compared.
     * @return negative value if this Family should be before the other Family,
     *         positive value if this Family should be after the other Family.
     */
    public int compareTo(Family other) {
        return this.getAddress().toString().compareTo(other.getAddress().toString());

    }

}
