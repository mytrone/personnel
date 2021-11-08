package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.RecruitDemandMapper;
import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitDemandService {
    @Autowired
    RecruitDemandMapper mapper;

    public List<RecruitDemand> selectDemand(){
        return mapper.selectDemand();
    }

    public List<RecruitDemand> selectDemandId(Integer demandId){
        return mapper.selectDemandId(demandId);
    }

    public Integer insertDemand(RecruitDemand recruitDemand){
        Integer i = mapper.insertDemand(recruitDemand);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
