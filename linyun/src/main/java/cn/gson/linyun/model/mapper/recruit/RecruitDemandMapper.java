package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecruitDemandMapper {
    Integer insertDemand(RecruitDemand recruitDemand);
}
