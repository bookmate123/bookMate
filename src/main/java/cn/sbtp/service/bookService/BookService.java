package cn.sbtp.service.bookService;

import cn.sbtp.mapper.BookMapper;
import cn.sbtp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBookList(){
        return bookMapper.getBookList();
    }
    public void submitBook(int type, double price, Date submitTime, int userId, int bookID){
        bookMapper.submitBook(type, price, submitTime, userId, bookID);
    }
    public Book getBookInfoById(int id){
        return bookMapper.getBookInfoById(id);
    }
    public void deleteBook(int id){
        bookMapper.deleteBook(id);
    }
    public void updateBook(int id, int type, double price, Date submitTime){
        bookMapper.updateBook(id, type, price, submitTime);
    }
    public List<Book> getFollowedBookList(int followingId){
        return bookMapper.getFollowedBookList(followingId);
    }
    public String getBookNameByImpressionId(int impressionId){
        return bookMapper.getBookNameByImpressionId(impressionId);
    }
    public List<Book> getBookListByCategory(String category){
        return bookMapper.getBookListByCategory(category);
    }
}
