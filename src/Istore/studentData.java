/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 * SUBSCRIBE OUR YOUTUBE CHANNEL -> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * THANKS FOR YOUR SUPPORT : ) 
 */
public class studentData {

    private Integer EmployeeNum;
    private String year;
    private String course;
    private String firstName;
    private String lastName;
    private String gender;
    private String storeName;
    private String role;
    private String email;
    private String password;
    private Date birth;
    private String status;
    private String image;
    private Double firstSem;
    private Double secondSem;
    private Double finals;
    private String pseudo;
    private int stock;
    private String price;
    private String description;
    private String name;
    private String image_url;

    // MAKE SURE THAT SAME DATATYPE THAT YOU WILL PUT THERE 
    public studentData(Integer EmployeeNum, String year, String course, String firstName, String lastName, String gender, Date birth, String status, String image) {
        this.EmployeeNum = EmployeeNum;
        this.year = year;
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birth = birth;
        this.status = status;
        this.image = image;
    }
 
    public studentData(Integer EmployeeNum, String email, String pseudo, String firstName, String lastName, String gender, String role, String password, String store_name,String image) {
        this.EmployeeNum = EmployeeNum;
        this.email = email;
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.role = role;
        this.password = password;
        this.image = image;
        if (storeName == null) {
            this.storeName = "Free";
        }
    }
    public studentData(Integer EmployeeNum, String year, String course, Double firstSem, Double secondSem, Double finals) {
        this.EmployeeNum = EmployeeNum;
        this.year = year;
        this.course = course;
        this.firstSem = firstSem;
        this.secondSem = secondSem;
        this.finals = finals;
    }

    public studentData(Integer employeeNum, String firstName, String lastName, String storeName, String status) {
        this.EmployeeNum = employeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.storeName = storeName;
        this.status = status;
    }


    public studentData(Integer employeeNum, int stock, String price , String description, String name,String Storename, String image_url) {
        EmployeeNum = employeeNum;
        this.stock = stock;
        this.price=price;
        this.description = description;
        this.name = name;
        this.storeName=Storename;
        this.image_url = image_url;
    }

    public Integer getEmployeeNum() {
        return EmployeeNum;
    }

    public String getYear() {
        return year;
    }

    public String getCourse() {
        return course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirth() {
        return birth;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Double getFirstSem() {
        return firstSem;
    }

    public Double getSecondSem() {
        return secondSem;
    }

    public Double getFinals() {
        return finals;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPseudo() {
        return pseudo;
    }


    public int getStock() {
        return stock;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }
// PLEASE FOLLOW ME IF THE VARS ARE THE SAME TO ME 
}
