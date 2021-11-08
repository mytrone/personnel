package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginBusiness;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IClockinginBusinessMapper {/*出差表*/
    //    查询未申请的出差报销单和为通过的 selectAllByEmpId
    List<ClockinginBusiness> selectAllByEmpId(Integer empId);
}
