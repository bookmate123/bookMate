package cn.sbtp.controller.bookController;

import cn.sbtp.model.Book;
import cn.sbtp.service.bookService.BookService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("获取图书列表")
    @RequestMapping(value = "getBookList", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getBookList(){
        List<Book> bookList = bookService.getBookList();
        Map map = new HashMap();
        map.put("bookList", bookList);
        return map;
    }

    @ApiOperation("用户上传图书")
    @RequestMapping(value = "submitBook", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map submitBook(@RequestParam("type") int type,
                          @RequestParam("price") double price,
                          @RequestParam("submitTime") String submitTime,
                          @RequestParam("userId") int userId,
                          @RequestParam("bookId") int bookId){
        Map map = new HashMap();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(submitTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookService.submitBook(type, price, date, userId, bookId);
        map.put("status", 1);
        return map;
    }

    @ApiOperation("获取图书详情")
    @RequestMapping(value = "getBookInfo", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getBookInfo(@RequestParam("id") int id){
        Map map = new HashMap();
        Book book = bookService.getBookInfoById(id);
        map.put("status", 1);
        map.put("book", book);
        return map;
    }

    //@ApiOperation("")

}
