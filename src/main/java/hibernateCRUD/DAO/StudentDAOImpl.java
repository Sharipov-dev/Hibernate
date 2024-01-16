package hibernateCRUD.DAO;

import hibernateCRUD.entity.Student;
import hibernateCRUD.exceptions.NoFoundException;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class StudentDAOImpl implements StudentDAO{
    private final EntityManagerFactory factory;
    private EntityManager manager;
    public StudentDAOImpl(EntityManagerFactory factory){
        this.factory = factory;
        manager = factory.createEntityManager();

    }

    @Override
    public void save(Student student) {
        try{
            manager.getTransaction().begin();
            manager.persist(student);
            manager.getTransaction().commit();
        }
        catch(Throwable h){
            manager.getTransaction().rollback();
            h.printStackTrace();
        }
    }

    @Override
    public Student getByID(int id) throws NoFoundException {


            Student student = manager.find(Student.class, id);
            if (student != null){
                return student;
            }
            throw new NoFoundException("No such student");



    }

    @Override
    public void update(Student student) {
        try{
            Student found = this.getByID(student.getId());
            manager.getTransaction().begin();
            found.setName(student.getName());
            manager.merge(found);
            manager.getTransaction().commit();
        }
        catch(NoFoundException e){
            e.printStackTrace();
        }
        catch(Throwable h){
            manager.getTransaction().rollback();
            h.printStackTrace();
        }

    }

    @Override
    public void delete(Student student) {
        try{
            Student found = this.getByID(student.getId());
            manager.getTransaction().begin();
            manager.remove(found);
            manager.getTransaction().commit();

        }
        catch(NoFoundException e){
            e.printStackTrace();
        }
        catch(Throwable h){
            h.printStackTrace();
            manager.getTransaction().rollback();
        }



    }
}
