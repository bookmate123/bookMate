package cn.sbtp.controller.bookMangement;

import cn.sbtp.model.Review;
import cn.sbtp.service.bookService.ReviewService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @ApiOperation("依据感想id获取评论列表")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getReviewListByImpressionId", method = RequestMethod.POST)
    public Map getReviewListByImpressionId(@RequestParam("impressionId") int impressionId){
        Map map = new HashMap();
        List<Review> reviewList = reviewService.getReviewListByImpressionId(impressionId);
        map.put("status", 1);
        map.put("reviewList", reviewList);
        return map;
    }
}
