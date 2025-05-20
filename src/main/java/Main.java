import java.util.Scanner;

public class Main {
    public static void  main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Students students = new Students();
        Courses courses = new Courses();
        Marks marks = new Marks();
        System.out.println("Welcome to the Student Management System");
        Thread.sleep(2000);
        System.out.println("press n to continue");
        char input = scanner.next().charAt(0);
        Thread.sleep(1500);
        System.out.println("READ THE MENU CAREFULLY AND PROCEED WITH THE OPERATION");
        System.out.println("******************************************************");
        System.out.println("""
                1.Create a new item in different entities within our database (students/courses/marks)
                2.View the details of the item in the database
                3.Update the details of the item in the database
                4.Delete the details of the item in the database
                5.Exit
                
                """);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: {
                System.out.print("which entity(table) will you like to proceed with (students/courses/marks)? ");
                String table = scanner.nextLine();
                switch (table) {
                    case "students": {
                        System.out.print("How many students will you like to proceed? ");
                        int numOfStudents = scanner.nextInt();
                        for (int i = 0; i < numOfStudents; i++) {
                            System.out.println("Student # " + (i + 1));
                            scanner.nextLine();
                            System.out.print("Enter first name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Enter last name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter date of birth(yyyy-mm-dd): ");
                            String birthDate = scanner.nextLine();
                            students.create(new Student(firstName, lastName, email, birthDate));
                        }
                        System.out.println("The student(s) record has been created successfully!");
                        break;

                    }
                    case "courses": {
                        System.out.print("How many courses do you want to register? ");
                        int numOfCourses = scanner.nextInt();
                        for (int i = 0; i < numOfCourses; i++) {
                            System.out.println("Course # " + (i + 1));
                            scanner.nextLine();
                            System.out.print("Course name: ");
                            String courseName = scanner.nextLine();
                            System.out.print("Course description: ");
                            String courseDescription = scanner.nextLine();
                            courses.create(new Course(courseName, courseDescription));

                        }
                        System.out.println("The course(s) record has been registered  successfully!");
                        break;
                    }
                    case "marks": {
                        System.out.print("How many marks do you like to record? ");
                        int numOfMarks = scanner.nextInt();
                        for (int i = 0; i < numOfMarks; i++) {
                            System.out.println("Mark # " + (i + 1));
                            scanner.nextLine();
                            System.out.print("Provide Student_id: ");
                            int stud_id = scanner.nextInt();
                            System.out.print("Provide course_id: ");
                            int course_id = scanner.nextInt();
                            System.out.print("Enter the marks: ");
                            int mark = scanner.nextInt();
                            marks.create(new Mark(stud_id, course_id, mark));
                        }
                        System.out.println("The mark(s) record has been created successfully!");
                        break;
                    }
                    default:
                        System.out.println("Sorry! there is no such entity in our database");
                        break;
                }
                break;
            }
            case 2: {

            }
            case 3: {

            }
            case 4: {

            }
            case 5:
                System.out.println("Thank you for using our system");
                return;
            default: {
                System.out.println("Please enter a valid choice");
            }
        }


//        Student student = new Student("UMUBYEYI", "Alice ", "umubyeyialice12@gmail.com", "2003-05-11");
//        Students s = new Students();
//        s.create(student);
//        s.read(5);
//        s.readAll().forEach(student1 -> System.out.println(student1.getFirst_name() + " " + student1.getLast_name()));
//        s.delete(1);
//        student.setLast_name("Queen");
//        student.setBirth_date("2003-05-11");
//        s.update(student);
//        Courses course = new Courses();
//        course.create(new Course("java","java programing language used for backend development"));
//        course.create(new Course("css","the stylesheet when giving the page more beauty"));
//        course.create(new Course("physics","the fundamental principal of physics and physics systems"));
//        course.read(1);
//        course.readAll().forEach(co-> System.out.println(co.getName() + " " + co.getDescription()));








    }

}
