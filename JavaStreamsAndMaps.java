package FinalHomework;

import fmi.informatics.extending.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class JavaStreamsAndMaps {
    public static void main(String[] args) {
        streamOfStudents();
        streamOfArrays();
        streamConcatenate();
        streamOfNumbers();

    }

    public static void streamOfStudents(){
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make())
                .filter(s -> s.getName().length() > 5)
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);
    }

    public static void streamOfArrays(){

        Stream.of("lamb", "mouse", "monkey","horse")
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void streamConcatenate(){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            students.add(Student.StudentGenerator.make());
        String studentNames = students.stream()
                .sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
                .map(p -> p.getName())
                .reduce((p1,p2)->{
                    if(p2!= null)
                        return p1 + "," + p2;
                            return  p1;
                }).get();
        System.out.println(studentNames);
    }

    public static void streamOfNumbers(){
        IntStream.iterate(0,i -> i +1)
                .skip(5)
                .limit(10)
                .forEach(i ->{
                    if(i % 2 ==0)
                        System.out.println(i);
                });
    }

}
