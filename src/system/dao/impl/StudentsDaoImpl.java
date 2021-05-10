package system.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import system.dao.StudentsDao;
import system.model.Students;
import static system.connection.connectionFactory.getConnection;

public class StudentsDaoImpl implements StudentsDao {
    
    @Override
    public int save(Students student) throws SQLException, ClassNotFoundException {
        String insertSQL = "insert into students (uid, name, contact, address, email, programme, batch, semester) values(?,?,?,?,?,?,?,?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertSQL);
        prepareStatement.setString(1, student.getUid());
        prepareStatement.setString(2, student.getName());
        prepareStatement.setString(3, student.getContact());
        prepareStatement.setString(4, student.getAddress());
        prepareStatement.setString(5, student.getEmail());
        prepareStatement.setString(6, student.getProgramme());
        prepareStatement.setString(7, student.getBatch());
        prepareStatement.setString(8, student.getSemester());
        return prepareStatement.executeUpdate();
    }
    
    @Override
    public int update(Students student, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "update students set uid = ?, name = ?, contact = ?, address = ?, email = ?, programme = ?, batch = ?, semester = ? where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, student.getUid());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getContact());
        preparedStatement.setString(4, student.getAddress());
        preparedStatement.setString(5, student.getEmail());
        preparedStatement.setString(6, student.getProgramme());
        preparedStatement.setString(7, student.getBatch());
        preparedStatement.setString(8, student.getSemester());
        preparedStatement.setInt(9, student.getId());
        return preparedStatement.executeUpdate();
    }
    
    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "delete from students where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }
    
    @Override
    public Students findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("select *from students where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Students student = new Students();
        while (resultSet.next()) {
            student.setId(resultSet.getInt("id"));
            student.setUid(resultSet.getString("uid"));
            student.setName(resultSet.getString("name"));
            student.setContact(resultSet.getString("contact"));
            student.setAddress(resultSet.getString("address"));
            student.setEmail(resultSet.getString("email"));
            student.setProgramme(resultSet.getString("programme"));
            student.setBatch(resultSet.getString("batch"));
            student.setSemester(resultSet.getString("semester"));
        }
        return student;
    }
    
    @Override
    public List<Students> findAll() throws SQLException, ClassNotFoundException {
        List<Students> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement("select *from students");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Students student = new Students();
            student.setId(resultSet.getInt("id"));
            student.setUid(resultSet.getString("uid"));
            student.setName(resultSet.getString("name"));
            student.setContact(resultSet.getString("contact"));
            student.setAddress(resultSet.getString("address"));
            student.setEmail(resultSet.getString("email"));
            student.setProgramme(resultSet.getString("programme"));
            student.setBatch(resultSet.getString("batch"));
            student.setSemester(resultSet.getString("semester"));
            students.add(student);
        }
        return students;
    }
    
    @Override
    public List<Students> search(String query) throws SQLException, ClassNotFoundException {
        List<Students> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement("select *from students where name like concat ('%' ? '%') or uid like concat ('%' ? '%') or cast(id as char) like ('%' ? '%')");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        preparedStatement.setString(4, query);
        preparedStatement.setString(5, query);
        preparedStatement.setString(6, query);
        preparedStatement.setString(7, query);
        preparedStatement.setString(8, query);
        preparedStatement.setString(9, query);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Students student = new Students();
            student.setId(resultSet.getInt("id"));
            student.setUid(resultSet.getString("uid"));
            student.setName(resultSet.getString("name"));
            student.setContact(resultSet.getString("contact"));
            student.setAddress(resultSet.getString("address"));
            student.setEmail(resultSet.getString("email"));
            student.setProgramme(resultSet.getString("programme"));
            student.setBatch(resultSet.getString("batch"));
            student.setSemester(resultSet.getString("semester"));
            students.add(student);
        }
        return students;
    }
}
