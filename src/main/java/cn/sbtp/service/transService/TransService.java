package cn.sbtp.service.transService;

import cn.sbtp.mapper.TransMapper;
import cn.sbtp.model.SubmitBookRecord;
import cn.sbtp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransService {

    @Autowired
    private TransMapper transMapper;

    public List<SubmitBookRecord> getSubmitBookRecordList(){
        return transMapper.getSubmitBookRecordList();
    }
    public List<User> getUserListByBookId(int bookId){
        return transMapper.getUserListByBookId(bookId);
    }
    public List<SubmitBookRecord> getSubmitBookRecordByBookId(int bookId) {
        return transMapper.getSubmitBookRecordByBookId(bookId);
    }

}
