package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemRoleMapper;
import cn.gson.linyun.model.pojos.system.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemRoleService {
    @Autowired
    ISystemRoleMapper iSystemRoleMapper;
    //查看角色
    public List<SystemRole> selRole(String roleName){
        return iSystemRoleMapper.selRole(roleName);
    }
    //新增角色
    public void addRole(SystemRole systemRole,List<Integer>list){
        //新增角色
        iSystemRoleMapper.addRole(systemRole);
        //循环新增角色-权限中间表
        for (Integer l:list){
            iSystemRoleMapper.addRoleAuthority(systemRole.getRoleId(),l);
        }
    }
    //删除角色
    public String delRole(int roleid){

        if(iSystemRoleMapper.selStaffRole(roleid)!=0){
            return "no";
        }else{
            iSystemRoleMapper.delRole(roleid);
            iSystemRoleMapper.delRoleAuthority(roleid);
            return "yes";
        }
    }
    //查看角色的权限
    public List<Integer> selRoleAuthority(int roleId){
        return iSystemRoleMapper.selRoleAuthority(roleId);
    }
    //修改角色
    public void changeRole(SystemRole systemRole,List<Integer>list){
        iSystemRoleMapper.changeRole(systemRole);
        //清空之前的权限
        iSystemRoleMapper.delRoleAuthority(systemRole.getRoleId());
        //新增权限
        for (Integer l:list){
            iSystemRoleMapper.addRoleAuthority(systemRole.getRoleId(),l);
        }
    }
    //根据用户编号查询角色
    public List<SystemRole> selRoleByStaffId(int staffId){
        return iSystemRoleMapper.selRoleByStaffId(staffId);
    }
}
