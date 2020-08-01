package com.zy.exam.controller;


import com.zy.exam.model.User;
import com.zy.exam.service.ExamService;
import com.zy.exam.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * @Auther: zy
 * @Date: 2020/7/31 19:07
 * @Description:
 */

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @GetMapping(value = "/user")
    public JsonMsg findByPhone(@RequestParam(value = "mobile",required = true)String mobile){
        System.out.println("通过电话查找用户");
        User user = examService.findByPhone(mobile);
        if(user != null){
            return JsonMsg.success().addInfo("user",user);
        }else return JsonMsg.success().addInfo("msg","该用户不存在");

    }

    @PostMapping(value = "/user")
    public JsonMsg insertUser(User user){
        System.out.println("添加用户");
        if(examService.insertUser(user)) return JsonMsg.success();
        return JsonMsg.success().addInfo("msg","电话或邮箱已存在");
    }

    @GetMapping(value = "/findall" )
    public JsonMsg findAllUsers(){
        System.out.println("查找所有用户");
        return JsonMsg.success().addInfo("msg",examService.findAll());
    }

    @DeleteMapping(value = "/user")
    public JsonMsg deleteUser(String mobile){
        System.out.println("删除电话为" + mobile + "用户");
        if(examService.deleteUser(mobile)) return JsonMsg.success();
        else return JsonMsg.success().addInfo("msg","该用户不存在");
    }

    @PutMapping(value = "/user")
    public JsonMsg updateUser(User user){
        System.out.println("更新用户信息");
        if(examService.updateUser(user)) return JsonMsg.success();
        else return JsonMsg.success().addInfo("msg","更新失败");
    }
}
