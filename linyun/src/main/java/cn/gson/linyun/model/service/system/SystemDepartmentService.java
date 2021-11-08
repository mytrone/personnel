package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemDepartmentMapper;
import cn.gson.linyun.model.mapper.system.ISystemPostMapper;
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
    @Autowired
    ISystemPostMapper iSystemPostMapper;
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
    public String delDepartment(int departmentId){
        //判断部门下是否有员工
        if(iSystemDepartmentMapper.selEmpBydeptId(departmentId)==0){
            //删除部门下的职位
            iSystemPostMapper.delPostByDepartmentId(departmentId);
            //删除部门
            iSystemDepartmentMapper.delDepartment(departmentId);

            return "yes";
        }else{
            return "no";
        }
    }

    /*根据编号查询 selectByDeptId deptId*/
    public SystemDepartment selectByDeptId(Integer deptId){
        return iSystemDepartmentMapper.selectByDeptId(deptId);
    }
}
