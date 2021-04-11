package com.aarav.bootjpa_eg.dao;

import java.util.List;

import com.aarav.bootjpa_eg.entities.User;

import org.springframework.data.repository.CrudRepository;

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

}
