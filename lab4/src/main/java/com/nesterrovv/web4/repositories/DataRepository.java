package com.nesterrovv.web4.repositories;

import com.nesterrovv.web4.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Integer> {
    void deleteAllByUsername(String username);
    List<Data> getAllByUsername(String username);
}