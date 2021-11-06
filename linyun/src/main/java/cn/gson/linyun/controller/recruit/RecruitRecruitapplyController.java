package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.RecruitRecruitapplyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.sql.Date;

@RestController
@RequestMapping("/recruitRecruitapply")
public class RecruitRecruitapplyController {
    @Autowired
    RecruitRecruitapplyService service;

    @RequestMapping("/insertRecruitapply")
    public Integer add(@RequestBody RecruitRecruitapplyVO vo){
        RecruitRecruitapply recruitRecruitapply=new RecruitRecruitapply();
        //Timestamp获取当前系统时间
        Timestamp tim = new Timestamp(System.currentTimeMillis());
        System.out.println("水水水水"+vo);
        ArchivesEmp archivesEmp=new ArchivesEmp();
        archivesEmp.setEmpId(1);
        System.out.println(archivesEmp.getEmpId());
        //申请员工id
        recruitRecruitapply.setArchivesEmpByEmpId(archivesEmp);
        //申请标题
        recruitRecruitapply.setRecruitapplyTitle(vo.getRecruitapplyTitle());
        //提交时间
        recruitRecruitapply.setRecruitapplyTime(tim);
        //需求岗位
        recruitRecruitapply.setRecruitapplyPosition(vo.getRecruitapplyPosition());
        //需求人数
        recruitRecruitapply.setRecruitapplyPnum(vo.getRecruitapplyPnum());
        //需求原因
        recruitRecruitapply.setRecruitapplyEason(vo.getRecruitapplyEason());
        //需求状态，状态默认为0，待审核
        recruitRecruitapply.setRecruitapplyState(0);

        Integer i = service.insertRecruitapply(recruitRecruitapply);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
