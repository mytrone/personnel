package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitInterviewnotice;
import cn.gson.linyun.model.pojos.recruit.RecruitLookjl;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitInterviewnoticeVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitLookjlVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.InsertInterviewnoticeService;
import cn.gson.linyun.model.service.recruit.RecruitLookjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/recruitInterviewnotice")
public class RecruitInterviewnoticeController {
    @Autowired
    InsertInterviewnoticeService service;


    @RequestMapping("/insertInterviewnotice")
    public Integer add(@RequestBody RecruitInterviewnoticeVO vo) {
        Timestamp tim = new Timestamp(System.currentTimeMillis());
        RecruitInterviewnotice recruitInterviewnotice = new RecruitInterviewnotice();
        recruitInterviewnotice.setInterviewnoticeName(vo.getInterviewnoticeName());
        recruitInterviewnotice.setInterviewnoticeIntime(vo.getInterviewnoticeIntime());
        recruitInterviewnotice.setInterviewnoticeDidian(vo.getInterviewnoticeDidian());
        recruitInterviewnotice.setInterviewnoticeTel(vo.getInterviewnoticeTel());
        recruitInterviewnotice.setInterviewnoticeTime(tim);
        Integer i = service.insertRecruitapply(recruitInterviewnotice);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
