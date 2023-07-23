package com.example.in28minutes.database.databasedemo.jdbc;

import com.example.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate; // to create connection with database



    /*
    what if we have diff structure of table i.e  column names/definitions are different than variable we have defined in person class(bean).
    we will need to create custom RowMapper for that..
    */

    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;

        }

    }

    public List<Person> finAll(){

        //data from our query will be mapped against class to get the data in Person class.
        /*
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper(Person.class)); //this is default mapper
        */

        return jdbcTemplate.query("select * from person",
                new PersonRowMapper()); //use of customize class to get values.

    }

    public Person finByID(int id){

        return jdbcTemplate.queryForObject("select * from person where id =?",
                new BeanPropertyRowMapper<>(Person.class),
                id);

    }
    public int deleteByID(int id){
        return jdbcTemplate.update("Delete from person where id =?",
                id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }




}
