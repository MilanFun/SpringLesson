package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
  private static int PEOPLE_COUNT = 0;
  private List<Person> people;

  {
    this.people = new ArrayList<>();
    people.add(new Person(++PEOPLE_COUNT, "Aleksey", "Ptukha", "aleksey@mail.ru", 21));
    people.add(new Person(++PEOPLE_COUNT, "Tom", "Builder", "tom@gmail.com", 25));
    people.add(new Person(++PEOPLE_COUNT, "Bob", "Hamford", "bob@mail.ru", 20));
    people.add(new Person(++PEOPLE_COUNT, "Julia", "Kuk", "julia@gmail.com", 29));
    people.add(new Person(++PEOPLE_COUNT, "Vadim", "Jobs", "vadim@mail.ru", 24));
  }

  public List<Person> index() {
    return this.people;
  }

  public Person show(int id) {
    return this.people.stream().filter(s -> s.getId() == id).findAny().orElse(null);
  }

  public void save(Person person) {
    person.setId(++PEOPLE_COUNT);
    this.people.add(person);
  }

  public void update(int id, Person person) {
    Person personTmp = this.show(id);
    personTmp.setName(person.getName());
    personTmp.setSurname(person.getSurname());
    personTmp.setAge(person.getAge());
    personTmp.setEmail(person.getEmail());
  }

  public void delete(int id) {
    this.people.removeIf(person -> person.getId() == id);
  }
}
