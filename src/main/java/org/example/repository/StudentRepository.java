package org.example.repository;


import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveStudent(Student student) {
        String sql = "insert into student (name,surname,phone,birth_date,role ) values('%s','%s','%s','%s','%s')";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), student.getBirthDate(),student.getRole());
        int update = jdbcTemplate.update(sql);
        return update;
    }

//    public void create(LessonDTO lessonDTO) {
//        String sql = "insert into lesson (name,surname,created_date) values ('%s','%s',now())";
//        sql = String.format(sql, lessonDTO.getName(), lessonDTO.getSurname());
//        int n = jdbcTemplate.update(sql);
//        System.out.println(n);
//    }

    public Integer deleteStudent(Integer id) {
        String sql = "delete from student where id = '%s'";
        sql = String.format(sql, id);
        return jdbcTemplate.update(sql);
    }

    public List<Student> getAllStudent() {
        String query = "select * from student";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
    }


    public Student getStudentByPhone(String phone) {
        String sql = String.format("SELECT * FROM student Where phone = '%s';", phone);
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Student getStudentById(Integer id) {
        String query = "select * from where id=" + id;
        Student student = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class));
        return student;
    }

//    public LessonDTO getLessonById(Integer id) {
//        String sql = "SELECT * FROM lesson Where id =" + id;
//        LessonDTO dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LessonDTO.class));
//        return dto;
//    }



  /*  public List<Student> getAllStudents() {
        List<Student> studentList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
               Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                studentList.add(student);
            }
            connection.close();
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }*/

 /*   public void saveStudents(Student student) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name,surname,phone,createdDate)values(?,?,?,now())");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPhone());
            int i = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

     /* public int deleteStudent(Integer id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }*/


/*    public Student getStudentByPhone(String phone) {
        try {
            Student student = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where phone = ?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone").trim());
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(resultSet.getBoolean("visible"));
            }
            connection.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

   /* public Student getStudentById(Integer id) {

        try {
            Student student = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(Boolean.valueOf(resultSet.getString("visible")));
            }
            connection.close();
            return student;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
