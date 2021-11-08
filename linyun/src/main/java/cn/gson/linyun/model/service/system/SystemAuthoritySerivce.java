package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemAuthorityMapper;
import cn.gson.linyun.model.pojos.system.SystemAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemAuthoritySerivce {
    @Autowired
    ISystemAuthorityMapper iSystemAuthorityMapper;
    //查询所有权限
    public List<SystemAuthority> selAuthority(){
        List<SystemAuthority> systemAuthorities = iSystemAuthorityMapper.selAuthority();
        for (SystemAuthority systemAuthority : systemAuthorities) {
            systemAuthority.setAuthorityChilds(selChild(systemAuthority.getAuthorityId()));
        }
        return systemAuthorities;
    }
    //递归获得子集
    public List<SystemAuthority> selChild(Long parentId){
        List<SystemAuthority> systemAuthorities = iSystemAuthorityMapper.selChild(parentId);
        for (SystemAuthority systemAuthority : systemAuthorities) {
            //递归获取子级
            systemAuthority.setAuthorityChilds(selChild(systemAuthority.getAuthorityId()));
        }
        return systemAuthorities;
    }

    //根据用户id获得路由
    public List<SystemAuthority> selAuthorityByStaffId(long staffId){
        return iSystemAuthorityMapper.selAuthorityByStaffId(staffId);
    }
}
