package com.zy.exam.service.impl;

import com.zy.exam.mapper.ExamMapper;
import com.zy.exam.model.User;
import com.zy.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zy
 * @Date: 2020/7/31 19:08
 * @Description:
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamMapper examMapper;

    /**
     * 通过电话查找用户是否存在
     * @param mobile
     * @return User
     */
    @Override
    public User findByPhone(String mobile) {
        return examMapper.findByPhone(mobile);
    }

    /**
     * 注册用户
     * @param user
     * @return int
     */
    @Override
    public boolean insertUser(User user) {
        if(examMapper.findByPhone(user.getMobile()) != null) return false;
        if(examMapper.findByEmail(user.getEmail()) != null) return false;
        examMapper.insertUser(user);
        return true;
    }

    /**
     * 查询所有用户
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        return examMapper.findAll();
    }

    /**
     * 删除用户信息
     * @param mobile
     * @return boolean
     */
    @Override
    public boolean deleteUser(String mobile) {
        if(examMapper.findByPhone(mobile) == null) return false;
        examMapper.deleteUser(mobile);
        return true;
    }

    /**
     * 更新用户信息
     * @param user
     * @return boolean
     */
    @Override
    public boolean updateUser(User user) {
        examMapper.updateUser(user);
        return true;
    }
}
