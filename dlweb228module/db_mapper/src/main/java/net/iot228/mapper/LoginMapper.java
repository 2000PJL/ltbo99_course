package net.iot228.mapper;

import net.iot228.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 17:07 2021/6/4
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Mapper
@Repository
public interface LoginMapper {

    /**
     * 作用：通过姓名去数据库查找用户，在登录时用
     * @author 彭俊龙
     * @date 2021/6/4 17:30
     * @param name 登录账号
     * @return  User 返回id,name,password
     */
    User findByName(String name);

    /**
     * 作用：根据id查询用户信息（修改用户信息时候用）
     *
     * @param id 用户id
     * @return 相关信息
     */
    User findUserById(Integer id);
}
