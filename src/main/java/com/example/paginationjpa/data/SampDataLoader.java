package com.example.paginationjpa.data;

import com.example.paginationjpa.model.Address;
import com.example.paginationjpa.model.Person;
import com.example.paginationjpa.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;


@Component
public class SampDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampDataLoader.class);
    private final PersonRepository personRepository;
    private final Faker faker;

    //constructor injection
    public SampDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Load sample data....");

        //create rows of people in database
       List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i->new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()

                        )

                ))
                        .toList();

        personRepository.saveAll(people);
    }
}
