package cn.gson.linyun.controller.recruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/a")
    public String index(){
        System.out.println("进入方法s");
        return "hello Spring boot";
    }
}