
import java.sql.SQLException;
import java.util.HashMap;


public class Main {
    public static void  main(String[] args) throws SQLException {
        Student student = new Student("UMUBYEYI", "Alice ", "umubyeyialice12@gmail.com", "2003-05-11");
        HashMap <String, Object> map = new HashMap<>();
        Students s = new Students();
//        s.create(student);
        s.read(5);
        s.readAll().forEach(student1 -> System.out.println(student1.getFirst_name() + " " + student1.getLast_name()));
//        s.delete(1);
//        student.setLast_name("Queen");
//        student.setBirth_date("2003-05-11");
//        s.update(student);
//        s.readAll().forEach(stu -> {
//            map.put("first_name", stu.getFirst_name());
//            map.put("last_name", stu.getLast_name());
//            map.put("email", stu.getEmail());
//            map.put("birth_date", stu.getBirth_date());
//        });
//        System.out.println(map);






    }

}
