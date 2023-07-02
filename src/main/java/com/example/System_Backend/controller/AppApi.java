package com.example.System_Backend.controller;


import com.example.System_Backend.model.Application;
import com.example.System_Backend.model.User;
import com.example.System_Backend.repository.AppRepo;
import com.example.System_Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Application")
public class AppApi {

    @Autowired
    public AppRepo appRepo;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<Application> applicationList = appRepo.findAll();

            if (applicationList.isEmpty()) {
                return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(applicationList, HttpStatus.OK);
            }
        } catch (Exception pandu) {
            return new ResponseEntity<>("Network Error", HttpStatus.BAD_REQUEST);
        }
    }

    //Get Application using Id
    @GetMapping("/{A_id}")
    public ResponseEntity<?> getByID(@PathVariable int A_id) {
        try {
            Optional<Application> optionalApplication = appRepo.findById(A_id);

            if (optionalApplication.isPresent()) {
                return new ResponseEntity<>(optionalApplication, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Application not foound", HttpStatus.NOT_FOUND);
            }
        } catch (Exception punda) {
            return new ResponseEntity<>("Application are not added", HttpStatus.BAD_REQUEST);
        }

    }

    //add Application in table
    @PostMapping("/Add")
    public ResponseEntity<?> AddApplication(@RequestBody Application application) {
        try {
            Application application1= appRepo.save(application);
            return new ResponseEntity<>("Data inserted", HttpStatus.OK);

        } catch (Exception pindua) {
            return new ResponseEntity<>("Application not added", HttpStatus.BAD_REQUEST);

        }

    }

    @DeleteMapping("/{A_id}")
    public ResponseEntity<?> deleteApplication(@PathVariable int A_id) {
        try {
            appRepo.deleteById(A_id);
            return new ResponseEntity<>("Application deleted", HttpStatus.OK);

        } catch (Exception pinduka) {
            return new ResponseEntity<>("Application not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{A_id}")
    public ResponseEntity<?> updateApplication(@PathVariable int A_id, @RequestBody Application application) {
        try {
            if (appRepo.findById(A_id).isPresent()) {
               Application application1= appRepo.save(application);
                application1.setA_id(A_id);
                return new ResponseEntity<>("Application updated", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Hogo",HttpStatus.CONFLICT);
            }
        } catch (Exception exception){
            return new ResponseEntity<>("Uzembe ",HttpStatus.BAD_REQUEST);
        }
    }



}


