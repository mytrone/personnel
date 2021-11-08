package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginReimburse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IClockinginReimburseMapper {/*报销申请*/

    /*新增报销申请记录 insertReimburse*/
    Integer insertReimburse(ClockinginReimburse clockinginReimburse);

//    查询 报销申请 selectRim
    List<ClockinginReimburse> selectRim();
}
