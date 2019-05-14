package cn.sbtp.controller.TransManagement;

import cn.sbtp.model.Book;
import cn.sbtp.model.SubmitBookInfo;
import cn.sbtp.model.SubmitBookRecord;
import cn.sbtp.service.bookService.BookService;
import cn.sbtp.service.transService.TransService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("submit")
public class SubmitController {

    @Autowired
    private TransService transService;
    @Autowired
    private BookService bookService;

    @ApiOperation("获取发布书籍列表")
    @RequestMapping(value = "getSubmitBookList", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getSubmitBookList(){
        Map map = new HashMap();
        List<SubmitBookRecord> submitBookRecordList = transService.getSubmitBookRecordList();
        List<SubmitBookInfo> submitBookInfoList = new ArrayList<>();
        for(SubmitBookRecord submitBookRecord:submitBookRecordList){
            SubmitBookInfo submitBookInfo = new SubmitBookInfo();
            submitBookInfo.set(submitBookRecord, bookService.getBookInfoById(submitBookRecord.getBookId()));
            submitBookInfoList.add(submitBookInfo);
        }
        map.put("status", 1);
        map.put("submitBookInfoList", submitBookInfoList);
        return map;
    }
}

