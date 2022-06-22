package com.nesterrovv.web4.services;

import com.nesterrovv.web4.model.Data;
import com.nesterrovv.web4.repositories.DataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataService {
    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public boolean saveData(Data data) {
        dataRepository.save(data);
        return true;
    }

    @Transactional
    public void deleteData(String username) {
        dataRepository.deleteAllByUsername(username);
    }

    @Transactional
    public List<Data> getData(String username) {
        return dataRepository.getAllByUsername(username);
    }
}