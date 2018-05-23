package com.xiongzehua.learning.mybatis.dao;

import com.xiongzehua.learning.mybatis.pojo.Person;

/**
 * Created by 31339 on 2018/5/23.
 */
public interface PersonMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Person p);

    Person selectByPrimaryKey(Integer id);

    Person selectByName(String name);

    Integer updateByPrimaryKey(Person record);
}
