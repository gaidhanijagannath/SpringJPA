package com.example.in28minutes.database.databasedemo.springdata;

import com.example.in28minutes.database.databasedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer> {

}

/*
 So the reason for creating this interface is generalizing/making things easy to manage the repositories
 in future there will be 1000 repositories like person class, so we cannot keep on creating the repository files for each
 and every class with same methods(find(),update(), insert()) instead spring will say bhai tu load kyu lera main interface
 create kar deta na bas tu tera class pass kar usame aur khatam baat.

 e.g.
  JpaRepository<Person,Integer>
  JpaRepository<Car,Integer>
  JpaRepository<Bike,Integer>
  etc.....

  so we can clearly avoid making PersonJpaRespository.java file for each and every class.

  now we don't need those methods like PersonJpaRepository class as they are all predefined in Spring Data JPA.

  so easy peasy man ..... :)

  */
