package net.iot228.service.Impl;

import net.iot228.entity.User;
import net.iot228.mapper.LoginMapper;
import net.iot228.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 17:18 2021/6/4
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public User findByName(String name) {
        return loginMapper.findByName(name);
    }

    @Override
    public User findUserById(Integer id){
        return loginMapper.findUserById(id);
    }

}
