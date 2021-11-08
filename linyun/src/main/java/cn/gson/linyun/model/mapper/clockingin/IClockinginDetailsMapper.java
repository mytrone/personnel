package cn.gson.linyun.model.mapper.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
public interface IClockinginDetailsMapper {

    List<ClockinginDetails> selectById(Integer detId);

    //新增报销详情 insertDetails
    Integer insertDetails(ClockinginDetails details);

}
