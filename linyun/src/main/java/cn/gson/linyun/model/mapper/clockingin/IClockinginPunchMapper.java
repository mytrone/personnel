package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginPunch;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface IClockinginPunchMapper {

    Integer insertPunch(ClockinginPunch clockinginPunch);

    /*查看打卡为什么状态 是否已打完卡 selectPunchByEmpId*/
    List<ClockinginPunch> selectPunchByEmpId(Integer empId);



}
