package com.example.System_Backend.model;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String Name;
    public int Age;
    public String Gender;
    public String Address;
    public String Zan_id;
    public String P_no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }


    public void setAge(int age) {
        Age = age;
    }
    public int getAge() {
        return Age;
    }



    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getZan_id() {
        return Zan_id;
    }

    public void setZan_id(String zan_id) {
        Zan_id = zan_id;
    }

    public String getP_no() {
        return P_no;
    }

    public void setP_no(String p_no) {
        P_no = p_no;
    }
}
