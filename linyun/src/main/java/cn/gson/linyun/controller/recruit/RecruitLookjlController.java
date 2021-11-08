package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitLookjl;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitLookjlVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.RecruitLookjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/recruitLookjl")
public class RecruitLookjlController {
    @Autowired
    RecruitLookjlService service;

    @RequestMapping("/selectRecruitLookjl")
    public List<RecruitLookjl> selectRecruitLookjl(){
        System.out.println("进入方法");
        return service.selectRecruitLookjl();
    }


    @RequestMapping("/insertrecruitLookjl")
    public Integer add(@RequestBody RecruitLookjlVO vo) {
        RecruitLookjl recruitLookjl = new RecruitLookjl();
        recruitLookjl.setLookjlName(vo.getLookjlName());
        recruitLookjl.setLookjlStudy(vo.getLookjlStudy());
        Integer i = service.insertRecruitapply(recruitLookjl);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
