package com.java.concurreny.wjsr._40;

import java.util.*;
import java.util.stream.IntStream;

public class PersonGenerator {

    public static List<Person> generatePersonList(int size) {
        List<Person> ret = new ArrayList<>();

        String firstNames[] = {"Mary", "Patricia", "Linda",
                "Barbara", "Elizabeth", "James",
                "John", "Robert", "Michael",
                "William"};
        String lastNames[] = {"Smith", "Jones", "Taylor",
                "Williams", "Brown", "Davies",
                "Evans", "Wilson", "Thomas",
                "Roberts"};

        Random randomGenerator = new Random();

        IntStream.range(0, size).forEach(i -> {
            Person person = new Person();
            person.setId(i);
            person.setFirstName(firstNames[randomGenerator
                    .nextInt(10)]);
            person.setLastName(lastNames[randomGenerator
                    .nextInt(10)]);
            person.setSalary(randomGenerator.nextInt(100000));
            person.setCoeficient(randomGenerator.nextDouble() * 10);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -randomGenerator
                    .nextInt(30));
            Date birthDate = calendar.getTime();
            person.setBirthDate(birthDate);
            ret.add(person);
        });

        return ret;
    }

}
