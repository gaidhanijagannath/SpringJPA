package com.example.in28minutes.database.databasedemo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA
@NamedQuery(name="find_all_persons",query = "select p from Person p") // *IMP
/*@Table(name = "") here the name of your database table either existing or new one that you have created. */
public class Person {
    @Id
    //persistence provider will determine values based on the type of the primary key attribute i.e Numeric or UUID.
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")  // hibernate will take care of generating values now
    private int id;

    //@Column(name = "emp_name") we can choose diff name for mapping database column to these variables
    private String name;
    private String location;
    private Date birthDate;

    // IMP* = if we are using BeanPropertyRowMapper on bean then it should have null constructor mention on it.
    public Person(){


    }

    //spring jdbc constructor
    public Person(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    //this is constructor for hibernate as its generating 'id' on its own.
    public Person(String name, String location, Date birthDate) {
        super();
        /*this.id = id;*/
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    //returned object in proper value from and not hash value.
    @Override
    public String toString() {
        return  String.format("\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}');
    }
}
