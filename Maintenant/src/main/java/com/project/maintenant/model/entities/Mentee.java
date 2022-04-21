package com.project.maintenant.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//n other words, the @Basic annotation on a field or a property signifies that it's a basic type and Hibernate should use the standard mapping for its persistence
@Entity
@Table(name="Mentee",catalog = "")
public class Mentee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id//pk
    @Column(name = "Id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "Username", unique=true)
    private String username;

    @Basic
    @NotNull
    @Column(name = "Password")
    private String password;

    @Basic
    @NotNull
    @Column(name = "FirstName")
    private String firstName;

    @Basic
    @NotNull
    @Column(name = "LastName")
    private String lastName;

   /* @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;

    @Basic
    @NotNull
    @Column(name = "CurrentSkills", columnDefinition = "json")
    @JsonRawValue
    private String currentskills;*/

    @Basic
    @NotNull
    @Column(name = "AddressDetail")
    @JsonRawValue
    private String addressDetail;

    @Basic
    @NotNull
    @Column(name = "CurrentSkills")
    @JsonRawValue
    private String currentskills;

    @Basic
    @NotNull
    @Column(name = "Email",unique = true)
    private String email;

    @Basic
    @NotNull
    @Column(name = "PhoneNumber",unique = true)
    private String phoneNumber;

    @Basic
    @NotNull
    @Column(name = "Gender")
    private String gender;

    @Basic
    @NotNull
    @Column(name = "Balance")
    private Integer balance;

    @Basic
    @NotNull
    @Column(name = "Age")
    private Integer age;

    @Basic
    @NotNull
    @Column(name = "Type")
    private String type;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "mentee_fk")
//    private Mentor mentor;

    @JsonIgnore
    @ManyToMany(mappedBy = "menteess")
    private List<Mentor> mentors = new ArrayList<>();


    public Mentee()
    {

    }
    public Mentee(String username, String password, String firstName, String lastName, String addressDetail, String currentskills, String email, String phoneNumber, String gender, int balance, int age, String type)
    {
        super();
       // this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressDetail = addressDetail;
        this.currentskills = currentskills;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.balance = balance;
        this.age = age;
        this.type = type;
    }



    public String getCurrentskills() {
        return currentskills;
    }

    public void setCurrentskills(String currentskills) {
        this.currentskills = currentskills;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

   public long getId() {
        return id;
    }

//   public void setId(long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }

    public void setType(String type) {
        this.type = type;
    }
}
