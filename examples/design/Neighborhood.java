import java.util.Arrays;

/**
 * Representation of Neighborhood
 * 
 * @author Jessica Young Schmidt
 */
public class Neighborhood {
    
    /** Families that live in neighborhood */
    private Family[] families;

    /**
     * Add family to neighborhood
     * 
     * @param family Family to add to neighborhood
     */
    public void add(Family family) {
        // new array will have one more family
        int numFamilies = 0;
        if (families != null) {
            numFamilies = families.length;
        }
        Family[] updatedFamilies = new Family[numFamilies + 1];
        for (int i = 0; i < numFamilies; i++) {
            updatedFamilies[i] = families[i];
        }
        updatedFamilies[numFamilies] = family;
        this.families = updatedFamilies;
    }

    /**
     * String representation of Neighborhood
     * 
     * @return String version of Neighborhood
     */
    public String toString() {
        String ret = "\nNeighborhood:";
        for (int i = 0; i < families.length; i++) {
            ret = ret + "\n" + families[i];
        }
        return ret;
    }

    /**
     * Whether this and o are equal
     * 
     * @param o Object to compare to this
     * @return true, if both Neighborhoods have same families. false, otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Neighborhood) {
            Neighborhood that = (Neighborhood) o;
            // Sort both families
            Arrays.sort(this.families);
            Arrays.sort(that.getFamilies());
            return Arrays.equals(this.families, that.getFamilies());
        } else {
            return false;
        }
    }

    /**
     * Get families
     * 
     * @return families
     */
    private Family[] getFamilies() {
        return families;
    }

}
