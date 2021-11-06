package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemDepartmentMapper;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemDepartmentService {
    @Autowired
    ISystemDepartmentMapper iSystemDepartmentMapper;
    //查询部门
    public List<SystemDepartment> selDepartment(String departmentName){
        return iSystemDepartmentMapper.selDepartment(departmentName);
    }
    //新增部门
    public void addDepartment(SystemDepartment systemDepartment){
        iSystemDepartmentMapper.addDepartment(systemDepartment);
    }
    //修改部门
    public void changeDepartment(SystemDepartment systemDepartment){
        iSystemDepartmentMapper.changeDepartment(systemDepartment);
    }
    //删除部门
    public void delDepartment(int departmentId){
        iSystemDepartmentMapper.delDepartment(departmentId);
    }
}
