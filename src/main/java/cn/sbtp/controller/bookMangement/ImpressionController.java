package cn.sbtp.controller.bookMangement;

import cn.sbtp.model.Impression;
import cn.sbtp.service.bookService.ImpressionService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map getImpressionList(@RequestParam("bookId") int id){
        Map map = new HashMap();
        List<Impression> impressionList = impressionService.getImpressionList(id);
        map.put("status", 1);
        map.put("impressionList", impressionList);
        return map;
    }


}
