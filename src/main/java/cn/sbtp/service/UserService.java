package cn.sbtp.service;

import cn.sbtp.mapper.UserMapper;
import cn.sbtp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.getUsers();
    }
    public void insertIconName(int id, String iconName){
        userMapper.insertIconName(id, iconName);
    }
    public User getUserInfo(int id){
        return userMapper.getUserInfo(id);
    }
    public List<User> getSubmitUserList(int bookId){
        return userMapper.getSubmitUserList(bookId);
    }
}
