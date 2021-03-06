package cn.sbtp.controller.bookMangement;

import cn.sbtp.model.Book;
import cn.sbtp.service.bookService.BookService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("随机推荐图书")
    @RequestMapping(value = "getRandomBooks", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getRandomBooks(@RequestParam("userId") int id){
        Map map = new HashMap();
        //自己所关注的人的书籍列表
        List<Book> followedBookList = bookService.getFollowedBookList(id);
        //最后返回的随机推荐书籍列表
        List<Book> resultBookList = new ArrayList<>(followedBookList);
        if(followedBookList.size() > 20){
            resultBookList.add(followedBookList.get((int)(Math.random() * followedBookList.size())));
        }
        else {
            for(int i = 0; i < 20 - followedBookList.size(); i++){
                Book book = bookService.getBookInfoById((int)(Math.random() * 200 + 1));
                resultBookList.add(book);
            }
        }
        map.put("status", 1);
        map.put("resultBookList", resultBookList);
        map.put("followedBookNum", followedBookList.size());
        return map;
    }

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

    @ApiOperation("用户删除上传的图书")
    @RequestMapping(value = "deleteBook", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map deleteBook(@RequestParam("id") int id){
        Map map = new HashMap();
        bookService.deleteBook(id);
        map.put("status", 1);
        return map;
    }

    @ApiOperation("用户修改上传的图书信息")
    @RequestMapping(value = "updateBook", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map updateBookInfo(@RequestParam("id") int id,
                              @RequestParam("type") int type,
                              @RequestParam("price") double price,
                              @RequestParam("submitTime") String submitTime) throws ParseException{
        Map map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        bookService.updateBook(id, type, price, sdf.parse(submitTime));
        map.put("status", 1);
        return map;
    }

    @ApiOperation("搜索相关图书")
    @RequestMapping(value = "searchBook", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public Map searchBook(@RequestParam("str") String str){
        Map map = new HashMap();
        List<Book> bookList = bookService.getBookList();
        List<Book> targetBookList = new ArrayList<>();
        for(Book book:bookList){
            if(book.getBookName().contains(str)){
                targetBookList.add(book);
            }
        }
        map.put("targetBookList", targetBookList);
        map.put("status", 1);
        return map;
    }

    //@ApiOperation("")
    public void hello(){
        System.out.println("hello");
    }

    @ApiOperation("依据类别获取对应类别的图书")
    @RequestMapping(value = "getBookListByCategory", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getBookListByCategory(@RequestParam("Category") String category){
        Map map = new HashMap();
        List<Book> bookList = bookService.getBookListByCategory(category);
        map.put("status", 1);
        map.put("bookList", bookList);
        return map;
    }

    @ApiOperation("依据书名搜索图书")
    @RequestMapping(value = "getBookListByBookName", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public Map getBookListByBookName(@RequestParam("bookName") String bookName){
        Map map = new HashMap();
        List<Book> bookList = bookService.getBookList();
        List<Book> resultBookList = new ArrayList<>();
        for(Book book:bookList){
            if(book.getBookName().contains(bookName)){
                resultBookList.add(book);
            }
        }
        map.put("status", 1);
        map.put("resultBookList", resultBookList);
        return map;
    }

}
