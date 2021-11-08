package cn.gson.linyun.model.mapper.system;

import cn.gson.linyun.model.pojos.system.SystemStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISystemStaffMapper {
    //查询用户根据账号密码
    SystemStaff selStaff(SystemStaff systemStaff);
    //根据用户名查询用户
    List<SystemStaff> selStaffByAccount(String staffAccount);
    //新增用户
    void addStaff(SystemStaff systemStaff);
    //用户与角色关联
    void addStaffRole(@Param("staffId")long staffId,@Param("roleId")long roleId);
    //删除用户与角色关联
    void delStaffRole(long staffId);
    //修改用户
    void changeStaff(SystemStaff systemStaff);
    //修改用户密码
    void changeStaffCode(SystemStaff systemStaff);
}
