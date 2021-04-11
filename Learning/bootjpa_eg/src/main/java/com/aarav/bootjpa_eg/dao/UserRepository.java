package com.aarav.bootjpa_eg.dao;

import java.util.List;

import com.aarav.bootjpa_eg.entities.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// it has to have certain functionality hence extended, Integer as 'id' of "User" is int.
public interface UserRepository extends CrudRepository<User, Integer> {
    // This is a custom finder method/ derived finder method that is implemented
    // automatically once we follow specific naming convention.
    // find - Introducer
    // ByName - Criteria
    // Name - Property
    public List<User> findByName(String name);

    // All the 3 functions are not case sensitive
    public List<User> findByCity(String name);

    public List<User> findByState(String name);

    // To use 2 or more parameters pls refer the documentation:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public List<User> findByCityOrState(String city, String state);

    public List<User> findByCityAndState(String city, String state);

    public List<User> findByNameStartingWith(String prefix);

    public List<User> findByNameEndingWith(String suffix);

    public List<User> findByNameContaining(String words);

    // Also we can fire query also by using @Query, it can allow JPQL (Java
    // Persistence Query Language) and Native queries(SQL,etc) both.

    // This is JPQL query
    @Query("select u FROM User u")
    public List<User> getAllUsers(String findName13);

    // this takes a parameter as well
    @Query("select u From User u WHERE u.name =:n")
    public List<User> getByName(@Param("n") String pickedName);

}
