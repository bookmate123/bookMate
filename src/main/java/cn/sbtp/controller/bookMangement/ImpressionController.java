package cn.sbtp.controller.bookMangement;

import cn.sbtp.model.Impression;
import cn.sbtp.service.bookService.BookService;
import cn.sbtp.service.bookService.ImpressionService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("impression")
public class ImpressionController {

    @Autowired
    private ImpressionService impressionService;
    @Autowired
    private BookService bookService;

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

    @ApiOperation("获取书籍感想列表")
    @RequestMapping(value = "getImpressionList", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getImpressionList(@RequestParam("bookId") int id){
        Map map = new HashMap();
        List<Impression> impressionList = impressionService.getImpressionList(id);
        map.put("status", 1);
        map.put("impressionList", impressionList);
        return map;
    }

    @ApiOperation("获取感想对应的书籍名称")
    @RequestMapping(value = "getBookNameByImpressionId", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getBookNameByImpressionId(@RequestParam("impressionId") int id){
        Map map = new HashMap();
        String bookName = bookService.getBookNameByImpressionId(id);
        map.put("status", 1);
        map.put("bookName", bookName);
        return map;
    }

    @ApiOperation("获取感想对应的用户名称")
    @RequestMapping(value = "getUserNameByImpressionId", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getUserNameByImpressionId(@RequestParam("impressionId") int id){
        Map map = new HashMap();
        String userName = impressionService.getUserNameByImpressionId(id);
        map.put("status", 1);
        map.put("userName", userName);
        return map;
    }

    @ApiOperation("依据感想id获取对应感想")
    @RequestMapping(value = "getImpressionById", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getImpressionById(@RequestParam("impressionId") int id){
        Map map = new HashMap();
        Impression impression = impressionService.getImpressionById(id);
        map.put("status", 1);
        map.put("impression", impression);
        return map;
    }

    @ApiOperation("获取某书最近的最多三条感想")
    @RequestMapping(value = "getRecentImpressionList", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getRecentImpressionList(@RequestParam("bookId") int id){
        Map map = new HashMap();
        List<Impression> recentImpressionList = impressionService.getRecentImpressionList(id);
        map.put("status", 1);
        map.put("recentImpressionList", recentImpressionList);
        return map;
    }

}
