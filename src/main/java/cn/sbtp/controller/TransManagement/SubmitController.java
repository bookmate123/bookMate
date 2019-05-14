package cn.sbtp.controller.TransManagement;

import cn.sbtp.model.Book;
import cn.sbtp.service.transService.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("submit")
public class SubmitController {

    @Autowired
    private TransService transService;

    @RequestMapping(value = "getSubmitBookList", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getSubmitBookList(){
        Map map = new HashMap();
        List<Book> submitBookList = transService.getSubmitBookList();
        map.put("status", 1);
        map.put("submitBookList", submitBookList);
        return map;
    }
}
