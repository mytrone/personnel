package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemStaffMapper;
import cn.gson.linyun.model.pojos.system.SystemStaff;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class SystemStaffService {
    @Autowired
    ISystemStaffMapper iSystemStaffMapper;
    //根据用户账号密码获取用户信息
    public SystemStaff selStaff(SystemStaff systemStaff){
        return iSystemStaffMapper.selStaff(systemStaff);
    }
    //根据用户名查询用户
    public List<SystemStaff> selStaffByAccount(String staffAccount){
        return iSystemStaffMapper.selStaffByAccount(staffAccount);
    }
    //新增用户
    public void addStaff(SystemStaff systemStaff,List<Integer>list){
        //新增用户
        iSystemStaffMapper.addStaff(systemStaff);
        //用户关联角色
        for (Integer l:list){
            iSystemStaffMapper.addStaffRole(systemStaff.getStaffId(),l);
        }
    }
    //修改用户
    public void changeStaff(SystemStaff systemStaff,List<Integer>list){
        //修改
        iSystemStaffMapper.changeStaff(systemStaff);
        //清空关联
        iSystemStaffMapper.delStaffRole(systemStaff.getStaffId());
        //用户关联角色
        for (Integer l:list){
            iSystemStaffMapper.addStaffRole(systemStaff.getStaffId(),l);
        }
    }
}
