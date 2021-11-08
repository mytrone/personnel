package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IClockinginLeaveMapper {
    /*查询当前员工所有请假信息 selectAllByEmpId*/
    List<ClockinginLeave> selectAllByEmpId(@Param("empId") Integer empId,
                                           @Param("datastart") String datastart,
                                           @Param("datafinish") String datafinish);

    /*新增请假信息 insertLeave*/
    Integer insertLeave(ClockinginLeave leave);

}
