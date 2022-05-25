package utils;

public class HitValidator {
    public boolean checkResult(double x, double y, double r){
        return (x >= 0 && y >= 0 && x * x + y * y <= r * r) ||
                (x <= 0 && y <= 0 && x >= -r && y >= -r) ||
                (x >= 0 && y <= 0 && y >= (x - r));
    }

    //checking for unwanted values
    public boolean checkRange(double x, double y, double r) {
        if (x < -2 || x > 1.5 || y <= -5 || y >= 5 || r < 1 || r > 3) {
            return false;
        }
        return true;
    }

    public boolean checkNull(double x, double y, double r){
        if (String.valueOf(x) != null && String.valueOf(y) != null && String.valueOf(r) != null){
            return true;
        }
        return false;
    }

}