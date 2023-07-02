package com.example.System_Backend.model;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Data
@CrossOrigin(origins = "*")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int A_id;
    public String Category;
    public String Name;

    @ManyToOne
    @JoinColumn(name = "id")
    public User user;

}
