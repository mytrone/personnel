package cn.gson.linyun.model.mapper.system;

import cn.gson.linyun.model.pojos.system.SystemRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ISystemRoleMapper {
    //查看角色
    List<SystemRole> selRole(String roleName);
    //新增角色
    void addRole(SystemRole systemRole);
    //新增角色-权限表
    void addRoleAuthority(@Param("roleId")int roleId,@Param("authorityId")int authorityId);
    //删除角色
    void delRole(int roleId);
    //删除角色-权限
    void delRoleAuthority(int roleId);
    //查询角色的权限
    List<Integer> selRoleAuthority(int roleId);
    //修改角色
    void changeRole(SystemRole systemRole);
    //根据用户编号查询角色
    List<SystemRole> selRoleByStaffId(int staffId);
    //查询角色是否被使用
    Integer selStaffRole(int roleId);
}
