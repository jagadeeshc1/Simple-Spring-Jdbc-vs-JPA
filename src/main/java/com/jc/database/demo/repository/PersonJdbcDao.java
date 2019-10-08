package com.jc.database.demo.repository;

import com.jc.database.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //select * from person
    public List<Person> getAllPersons(){
        return jdbcTemplate.query("select * from person",
               new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));

    }

    public List<Person> findByName(String name){
        return jdbcTemplate.query("select * from person where name = ?",new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?",new Object[]{id});
    }

    public int insert(Person person){
        return  jdbcTemplate.update("insert into person (id,name,location,birth_date)" +
                "values(?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),person.getBirthDate()});
    }

    public int update(Person person){
        return jdbcTemplate.update("update person set name=?, location=?, birth_date=? " +
                " where id =? ",new Object[]{person.getName(),person.getLocation(),person.getBirthDate(),person.getId()});

    }
}
