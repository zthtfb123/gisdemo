package com.gis.demo.Dao;

import com.gis.demo.Enity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao  extends CrudRepository<User, Long> {

    public User findByEmail(String email);
}
