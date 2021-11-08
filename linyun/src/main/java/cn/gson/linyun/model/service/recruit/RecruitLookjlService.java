package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.RecruitLookjlMapper;
import cn.gson.linyun.model.pojos.recruit.RecruitLookjl;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitLookjlService {
    @Autowired
    RecruitLookjlMapper mapper;
    public Integer insertRecruitapply(RecruitLookjl recruitLookjl){
        Integer i = mapper.insertRecruitLookjl(recruitLookjl);
        if (i>0){
            return 1;
        }
        return 0;
    }

    public List<RecruitLookjl> selectRecruitLookjl(){
        return mapper.selectRecruitLookjl();
    }
}
