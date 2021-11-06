package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.RecruitRecruitapplyMapper;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RecruitRecruitapplyService {
    @Autowired
    RecruitRecruitapplyMapper mapper;

    public Integer insertRecruitapply(RecruitRecruitapply recruitRecruitapply){
        Integer i = mapper.insertRecruitapply(recruitRecruitapply);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
