package system.dao;

import java.sql.SQLException;
import java.util.List;
import system.model.Students;


public interface StudentsDao {
    int save(Students student) throws SQLException, ClassNotFoundException;
    
    int update(Students student, int id) throws SQLException, ClassNotFoundException;
    
    int remove(int id) throws SQLException, ClassNotFoundException;
    
    Students findOne(int id) throws SQLException, ClassNotFoundException;
    
    List<Students> findAll() throws SQLException, ClassNotFoundException;
    
    List<Students> search(String query) throws SQLException, ClassNotFoundException;

}
