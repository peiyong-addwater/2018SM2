/*  An example of writing an immutable class.

    An immutable class cannot be modified after its creation, which is useful 
    for avoiding privacy leaks - the ability for another object to modify ours
    without our permission, or in a way that we can't control.

    Author: Matthew De Bono
    Date:   24/8/15
*/

import java.util.*;

public class ImmutablePerson {
    
    // We always use private for instance variables
    private String familyName;
    private String givenName;
    private int age;
    
    public static void main(String args[]) {
        // Let's create a few objects
        ImmutablePerson p1 = new ImmutablePerson("De Bono", "Matt", 23);
        ImmutablePerson p2 = new ImmutablePerson("Schachte", "Peter", 30);
        ImmutablePerson p3 = new ImmutablePerson("Jobs", "Steve");   
        ImmutablePerson p4 = new ImmutablePerson("De Bono", "Matthew", 23);
        
        // We can use toString to print a representation of the object
        System.out.println(p1.toString());
        
        // Java is smart enough that you don't actually need to call the method
        System.out.println(p2);
        
        // Now let's try the equals method; this should print false
        System.out.println(p1.equals(p4));
        
        // Finally, we try our extra method
        String name = p1.getFormalName();
        System.out.println(name);
        
        // Let's check our object one last time
        System.out.println(p1);
        
        // Are we sure our class is immutable?
        
    }
    
    // Constructors are used to construct or build a class
    public ImmutablePerson(String familyName, String givenName, int age) {
        // Here we make use of 'this' to differentiate between variables
        // with the same name
        this.familyName = familyName;
        this.givenName = givenName;
        this.age = age;
    }    
    
    // We can even have multiple constructors
    // Constructors don't need to take information for every variable
    public ImmutablePerson(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
        
        // We should always initialise every variable, 
        // even if we aren't given all the information
        this.age = 0;
    }
    
    // Accessors/Getters
    // These methods are fine, as they don't modify the class
    public String getFamilyName() {
        return familyName;
    }
    
    public String getGivenName() {
        return givenName;
    }
    
    public int getAge() {
        return age;
    }
    
    // It's always useful to define these methods
    // toString should return a String that represents the object
    public String toString() {
        return givenName + " " + familyName + " is " + age + " years old.";
    }
    
    // equals should return true only when the two objects are considered equal
    // Not all variables need to be equal though, you can decide on equality
    // however you like
    public boolean equals(ImmutablePerson p) {
        return (this.familyName.equals(p.getFamilyName())) && 
               (this.givenName.equals(p.getGivenName())) &&
               (this.age == p.getAge());
    }
    
    // An example method that could be used for this class
    public String getFormalName() {
        givenName = "Sir " + givenName;
        return givenName;
    }
}
