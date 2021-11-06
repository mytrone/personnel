package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecruitRecruitapplyMapper {
    Integer insertRecruitapply(RecruitRecruitapply recruitRecruitapply);
}
