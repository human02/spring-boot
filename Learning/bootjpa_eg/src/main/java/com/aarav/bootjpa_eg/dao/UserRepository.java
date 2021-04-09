package com.aarav.bootjpa_eg.dao;

import com.aarav.bootjpa_eg.entities.User;

import org.springframework.data.repository.CrudRepository;

// it has to have certain functionality hence extended, Integer as 'id' of "User" is int.
public interface UserRepository extends CrudRepository<User, Integer> {

}
