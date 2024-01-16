package hibernateCRUD.example;

import hibernateCRUD.DAO.StudentDAOImpl;
import hibernateCRUD.entity.Student;
import hibernateCRUD.exceptions.NoFoundException;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("classroom_persistence");
        StudentDAOImpl studentOperations = new StudentDAOImpl(factory);
        

    }
}
