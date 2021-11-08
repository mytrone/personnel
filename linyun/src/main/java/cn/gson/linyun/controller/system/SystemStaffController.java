package cn.gson.linyun.controller.system;

import cn.gson.linyun.model.pojos.system.SystemRole;
import cn.gson.linyun.model.pojos.system.SystemStaff;
import cn.gson.linyun.model.service.system.SystemStaffService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class SystemStaffController {
    @Autowired
    SystemStaffService systemStaffService;
    //根据账号密码查看对象
    @PostMapping("/selStaff")
    public SystemStaff selStaff(@RequestBody SystemStaff systemStaff){
        return systemStaffService.selStaff(systemStaff);
    }
    //新增用户
    @PostMapping("/addStaff")
    public String addStaff(@RequestBody Map<String,Object> map){
        SystemStaff systemStaff= JSON.parseObject(JSON.toJSONString(map.get("systemStaff")), SystemStaff.class);
        List<Integer> roleIds = JSONArray.parseArray(JSON.toJSONString(map.get("roleIds")),Integer.TYPE);
        return  systemStaffService.addStaff(systemStaff,roleIds);
    }
    //修改用户
    @PostMapping("/changeStaff")
    public void changeStaff(@RequestBody Map<String,Object> map){
        SystemStaff systemStaff= JSON.parseObject(JSON.toJSONString(map.get("systemStaff")), SystemStaff.class);
        List<Integer> roleIds = JSONArray.parseArray(JSON.toJSONString(map.get("roleIds")),Integer.TYPE);
        systemStaffService.changeStaff(systemStaff,roleIds);
    }
    //查看用户
    @GetMapping("/selStaffByAccount")
    public List<SystemStaff> selStaffByAccount(String staffAccount){
        return systemStaffService.selStaffByAccount(staffAccount);
    }
    //修改用户密码
    @PostMapping("/changeStaffCode")
    public void changeStaffCode(@RequestBody SystemStaff systemStaff){
        systemStaffService.changeStaffCode(systemStaff);
    }
}
