package com.soker.interfaces;

import com.soker.bean.Person;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface PersonService {
    /*保存个人信息*/
    public  void savePerson(Person person);

    /*获取个人信息*/
    public  Person selectPerson(int id);
}
