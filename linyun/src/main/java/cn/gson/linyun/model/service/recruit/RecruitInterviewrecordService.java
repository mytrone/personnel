package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.RecruitInterviewnoticeMapper;
import cn.gson.linyun.model.mapper.recruit.RecruitInterviewrecordMapper;
import cn.gson.linyun.model.pojos.recruit.RecruitInterviewrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitInterviewrecordService {
    @Autowired
    RecruitInterviewrecordMapper mapper;
    public List<RecruitInterviewrecord> selectInterviewrecord(){
        return mapper.selectInterviewrecord();
    }

    public Integer insertInterviewrecord(RecruitInterviewrecord recruitInterviewrecord){
        Integer i = mapper.insertInterviewrecord(recruitInterviewrecord);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
