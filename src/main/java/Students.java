import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Students extends Connect implements Operations<Student> {


    @Override
    public void create(Student item)  {
        String query = "insert into students (first_name, last_name, email, birth_date) values(?,?,?,CAST(? AS DATE))";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(2, item.getFirst_name());
            ps.setString(1, item.getLast_name());
            ps.setString(3, item.getEmail());
            ps.setString(4, item.getBirth_date());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void read(int id) {
        String query = "select * from students where id = ?";
        try(Connection conn = connect();  PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Student> readAll() {
        List <Student> student = new ArrayList<>();
        String query = "select * from students";
        try(Connection conn = connect(); Statement statement = conn.createStatement(); ResultSet set = statement.executeQuery(query)){
            while(set.next()) {
               student.add(new Student(
                       set.getString("first_name"),
                       set.getString("last_name"),
                       set.getString("email"),
                       set.getString("birth_date")
               ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return student;
    }

    @Override
    public void update(Student item) {
        String query = "update students set last_name = ? where birth_date = CAST(? AS DATE) ";
        try(Connection conn = connect(); PreparedStatement update = conn.prepareStatement(query)){
            update.setString(1, item.getLast_name());
            update.setString(2, item.getBirth_date());
            update.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try(Connection conn = connect() ;
            PreparedStatement statement = conn.prepareStatement(query)
            ){
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
