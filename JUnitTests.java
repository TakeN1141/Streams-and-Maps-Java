import org.junit.Test;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class JUnitTests {

    @Test
    public void testTask1() {
        ArrayList<Student> students = new ArrayList<Student>();
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make()
        )
                .filter(s -> s.getName().length() > 4)
                .sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                .forEach(s -> students.add(s));

        Assert.assertEquals(students.get(0).getName().toString(),"Petyr");
    }

    @Test
    public void testTask2() {
        ArrayList<String> mammals = new ArrayList<String>();
        Stream.of("lamb", "mouse", "monkey","horse")
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList())
                .forEach(s -> mammals.add(s));


        Assert.assertEquals(mammals.get(0),"horse");
    }

    @Test
    public void testTask3() {
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            ((ArrayList) studs).add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);


        Assert.assertEquals(studNames,"Petya, Ivan, Lily, Mariya, Stoyan");
    }

    @Test
    public void testTask5() {
        Rock onEarth = new Rock();
        onEarth.drop(onEarth.height());
        Rock onJupiter = new Rock();

        assertEquals(onEarth,onJupiter);

    }

}
