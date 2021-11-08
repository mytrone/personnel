package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.*;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitInterviewnoticeVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitInterviewrecordVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitLookjlVO;
import cn.gson.linyun.model.pojos.recruit.vo.RecruitRecruitapplyVO;
import cn.gson.linyun.model.service.recruit.InsertInterviewnoticeService;
import cn.gson.linyun.model.service.recruit.RecruitInterviewrecordService;
import cn.gson.linyun.model.service.recruit.RecruitLookjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/recruitinterviewrecord")
public class RecruitInterviewrecordController {
    @Autowired
    RecruitInterviewrecordService service;

    @RequestMapping("/selectInterviewrecord")
    public List<RecruitInterviewrecord> selectInterviewrecord(){
        System.out.println("进入方法");
        return service.selectInterviewrecord();
    }

    @RequestMapping("/insertInterviewrecord")
    public Integer add(@RequestBody RecruitInterviewrecordVO vo) {
        RecruitInterviewrecord recruitInterviewrecord = new RecruitInterviewrecord();
        recruitInterviewrecord.setInterviewrecordName(vo.getInterviewrecordName());
        recruitInterviewrecord.setInterviewrecordNumber(vo.getInterviewrecordNumber());
        Integer i = service.insertInterviewrecord(recruitInterviewrecord);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
