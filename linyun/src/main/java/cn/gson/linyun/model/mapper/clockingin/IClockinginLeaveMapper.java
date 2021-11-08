package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IClockinginLeaveMapper {
    /*查询当前员工所有请假信息 selectAllByEmpId*/
    List<ClockinginLeave> selectAllByEmpId(Integer empId);
}
