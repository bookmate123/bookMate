package cn.sbtp.mapper;

import cn.sbtp.model.Book;
import cn.sbtp.model.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUsers();


    //登录注册有个问题，暂时不管
    //用户登录
    void login();
    //用户注册
    void register();

    //查看用户信息
    User getUserInfo(int id);
    //

}
