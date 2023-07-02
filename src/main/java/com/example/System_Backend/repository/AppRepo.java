package com.example.System_Backend.repository;

import com.example.System_Backend.model.Application;
import com.example.System_Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppRepo  extends JpaRepository<Application,Integer> {
}
