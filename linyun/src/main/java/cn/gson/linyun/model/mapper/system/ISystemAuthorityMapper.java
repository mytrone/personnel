package cn.gson.linyun.model.mapper.system;

import cn.gson.linyun.model.pojos.system.SystemAuthority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISystemAuthorityMapper {
    //查找一级路由
    List<SystemAuthority> selAuthority();
    //根据父级id查找子集路由
    List<SystemAuthority> selChild(Long parentId);
    //根据用户id获得路由
    List<SystemAuthority> selAuthorityByStaffId(long staffId);
}
