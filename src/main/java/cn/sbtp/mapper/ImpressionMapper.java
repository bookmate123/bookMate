package cn.sbtp.mapper;


import cn.sbtp.model.Impression;

import java.util.Date;
import java.util.List;

public interface ImpressionMapper {

    //给书籍添加感想
    void addImpression(String content, Date releaseTime, double rate, int userId, int bookId);
    //获取书籍感想列表
    List<Impression> getImpressionList(int id);
 }
