package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MYRESULTS")
public class Result implements Serializable {
        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "make_id")
        private int id;

        @Column(name = "valueX")
        private double x;

        @Column(name = "valueY")
        private double y;

        @Column(name = "valueR")
        private double r;

        @Column(name = "currTime", length = 100)
        private String currentTime;

        @Column(name = "execTime")
        private double time;

        @Column(name = "myResult", length = 100)
        private boolean result;

    public Result() {}

    public Result(double x, double y, double r, String currentTime, double time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.time = time;
    }

    @Override
        public String toString() {
            return "Result{" +
                "id" + id +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", currentTime='" + currentTime +
                ", time=" + time +
                ", result=" + result +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
                return x;
        }

        public void setX(double x) {
                this.x = x;
        }
        public double getY() {
                return y;
        }

        public void setY(double y) {
                this.y = y;
        }

        public double getR() {
                return r;
        }

        public void setR(double r) {
                this.r = r;
        }

        public String getCurrentTime() {
                return currentTime;
        }

        public void setCurrentTime(String currentTime) {
                this.currentTime = currentTime;
        }

        public double getExecutionTime() {
                return time;
        }

        public void setExecutionTime(double time) {
                this.time = time;
        }

        public boolean isResult() {
                return result;
        }

        public void setResult(boolean result) {
                this.result = result;
        }


}