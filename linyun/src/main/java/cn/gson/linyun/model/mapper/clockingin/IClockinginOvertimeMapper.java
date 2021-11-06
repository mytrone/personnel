package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IClockinginOvertimeMapper {

    /*查询当天是否有加班申请 selectOvertimeByEmpId*/
    List<ClockinginOvertime> selectOvertimeByEmpId(Integer empId);

}
