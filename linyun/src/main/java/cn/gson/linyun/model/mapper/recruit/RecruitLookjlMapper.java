package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import cn.gson.linyun.model.pojos.recruit.RecruitLookjl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitLookjlMapper {
    Integer insertRecruitLookjl(RecruitLookjl recruitLookjl);
}