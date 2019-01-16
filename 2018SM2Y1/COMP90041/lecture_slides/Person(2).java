/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardemo;

/**
 *
 * @author thomaschristy
 */
public class Person
{

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private Address home;
    private  int personNumber;

    private static int personCount = 0;

    @Override
    public String toString()
    {
        return "My name is " + firstName + ", and my number is " + personNumber;
    }

    public Person()
    {
        personCount++;
        personNumber = personCount;

    }

    public Person(String fn)
    {
        personCount++;
        //personNumber = personCount;
        firstName = fn;
    }
    
    public Person(String firstName, String lastName)
    {
        personCount++;
        personNumber = personCount;
        this.lastName = lastName;
    }

    public static int getPersonCounter()
    {
        
        return personCount;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Address getHome()
    {
        return home;
    }

    public void setHome(Address home)
    {
        this.home = home;
    }

}
