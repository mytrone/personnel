package cn.gson.linyun.controller.system;

import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.service.system.SystemDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemDepartmentController {
    @Autowired
    SystemDepartmentService systemDepartmentService;
    @GetMapping("/selDepartment")
    //查询部门
    public List<SystemDepartment> selDepartment(String departmentName){
        return systemDepartmentService.selDepartment(departmentName);
    }
    @PostMapping("/addDepartment")
    //新增部门
    public void addDepartment(@RequestBody SystemDepartment systemDepartment){
        systemDepartmentService.addDepartment(systemDepartment);
    }
    @PostMapping("/changeDepartment")
    //修改部门
    public void changeDepartment(@RequestBody SystemDepartment systemDepartment){
        systemDepartmentService.changeDepartment(systemDepartment);
    }
    @RequestMapping("/delDepartment")
    //删除部门
    public void delDepartment(int departmentId){
        systemDepartmentService.delDepartment(departmentId);
    }
}
