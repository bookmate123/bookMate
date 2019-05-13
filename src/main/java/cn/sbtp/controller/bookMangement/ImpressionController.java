package cn.sbtp.controller.bookMangement;

import cn.sbtp.service.bookService.ImpressionService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("impression")
public class ImpressionController {

    @Autowired
    private ImpressionService impressionService;

    @ApiOperation("给书籍添加感想")
    @RequestMapping(value = "addImpression", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map addImpression(@RequestParam("content") String content,
                             @RequestParam("releaseTime") String releaseTime,
                             @RequestParam("rate") double rate,
                             @RequestParam("userId") int userId,
                             @RequestParam("bookId") int bookId) throws ParseException{
        Map map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        impressionService.addImpression(content, sdf.parse(releaseTime), rate, userId, bookId);
        map.put("status", 1);
        return map;
    }

}
