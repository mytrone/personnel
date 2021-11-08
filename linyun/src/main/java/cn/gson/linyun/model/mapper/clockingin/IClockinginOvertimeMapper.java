package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Mapper
@Repository
public interface IClockinginOvertimeMapper {

    /*查询当天是否有加班申请 selectOvertimeByEmpId*/
    List<ClockinginOvertime> selectOvertimeByEmpId(Integer empId);

    /*查询当前员工所有的加班申请 selectOverAllByEmpId*/
    List<ClockinginOvertime> selectOverAllByEmpId(@Param("empId") Integer empId,
                                                  @Param("start") String start,
                                                  @Param("finish")String finish);

    Integer insertOvertime(ClockinginOvertime overtime);

}
