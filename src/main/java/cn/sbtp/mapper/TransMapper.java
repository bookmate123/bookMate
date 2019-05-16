package cn.sbtp.mapper;

import cn.sbtp.model.Book;
import cn.sbtp.model.SubmitBookRecord;
import cn.sbtp.model.User;

import java.util.List;

public interface TransMapper {

    //获取已发布书籍记录表
    public List<SubmitBookRecord> getSubmitBookRecordList();
    //依据bookId获取用户列表
    List<User> getUserListByBookId(int bookId);
}
