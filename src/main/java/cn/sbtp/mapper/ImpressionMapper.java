package cn.sbtp.mapper;


import cn.sbtp.model.Impression;

import java.util.Date;
import java.util.List;

public interface ImpressionMapper {

    //给书籍添加感想
    void addImpression(String content, Date releaseTime, double rate, int userId, int bookId);
    //获取书籍感想列表
    List<Impression> getImpressionList(int id);
    //获取发表感想的用户姓名
    String getUserNameByImpressionId(int impressionId);
    //依据感想id获取对应感想
    Impression getImpressionById(int impressionId);
 }
