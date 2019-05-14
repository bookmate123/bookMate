package cn.sbtp.mapper;

import cn.sbtp.model.Book;
import cn.sbtp.model.SubmitBookRecord;

import java.util.List;

public interface TransMapper {

    //获取已发布书籍记录表
    public List<SubmitBookRecord> getSubmitBookRecordList();

}
