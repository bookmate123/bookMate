package cn.sbtp.service.bookService;

import cn.sbtp.mapper.ImpressionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ImpressionService {
    @Autowired
    private ImpressionMapper impressionMapper;

    public void addImpression(String content, Date releaseTime, double rate, int userId, int bookId){
        impressionMapper.addImpression(content, releaseTime, rate, userId, bookId);
    }
}
