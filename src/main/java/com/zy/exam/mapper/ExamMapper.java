package com.zy.exam.mapper;

import com.zy.exam.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: zy
 * @Date: 2020/7/31 19:09
 * @Description:
 */
@Repository
public interface ExamMapper {

    /**
     * 通过电话查找用户
     * @param mobile
     * @return User
     */
    User findByPhone(String mobile);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return User
     */
    User findByEmail(String email);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     * @return int
     */
    int insertUser(User user);

    /**
     * 删除用户信息
     * @param mobile
     * @return int
     */
    int deleteUser(String mobile);

    /**
     * 更新用户信息
     * @param user
     * @return int
     */
    int updateUser(User user);
}
