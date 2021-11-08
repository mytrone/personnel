package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.ClockinginReimburse;
import cn.gson.linyun.model.pojos.flnance.FinanceSubmit;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.service.flnance.FinanceSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subm")
public class FinanceSubmitContorller {
    @Autowired
    FinanceSubmitService financeSubmitService;
    @RequestMapping("/allSubmit")
    public List<ClockinginReimburse> allSubmit(@RequestBody ArchivesEmp archivesEmp){
        return financeSubmitService.allSubmit(archivesEmp);
    }
    @RequestMapping("/addSubmit")
    public String  addSubmit(@RequestBody  FinanceSubmit financSubmit){
          financeSubmitService.addSubmit(financSubmit);
          return "ok";
    }
    @RequestMapping("/upSubmit")
    public List<FinanceSubmit> allSubmitu(@RequestBody FinanceSubmit financeSubmit){//查询记录表
        return financeSubmitService.allSubmitu(financeSubmit);
    }
}
