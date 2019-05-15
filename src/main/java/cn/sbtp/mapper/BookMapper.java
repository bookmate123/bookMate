package cn.sbtp.mapper;


import cn.sbtp.model.Book;

import java.util.Date;
import java.util.List;

public interface BookMapper {

    //增加书籍
    void addBookInfo();
    //获取图书列表
    List<Book> getBookList();
    //用户上传图书
    void submitBook(int type, double price, Date submitTime, int userId, int bookID);
    //获取图书详情
    Book getBookInfoById(int id);
    //用户删除上传的图书
    void deleteBook(int id);
    //用户更新上传的图书
    void updateBook(int id, int type, double price, Date submitTime);
    //获取自己所关注人的所发布的书籍列表
    List<Book> getFollowedBookList(int followingId);
    //获取感想对应的书籍名称
    String getBookNameByImpressionId(int impressionId);
    //依据图书类别获取对应的图书列表
    List<Book> getBookListByCategory(String category);
}
