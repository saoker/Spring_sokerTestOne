package com.soker.dao;

import com.soker.bean.Person;
import com.soker.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class PersonDao implements PersonService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void savePerson(Person person) {
        jdbcTemplate.update("insert into person(id,name)values(?,?)",
                new Object[]{person.getId(), person.getName(),
                }, new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR});

    }

    public Person selectPerson(int id) {
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        Person person = (Person) jdbcTemplate.queryForObject(
                "select * from person where id=?", new Object[]{id},
                new int[]{java.sql.Types.INTEGER}, rowMapper);

        return person;
    }

    public List<Person> findAll() {
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        List<Person> rows = jdbcTemplate.query("select * from person", rowMapper);
        return rows;
    }

    /*@Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setMappingResources(new String[]{"Spitter.hbn.xml"});
        Properties prop = new Properties();
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(prop);
        return sfb;
    }*/
}
