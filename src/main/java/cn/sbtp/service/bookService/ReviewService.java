package cn.sbtp.service.bookService;

import cn.sbtp.mapper.ReviewMapper;
import cn.sbtp.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> getReviewListByImpressionId(int impressionId){
        return reviewMapper.getReviewListByImpressionId(impressionId);
    }
}
