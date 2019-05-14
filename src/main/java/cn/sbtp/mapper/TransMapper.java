package cn.sbtp.mapper;

import cn.sbtp.model.Book;

import java.util.List;

public interface TransMapper {

    //获取已发布书籍列表
    public List<Book> getSubmitBookList();

}
