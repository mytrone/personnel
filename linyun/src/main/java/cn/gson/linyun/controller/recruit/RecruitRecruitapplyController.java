package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.RecruitRecruitapplyService;
import cn.gson.linyun.model.service.workflow.WorkflowApproveService;
import cn.gson.linyun.model.service.workflow.WorkflowNodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recruitRecruitapply")
public class RecruitRecruitapplyController {
    @Autowired
    RecruitRecruitapplyService service;
    @Autowired
    WorkflowApproveService workflowApproveService;//流程实例Service


    @RequestMapping("/selectRecruitapply")
    public List<RecruitRecruitapply> selectRecruitapply(){
        return service.selectRecruitapply();
    }

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
        //需求学历
        recruitRecruitapply.setRecruitapplyEducationInf(vo.getRecruitapplyEducationInf());
        //需求原因
        recruitRecruitapply.setRecruitapplyEason(vo.getRecruitapplyEason());
        //需求状态，状态默认为0，待审核
        recruitRecruitapply.setRecruitapplyState(0);

        Integer i = service.insertRecruitapply(recruitRecruitapply);
        WorkflowApproveVo workflowApproveVo=new WorkflowApproveVo();
        workflowApproveVo.setApprove_table(recruitRecruitapply.getRecruitapplyId());
        workflowApproveVo.setApprove_flow(58);//流程类型
        workflowApproveVo.setApproveState(0);//状态默认  董事长审批直接过
        workflowApproveVo.setSpPeople(2);//选择的审批人
        workflowApproveVo.setArchivesEmpsq(recruitRecruitapply.getArchivesEmpByEmpId().getEmpId());//申请人
        workflowApproveService.AddApprove(workflowApproveVo);


        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
