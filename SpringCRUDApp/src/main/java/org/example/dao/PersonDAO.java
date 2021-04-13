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
    people.add(new Person(++PEOPLE_COUNT, "Aleksey"));
    people.add(new Person(++PEOPLE_COUNT, "Tom"));
    people.add(new Person(++PEOPLE_COUNT, "Bob"));
    people.add(new Person(++PEOPLE_COUNT, "Julia"));
    people.add(new Person(++PEOPLE_COUNT, "Vadim"));
    people.add(new Person(++PEOPLE_COUNT, "Nix"));
    people.add(new Person(++PEOPLE_COUNT, "Michael"));
  }

  public List<Person> index() {
    return this.people;
  }

  public Person show(int id) {
    return this.people.stream().filter(s -> s.getId() == id).findAny().orElse(null);
  }
}
