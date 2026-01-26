package com.teja.dockerjava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HelloRepository extends JpaRepository<Hello, Integer> {

    @Query("select current_timestamp")
    public String getTime();
}
