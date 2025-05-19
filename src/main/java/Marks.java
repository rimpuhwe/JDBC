import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Marks extends Connect implements Operations<Mark> {
    @Override
    public void create(Mark item) {
        String query = "insert into marks (student_id, course_id, mark) values(?,?,?)";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, item.getStudentId());
            ps.setInt(2, item.getCourseId());
            ps.setInt(3, item.getMark());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read(int id) {
        String query = "select * from marks where student_id = ?";
        try(Connection conn = connect();  PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("course_id") + " " + rs.getString("mark") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Mark> readAll() {
        List <Mark> m = new ArrayList<>();
        String query = "select * from marks";
        try(Connection conn = connect(); Statement statement = conn.createStatement(); ResultSet set = statement.executeQuery(query)){
            while(set.next()) {
                m.add(new Mark(
                        set.getInt("student_id"),
                        set.getInt("course_id"),
                        set.getInt("mark")

                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    @Override
    public void update(Mark item) {
        String query = "update students set mark = ? where student_id = ? ";
        try(Connection conn = connect(); PreparedStatement update = conn.prepareStatement(query)){
            update.setInt(1, item.getMark());
            update.setInt(2, item.getStudentId());
            update.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM marks WHERE id = ?";
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
