package cn.sbtp.controller.userManagement;

import cn.sbtp.model.Book;
import cn.sbtp.model.User;
import cn.sbtp.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户上传头像图片")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "uploadIcon", method = RequestMethod.POST)
    public Map uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("userId") int id) throws IOException{
        request.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            //将图片名存入user表
            userService.insertIconName(id, fileName);
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 设置存放图片文件的路径
                    path = "E:/bookMate/src/main/resources/images/icons" + fileName ;
                    file.transferTo(new File(path));
                    map.put("status", 1);
                    map.put("msg", "上传图片成功");
                    map.put("iconName", fileName);
                }else {
                    map.put("status", 0);
                    map.put("msg", "不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                map.put("status", 0);
                map.put("msg", "文件类型为空");
            }
        }
        else {
            map.put("status", 0);
            map.put("msg", "没有找到相应的文件");
        }
        return map;
    }

    @ApiOperation("获取用户信息")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
    public Map getIconName(@RequestParam("userId") int id){
        Map map = new HashMap();
        User user = userService.getUserInfo(id);
        map.put("status", 1);
        map.put("user", user);
        return map;
    }

    @ApiOperation("修改用户信息")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public Map updateUserInfo(@RequestParam("userId") int id,
                              @RequestParam("name") String name,
                              @RequestParam("phoneNum") String phoneNum,
                              @RequestParam("QQ") String QQ){
        Map map = new HashMap();
        return map;
    }

    @ApiOperation("获取某本书发布者列表")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getSubmitUserList", method = RequestMethod.POST)
    public Map getSubmitUserList(@RequestParam("bookId") int id){
        Map map = new HashMap();
        List<User> submitUserList = userService.getSubmitUserList(id);
        map.put("status", 1);
        map.put("submitUserList", submitUserList);
        return map;
    }
}
