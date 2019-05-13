package cn.sbtp.mapper;


import java.util.Date;

public interface ImpressionMapper {

    //给书籍添加感想
    void addImpression(String content, Date releaseTime, double rate, int userId, int bookId);

}
