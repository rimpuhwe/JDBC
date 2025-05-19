import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Courses extends Connect implements Operations<Course>{
    @Override
    public void create(Course item) {
        String query = "insert into courses (course_name, course_description) values (?, ?)";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void read(int id) {
        String query = "select * from courses where id = ?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("course_name") + " " + rs.getString("course_description"));
            }
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Course> readAll() {
        List <Course> c = new ArrayList<>();
        String query = "select * from courses";
        try(Connection conn = connect(); Statement statement = conn.createStatement(); ResultSet set = statement.executeQuery(query)){
            while(set.next()) {
                c.add(new Course(
                        set.getString("course_name"),
                        set.getString("course_description")
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    @Override
    public void update(Course item) {
        String query = "update courses set course_description = ? where course_name = ? ";
        try(Connection conn = connect(); PreparedStatement update = conn.prepareStatement(query)){
            update.setString(1, item.getDescription());
            update.setString(2, item.getName());
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
