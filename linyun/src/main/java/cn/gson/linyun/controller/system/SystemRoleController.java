package cn.gson.linyun.controller.system;

import cn.gson.linyun.model.pojos.system.SystemRole;
import cn.gson.linyun.model.service.system.SystemRoleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class SystemRoleController {
    @Autowired
    SystemRoleService systemRoleService;
    @PostMapping("/addRole")
    //新增角色
    public void addRole(@RequestBody Map<String,Object> map){
        SystemRole systemRole=JSON.parseObject(JSON.toJSONString(map.get("systemRole")),SystemRole.class);
        List<Integer> funs = JSONArray.parseArray(JSON.toJSONString(map.get("funs")),Integer.TYPE);
        systemRoleService.addRole(systemRole,funs);
    }
    @GetMapping("/selRole")
    //查询角色
    public List<SystemRole> selRole(String roleName){
        return systemRoleService.selRole(roleName);
    }
    //删除角色
    @RequestMapping("/delRole")
    public String  delRole(int roleId){
         return systemRoleService.delRole(roleId);
    }
    //查看角色的权限
    @GetMapping("/selRoleAuthority")
    public List<Integer> selRoleAuthority(int roleId){
        return systemRoleService.selRoleAuthority(roleId);
    }
    //修改角色
    @PostMapping("/changeRole")
    public void changeRole(@RequestBody Map<String,Object> map){
        SystemRole systemRole=JSON.parseObject(JSON.toJSONString(map.get("systemRole")),SystemRole.class);
        List<Integer> funs = JSONArray.parseArray(JSON.toJSONString(map.get("funs")),Integer.TYPE);
        systemRoleService.changeRole(systemRole,funs);
    }
    //根据用户编号查询角色
    @GetMapping("/selRoleByStaffId")
    public List<SystemRole> selRoleByStaffId(int staffId){
        return systemRoleService.selRoleByStaffId(staffId);
    }
}
