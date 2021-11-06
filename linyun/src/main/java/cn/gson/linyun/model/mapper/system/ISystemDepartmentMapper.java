package cn.gson.linyun.model.mapper.system;

import cn.gson.linyun.model.pojos.system.SystemDepartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISystemDepartmentMapper {
    //查询部门
    List<SystemDepartment> selDepartment(String departmentName);
    //新增部门
    void addDepartment(SystemDepartment systemDepartment);
    //修改部门
    void changeDepartment(SystemDepartment systemDepartment);
    //删除部门
    void delDepartment(int departmentId);
}
