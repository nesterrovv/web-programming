import beans.TimeBean;
import entity.Result;
import utils.HitValidator;

import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ResultBean {

    private List<Result> resultList;
    private Result newResult;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private final HitValidator validator = new HitValidator();

    public ResultBean() throws IOException {
        connectToDB();
        loadDB();
        newResult = new Result();
    }

     private void connectToDB() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("tableunit");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            System.out.println("Connection to database has been established successfully!");
        } catch (Exception e) {
            System.out.println("Connection to database hasn't been established by the reason: " + e.getMessage());
        }
    }

     private void loadDB() {
        try {
            connectToDB();
            entityTransaction.begin();
            resultList = entityManager.createQuery("SELECT d FROM Result d", Result.class).getResultList();
            entityTransaction.commit();
            System.out.println("Data has been loaded successfully.");
            entityManager.close();
        } catch (Exception e) {
                if (entityTransaction.isActive()) {
                    entityTransaction.rollback();
                }
                System.out.println("Data loading error: " + e.getMessage());
        }
    }


    public void addResults() {
        try {
            connectToDB();
            entityTransaction.begin();
            long startTime = System.nanoTime();
            double time = (System.nanoTime() - startTime);
            if ((validator.checkNull(newResult.getX(), newResult.getY(), newResult.getR())) &&
            validator.checkRange(newResult.getX(), newResult.getY(), newResult.getR())) {
                newResult.setResult(validator.checkResult(newResult.getX(), newResult.getY(), newResult.getR()));
                TimeBean timeBean = new TimeBean();
                newResult.setCurrentTime(timeBean.learnTime(startTime));
                newResult.setExecutionTime(time);
                resultList.add(newResult);
                System.out.println(newResult.toString());
                entityManager.persist(newResult);
                entityTransaction.commit();
                System.out.println("Added");
                entityManager.close();
                newResult = new Result();
            } else {
                System.out.println("Element is incorrect!");
            }
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println("Result adding error: " + e.getMessage());
        }
    }

    public void clearResults() {
        try {
            connectToDB();
            entityTransaction.begin();
            entityManager.createQuery("DELETE FROM Result", Result.class).executeUpdate();
            resultList.clear();
            entityTransaction.commit();
            System.out.println("Results cleaned successfully!");
            entityManager.close();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println("Results cannot be cleaned: " + e.getMessage());

        }
    }

    public Result getNewResult() {
        return newResult;
    }
    public List<Result> getResultList(){
        return resultList;
    }
    public void setResultList(List<Result> resultList){
        this.resultList = resultList;
    }
    public void setNewResult(Result newResult){
        this.newResult = newResult;
    }
}


