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
        try {
            Student studentUpdated = studentOperations.getByID(2);
            System.out.println(studentUpdated);

        } catch (NoFoundException e) {
            System.err.println("no found");
        }

    }
}
