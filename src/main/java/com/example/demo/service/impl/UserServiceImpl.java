package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers(){
        return userMapper.findAllUsers();
    }

    public String CreateUser(User user){
        user.setCreateDate(new Date());
        user.setModityDate(new Date());
        int createUser = userMapper.createUser(user);
        if(createUser > 0){
            return "新建成功";
        }else{
            return "新建失败";
        }
    }

    public String updateEnabledUser(List<Integer> ids, boolean enabled){
        int updateEnabledUser = 0;
        if(enabled){
            updateEnabledUser = userMapper.updateEnabledUserByTrue(ids);
        }else{
            updateEnabledUser = userMapper.updateEnabledUserByFalse(ids);
        }
        if(updateEnabledUser > 0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    public String deleteUser(List<Integer> ids){
        int deleteUser = userMapper.deleteUser(ids);
        if(deleteUser > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
}
