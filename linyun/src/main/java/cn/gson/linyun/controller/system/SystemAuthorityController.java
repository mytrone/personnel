package cn.gson.linyun.controller.system;

import cn.gson.linyun.model.pojos.system.SystemAuthority;
import cn.gson.linyun.model.service.system.SystemAuthoritySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/system")
public class SystemAuthorityController {
    @Autowired
    SystemAuthoritySerivce systemAuthoritySerivce;
    //查看权限
    @GetMapping("/selAuthority")
    public List<SystemAuthority> selAuthority(){
        return systemAuthoritySerivce.selAuthority();
    }
}
