package com.example.demo.repository;

import com.example.demo.dto.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> people = new ArrayList<>();
    private int currentId = 0;

    public List<Person> findAll() {
        return people;
    }

    public Person findById(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Person save(Person person) {
        person.setId(++currentId);
        people.add(person);
        return person;
    }

    public Person update(int id, Person person) {
        Person existingPerson = findById(id);
        if (existingPerson != null) {
            existingPerson.setFirstname(person.getFirstname());
            existingPerson.setSurname(person.getSurname());
            existingPerson.setLastname(person.getLastname());
            existingPerson.setBirthday(person.getBirthday());
            return existingPerson;
        }
        return null;
    }

    public boolean deleteById(int id) {
        return people.removeIf(person -> person.getId() == id);
    }
}