package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
  private static int PEOPLE_COUNT = 0;

  private static final String URL = "jdbc:postgresql://localhost:5433/first_db";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "Put here your password";

  //Connection to DB
  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<Person> index() {
    List<Person> people = new ArrayList<>();

    try {
      Statement statement = connection.createStatement();
      String sql = "SELECT * FROM person";
      ResultSet resultSet = statement.executeQuery(sql);

      while(resultSet.next()) {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        people.add(person);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return people;
  }

  public Person show(int id) {
    Person person = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        "SELECT * FROM person WHERE id=?"
      );
      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();

      resultSet.next();

      person = new Person();

      person.setId(resultSet.getInt("id"));
      person.setName(resultSet.getString("name"));
      person.setSurname(resultSet.getString("surname"));
      person.setAge(resultSet.getInt("age"));
      person.setEmail(resultSet.getString("email"));

    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }

    return person;
  }

  public void save(Person person) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person VALUES (1, ?, ?, ?, ?)");
      preparedStatement.setString(1, person.getName());
      preparedStatement.setString(2, person.getSurname());
      preparedStatement.setInt(3, person.getAge());
      preparedStatement.setString(4, person.getEmail());

      preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

  public void update(int id, Person person) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE person SET name=?, surname=?, age=?, email=? WHERE id=?");
      preparedStatement.setString(1, person.getName());
      preparedStatement.setString(2, person.getSurname());
      preparedStatement.setInt(3, person.getAge());
      preparedStatement.setString(4, person.getEmail());
      preparedStatement.setInt(5, id);
      preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

  public void delete(int id) {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}
