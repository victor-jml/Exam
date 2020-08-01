package com.zy.exam.service;

import com.zy.exam.model.User;

import java.util.List;

/**
 * @Auther: zy
 * @Date: 2020/7/31 19:08
 * @Description:
 */
public interface ExamService {

    User findByPhone(String mobile);

    boolean insertUser(User user);

    List<User> findAll();

    boolean deleteUser(String mobile);

    boolean updateUser(User user);
}
