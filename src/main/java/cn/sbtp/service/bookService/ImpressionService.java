package cn.sbtp.service.bookService;

import cn.sbtp.mapper.ImpressionMapper;
import cn.sbtp.model.Impression;
import org.omg.CORBA.IMP_LIMIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImpressionService {
    @Autowired
    private ImpressionMapper impressionMapper;

    public void addImpression(String content, Date releaseTime, double rate, int userId, int bookId){
        impressionMapper.addImpression(content, releaseTime, rate, userId, bookId);
    }
    public List<Impression> getImpressionList(int id){
        return impressionMapper.getImpressionList(id);
    }
    public String getUserNameByImpressionId(int impressionId){
        return impressionMapper.getUserNameByImpressionId(impressionId);
    }
    public Impression getImpressionById(int impressionId){
        return impressionMapper.getImpressionById(impressionId);
    }
    public List<Impression> getRecentImpressionList(int bookId){
        return impressionMapper.getRecentImpressionList(bookId);
    }
}
