package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

     Student student1 = new Student("Anton", Arrays.asList(new Course("ASTROLOGY"), new Course("GO")));
     Student student2 = new Student("Ivan", Arrays.asList(new Course("BIOLOGY"), new Course("GO")));
     Student student3 = new Student("Michail", Arrays.asList(new Course("CHEMISTRY"), new Course("GO")));
     Student student4 = new Student("Olga", Arrays.asList(new Course("PHP"), new Course("JAVA")));
     Student student5 = new Student("Julia", Arrays.asList(new Course("PHP"), new Course("GO"), new Course("HTML")));

     ArrayList <Student> studentsList = new ArrayList<Student>();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);

     //uniqueCourses(studentsList);
     //theMostInquisitiveStudent(studentsList);
     //attendTheCourse(studentsList, new Course("GO"));

        System.out.println("Список курсов, которые посещают студенты (без повторений): " + studentsList.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .map(c -> c.getCourseName())
                .collect(Collectors.toSet()));

        System.out.println("Самый любознательный студент: " + studentsList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(1)
                .collect(Collectors.toList()));

        Course currentCourse = new Course("GO");
        System.out.println("Курс " + currentCourse + " посещают следующие студенты: " + studentsList.stream()
                .filter(s -> s.getCourses().contains(currentCourse))
                .collect(Collectors.toList()));

    }

//    private static void uniqueCourses(ArrayList studentsList) {
//        //studentsList.stream()
//                //.map(s -> s.getCourses())
//                //.flatMap()
//    }
//
//    private static void theMostInquisitiveStudent(ArrayList studentsList) {
//
//    }
//
//    private static void attendTheCourse(ArrayList studentsList, Course course) {
//
//    }

}
