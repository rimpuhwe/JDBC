import java.util.Scanner;

public class Main {
    public static void  main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Students students = new Students();
        Courses courses = new Courses();
        Marks marks = new Marks();
        System.out.println("Welcome to the Student Management System");
        Thread.sleep(2000);
        System.out.println("press n for next to continue");
        char input = scanner.next().charAt(0);
        if (input == 'n') {
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
                    System.out.print("Do you want to proceed with the the details in entities (students/courses/marks) with id (y/n)?");
                    char option = scanner.next().toLowerCase().charAt(0);
                    scanner.nextLine();
                    if (option == 'y') {
                        System.out.print("which entity do you like to proceed with? ");
                        String entity = scanner.next();
                        switch (entity) {
                            case "students": {
                                System.out.print("Enter student id: ");
                                int student_id = scanner.nextInt();
                                students.read(student_id);
                                break;
                            }
                            case "courses": {
                                System.out.print("Enter course id: ");
                                int course_id = scanner.nextInt();
                                students.read(course_id);
                                break;
                            }
                            case "marks": {
                                System.out.print("Enter either student id or course id: ");
                                int id = scanner.nextInt();
                                students.read(id);
                                break;
                            }
                        }

                    }
                    else if (option == 'n') {
                        System.out.print("you want to read all data from an entity in our database. which table do we go with: ");
                        String table = scanner.nextLine();
                        switch (table) {
                            case "students": {
                                students.readAll().forEach(stud -> System.out.println(stud.toString()));
                                break;
                            }
                            case "courses": {
                                courses.readAll().forEach(course -> System.out.println(course.toString()));
                                break;

                            }
                            case "marks": {
                                marks.readAll().forEach(mark -> System.out.println(mark.toString()));
                                break;

                            }
                        }

                    }
                    else {
                        System.out.println("invalid option");
                    }
                    break;

                }
                case 3: {

                }
                case 4: {
                    System.out.println("you are no longer in need of some data ? let's help to delete the unwanted ones");
                    Thread.sleep(1000);
                    System.out.print("which entity do we go with: ");
                    String entity = scanner.next();
                    scanner.nextLine();
                    switch (entity) {
                        case "students": {
                            System.out.print("Enter student id: ");
                            int student_id = scanner.nextInt();
                            students.delete(student_id);
                            System.out.println("The student has been deleted successfully!");
                            break;
                        }
                        case "courses": {
                            System.out.print("Enter course id: ");
                            int course_id = scanner.nextInt();
                            courses.delete(course_id);
                            System.out.println("The course has been deleted successfully!");
                            break;

                        }
                        case "marks": {
                            System.out.print("Enter either student_id ,course_id or marks: ");
                            int deleted = scanner.nextInt();
                            marks.delete(deleted);
                            System.out.println("The marks has been deleted successfully!");
                            break;
                        }
                    }
                    break;
                }
                case 5:
                    System.out.println("Thank you for using our system");
                    return;
                default: {
                    System.out.println("Please enter a valid choice");
                }
            }

        }
        else {
            System.out.println("Please enter a valid choice");
        }
        scanner.close();

    }

}
