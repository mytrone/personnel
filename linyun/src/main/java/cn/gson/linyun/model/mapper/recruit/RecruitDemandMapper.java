package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitDemandMapper {
    Integer insertDemand(RecruitDemand recruitDemand);
    List<RecruitDemand> selectDemand();
    List<RecruitDemand> selectDemandId(Integer demandId);
}
