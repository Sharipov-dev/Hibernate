package hibernateCRUD.DAO;

import hibernateCRUD.entity.Student;
import hibernateCRUD.exceptions.NoFoundException;

public interface StudentDAO {
    void save(Student student);
    Student getByID(int id) throws NoFoundException;
    void update(Student student);
    void delete(Student student);
}
