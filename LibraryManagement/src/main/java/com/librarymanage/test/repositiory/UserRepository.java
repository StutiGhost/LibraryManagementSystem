package com.librarymanage.test.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanage.test.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
