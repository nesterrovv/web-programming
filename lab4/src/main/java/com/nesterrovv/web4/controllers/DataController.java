package com.nesterrovv.web4.controllers;

import com.nesterrovv.web4.DTO.DataDTO;
import com.nesterrovv.web4.config.jwt.JWTProvider;
import com.nesterrovv.web4.model.Data;
import com.nesterrovv.web4.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/data")
public class DataController {
    private final DataService dataService;
    private final JWTProvider jwtProvider;

    public DataController(DataService dataService, JWTProvider jwtProvider) {
        this.dataService = dataService;
        this.jwtProvider = jwtProvider;
    }

    @CrossOrigin
    @PostMapping("/add-data")
    private ResponseEntity<String> addData(@Valid @RequestBody DataDTO dataDTO, HttpServletRequest request) {
        double x = dataDTO.getX();
        double y = dataDTO.getY();
        double r = dataDTO.getR();
        Data data = new Data(x, y, r);
        data.checkAll();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        data.setTime(time);
        data.setUsername(jwtProvider.getLoginFromToken(request.getHeader("Authorization").substring(7)));
        dataService.saveData(data);
        return new ResponseEntity<>("Точка успешно добавлена", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get-data")
    private ResponseEntity<List<Data>> getData(HttpServletRequest request) {
        String username = jwtProvider.getLoginFromToken(request.getHeader("Authorization").substring(7));
        List<Data> mass = dataService.getData(username);
        return new ResponseEntity<>(mass, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    private ResponseEntity<String> deleteData(HttpServletRequest request) {
        String username = jwtProvider.getLoginFromToken(request.getHeader("Authorization").substring(7));
        dataService.deleteData(username);
        return new ResponseEntity<>("Точки пользователя удалены", HttpStatus.OK);
    }
}