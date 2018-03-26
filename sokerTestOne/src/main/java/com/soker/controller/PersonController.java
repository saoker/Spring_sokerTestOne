package com.soker.controller;

import com.soker.bean.Person;
import com.soker.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class PersonController {

    @Autowired
    PersonDao pd;

    @RequestMapping(value = "/loginaction")
    public String login(HttpServletRequest request) {
        List<Person> persons = pd.findAll();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        for (int i = 0; i < persons.size(); i++) {
            if (username.equals(persons.get(i).getName()) && password.equals(persons.get(i).getEmail())) {
                System.out.println("success");
                return "redirect:/list";
            }
        }
        System.out.println("error");
        return "Error";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        /*String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        List<Person> persons = jdbcTemplate.query(sql, rowMapper);
        //        map.put("datas", persons);*/

        ModelAndView modelAndView = new ModelAndView();
        List<Person> persons = pd.findAll();
        modelAndView.addObject("persons", persons);
        modelAndView.setViewName("list");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((persons.get(i)).toString());
        }
        return modelAndView;
    }






}
