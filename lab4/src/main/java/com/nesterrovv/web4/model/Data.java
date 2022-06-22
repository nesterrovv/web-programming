package com.nesterrovv.web4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Data implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private Double x;
    @Column(nullable = false)
    private Double y;
    @Column(nullable = false)
    private Double r;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String answer;
    @Column(nullable = false)
    private String username;

    public Data(){

    }

    public Data(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String getUsername() {
        return username;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public String getTime() {
        return time;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private boolean rectangle(double x, double y, double r) {
        return x <= 0 && y >= 0 && x >= (-1*r) && y <= r;
    }

    private boolean triangle(double x, double y, double r) {
        return x >= 0 && y <= 0 && (y >= x - r);
    }

    private boolean circle(double x, double y, double r) {
        return x >= 0 && y >= 0 && (x * x + y * y <= r * r);
    }

    public void checkAll() {
        if (rectangle(x, y, r) || triangle(x, y, r) || circle(x, y, r)) {
            answer = "да";
        } else answer = "нет";
    }

    @Override
    public String toString() {
        return "Data{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", time=" + time +
                ", answer=" + answer +
                '}';
    }

    @Override
    public int hashCode() {
        return x.hashCode() + y.hashCode() +
                r.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Data) {
            Data dataObj = (Data) obj;
            return x.equals(dataObj.getX()) &&
                    y.equals(dataObj.getY()) &&
                    r.equals(dataObj.getR()) &&
                    time.equals(dataObj.getTime()) &&
                    answer.equals(dataObj.getAnswer());
        }
        return false;
    }
}