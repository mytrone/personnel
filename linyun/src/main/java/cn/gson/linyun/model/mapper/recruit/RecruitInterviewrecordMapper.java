package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.RecruitInterviewnotice;
import cn.gson.linyun.model.pojos.recruit.RecruitInterviewrecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitInterviewrecordMapper {
    Integer insertInterviewrecord(RecruitInterviewrecord recruitInterviewrecord);

    List<RecruitInterviewrecord> selectInterviewrecord();
}
