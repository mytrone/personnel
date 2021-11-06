package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitDemandVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.RecruitDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/recruitDemand")
public class RecruitDemandController {
    @Autowired
    RecruitDemandService service;

    @RequestMapping("/insertDemand")
    public Integer add(@RequestBody RecruitDemandVO vo){
        RecruitDemand recruitDemand=new RecruitDemand();
        //Timestamp获取当前系统时间
        Timestamp tim = new Timestamp(System.currentTimeMillis());
        System.out.println("水水水水"+vo);
        RecruitRecruitapply recruitRecruitapply=new RecruitRecruitapply();
        recruitRecruitapply.setRecruitapplyId(1);
        System.out.println(recruitRecruitapply.getRecruitapplyId());
        //发布人
        recruitDemand.setDemandName(vo.getDemandName());
        //职位信息
        recruitDemand.setDemandPositionInf(vo.getDemandPositionInf());
        //工作经验（年）
        recruitDemand.setDemandWorkyear(vo.getDemandWorkyear());
        //工作地点
        recruitDemand.setDemandAddress(vo.getDemandAddress());
        //联系方式（电话）
        recruitDemand.setDemandTel(vo.getDemandTel());
        //薪资范围
        recruitDemand.setDemandMoney(vo.getDemandMoney());
        //发布时间
        recruitDemand.setDemandTime(tim);

        //需求状态，状态默认为0，待审核
        recruitDemand.setDemandState(0);

        Integer i = service.insertDemand(recruitDemand);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
