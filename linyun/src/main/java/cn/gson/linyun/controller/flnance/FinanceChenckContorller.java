package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceCheck;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.service.flnance.FinanceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chenck")
public class FinanceChenckContorller {
    @Autowired
    FinanceCheckService financeCheckService;
    @RequestMapping("/chencks")
    public List<ArchivesEmp> allEmp(@RequestBody  ArchivesEmp archivesEmp){//查询员工
        return financeCheckService.allEmp(archivesEmp);
    }
    @RequestMapping("/addChencks")
    public String addEmp(@RequestBody Map<String,Object> datas){//新增评分表和从表

        financeCheckService.addEmp(datas);
       return "ok";
    }
    @RequestMapping("/allChenh")
    public List<FinanceCheck>allCheckson(@RequestBody FinanceCheck financeCheckw){//查询评分主表
        System.out.println(financeCheckw.getCheckSerial());
        return financeCheckService.allCheckson(financeCheckw);
    }
    @RequestMapping("/allChyg")
    public List<ArchivesEmp> allEmpr(){
        return financeCheckService.allEmpr();

    }

}
