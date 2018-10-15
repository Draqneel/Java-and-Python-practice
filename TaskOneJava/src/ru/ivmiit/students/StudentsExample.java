package ru.ivmiit.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 * wiki: https://github.com/Draqneel/Java-and-Python-practice/wiki/Specification-fot-%22TaskOneJava%22-project
 * TASK 4 SPECIFICATION
 * This project let you use repository of students
 * You can get data from repository:
 * 1) students of current faculty
 * 2) students all faculties and courses
 * 3) students which older than current age
 * 4) list of education group
 */
public class StudentsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniqueIdGenerator generator = new UniqueIdGenerator();
        StudentsRepository repository = new StudentsRepository();
        repository.add(new Student(generator.getId(), "Tikhonov", "Anton", "Eduardovich",
                LocalDate.of(1999, Month.APRIL, 14), "Pavlukhin st.100/36", "79600420822",
                Faculty.COMPUTER_SCIENCE, 2, "09-753"));
        repository.add(new Student(generator.getId(), "Diarova", "Dina", "Ildarovna",
                LocalDate.of(1999, Month.JUNE, 16), "Kosmonavtov st.41(b)/81", "79654987065",
                Faculty.DESIGNER, 2, "03-835"));
        repository.add(new Student(generator.getId(), "Plotnitskiy", "Anatoliy", "Sergeevich",
                LocalDate.of(1999, Month.FEBRUARY, 8), "Universitetskaya st.12/36", "79888888888",
                Faculty.MACHINE_LEARNING, 1, "04-115"));
        repository.add(new Student(generator.getId(), "Antonov", "Anton", "Antonovich",
                LocalDate.of(1989, Month.JANUARY, 12), "Universitetskaya st.1/00", "79111111111",
                Faculty.MATHEMATICS, 3, "01-111"));
        repository.add(new Student(generator.getId(), "Almazov", "Almaz", "Almazovich",
                LocalDate.of(1999, Month.DECEMBER, 31), "Litovskaya st.12/36", "79888888888",
                Faculty.PRODUCT_MANAGER, 4, "00-000"));

        System.out.println("1) Get list of students current faculty");
        System.out.println("2) Get list of students all faculties and courses");
        System.out.println("3) Get list of students which older than current age");
        System.out.println("4) Get list of education group");
        int choseOne = scanner.nextInt();
        switch (choseOne) {
            case 1: {
                System.out.println("Chose faculty");
                System.out.println("1) COMPUTER SCIENCE");
                System.out.println("2) MATHEMATICS");
                System.out.println("3) MACHINE LEARNING");
                System.out.println("4) DESIGNER");
                System.out.println("5) PRODUCT MANAGER");
                int choseTwo = scanner.nextInt();
                switch (choseTwo) {
                    case 1: {
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == Faculty.COMPUTER_SCIENCE) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    case 2: {
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == Faculty.MATHEMATICS) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    case 3: {
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == Faculty.MACHINE_LEARNING) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    case 4: {
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == Faculty.DESIGNER) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    case 5: {
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == Faculty.PRODUCT_MANAGER) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    default: {
                        System.err.println("Incorrect input");
                    }
                }
                break;
            }
            case 2: {
                for (Faculty faculty : repository.getFacultyList()) {
                    System.out.println("Faculty: " + faculty.toString());
                    for (int i = 0; i < 4; i++) {
                        System.out.println("Course: " + (i + 1));
                        for (Student student : repository.getList()) {
                            if (student.getFaculty() == faculty && student.getCourse() == (i + 1)) {
                                System.out.println(student.toString());
                            }
                        }
                    }
                }
                break;
            }
            case 3: {
                System.out.println("Chose age");
                int age = scanner.nextInt();
                if (age > 100 || age < 0) {
                    throw new IllegalArgumentException();
                }
                for (Student student : repository.getList()) {
                    if (student.getAge() > age) {
                        System.out.println(student.toString());
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Add number of group");
                String group = scanner.next();
                for (Student student : repository.getList()) {
                    if (student.getGroup().equals(group)) {
                        System.out.println(student.toString());
                    }
                }
                break;
            }
            default: {
                System.err.println("Incorrect value");
            }
        }
    }
}
