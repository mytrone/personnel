package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.RecruitInterviewnoticeMapper;
import cn.gson.linyun.model.mapper.recruit.RecruitLookjlMapper;
import cn.gson.linyun.model.pojos.recruit.RecruitInterviewnotice;
import cn.gson.linyun.model.pojos.recruit.RecruitLookjl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertInterviewnoticeService {
    @Autowired
    RecruitInterviewnoticeMapper mapper;
    public Integer insertRecruitapply(RecruitInterviewnotice recruitInterviewnotice){
        Integer i = mapper.insertInterviewnotice(recruitInterviewnotice);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
