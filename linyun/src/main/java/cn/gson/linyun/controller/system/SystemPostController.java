package cn.gson.linyun.controller.system;

import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.service.system.SystemPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemPostController {
    @Autowired
    SystemPostService systemPostService;
    //查看职位
    @GetMapping("/selPost")
    public List<SystemPost> selPost(String param){
        return systemPostService.selPost(param);
    }
    //新增职位
    @PostMapping("/addPost")
    public void addPost(@RequestBody SystemPost systemPost){
        systemPostService.addPost(systemPost);
    }
    //修改职位
    @PostMapping("/changePost")
    public void changePost(@RequestBody SystemPost post){
        systemPostService.changePost(post);
    }
    //删除职位
    @RequestMapping("/delPost")
    public void delPost(int postId){
        systemPostService.delPost(postId);
    }
}
