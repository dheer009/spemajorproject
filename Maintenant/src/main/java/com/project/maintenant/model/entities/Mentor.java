package com.project.maintenant.model.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Mentor",catalog = "")
public class Mentor
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    @Basic
    @NotNull
    @Column(name = "AddressDetail")
    @JsonRawValue
    private String addressDetail;

    @Basic
    @NotNull
    @Column(name = "Companies")
    @JsonRawValue
    private String companies;

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
    @Column(name = "YearsOfExperience")
    private Integer yearOfExperience;

    @Basic
    @NotNull
    @Column(name = "Fees")
    private Integer fees;



    @ManyToMany
    @JoinTable(name = "mentor_mentees",
            joinColumns = @JoinColumn(name = "mentors_id"),
            inverseJoinColumns = @JoinColumn(name = "menteess_id"))
    private List<Mentee> menteess = new ArrayList<>();



    public Mentor()
    {

    }
    public Mentor(String username, String password, String firstName, String lastName, String addressDetail, String companies, String currentskills, String email, String phoneNumber, String gender, Integer balance, Integer age, Integer yearOfExperience, Integer fees)
    {
        super();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressDetail = addressDetail;
        this.companies = companies;
        this.currentskills = currentskills;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.balance = balance;
        this.age = age;
        this.yearOfExperience = yearOfExperience;
        this.fees = fees;
    }








    public List<Mentee> getMentees() {
        return menteess;
    }

    public void setMentees(List<Mentee> mentees) {
        this.menteess = mentees;
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
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

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public String getCurrentskills() {
        return currentskills;
    }

    public void setCurrentskills(String currentskills) {
        this.currentskills = currentskills;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }


}
