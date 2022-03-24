package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface UserMapper {

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 创建用户
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * 修改用户状态: false
     * @param ids
     * @return
     */
    int updateEnabledUserByFalse(@Param("ids") List<Integer> ids);

    /**
     * 修改用户状态: true
     * @param ids
     * @return
     */
    int updateEnabledUserByTrue(@Param("ids") List<Integer> ids);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    int deleteUser(@Param("ids") List<Integer> ids);
}
