package com.example.in28minutes.database.databasedemo.jpa;

import com.example.in28minutes.database.databasedemo.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional // all the operations in single transaction will succeed or all will fail. V IMP in db management
public class PersonJpaRepository {

    //connect database
    @PersistenceContext
    EntityManager entityManager;
    //All opr performed in specific session are stored in Persistence Context. EntityManager is interface to PC.


    //ye saare niche ke methods har class/entity ko repeat nahi kar sakte isliye we have thing called SpringData JPA.

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }


    public Person findByID(int id){

        return entityManager.find(Person.class,id);

    }

    //if merge does not find id to update it will insert record.
    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findByID(id);
        entityManager.remove(person);
    }
}
