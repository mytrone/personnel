package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceSalary;
import cn.gson.linyun.model.pojos.flnance.FinanceSalaryson;
import cn.gson.linyun.model.service.flnance.FinanceSalarysonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class FinanceSalarysonContorller {
    @Autowired
    FinanceSalarysonService financeSalarysonService;


    @RequestMapping("/chencksTj")
    public String addCheckson(@RequestBody  FinanceSalaryson financeSalaryson) {//新增工资单和工资详单

        financeSalarysonService.addCheckson(financeSalaryson);
        return "ok";
    }
    @RequestMapping("/allSalaryszy")
    public List<FinanceSalaryson> allSalaryson(@RequestBody FinanceSalaryson financeSalaryson){
        return   financeSalarysonService.allSalaryson(financeSalaryson);
    }
    @RequestMapping("/allSalarysh")
    public List<FinanceSalaryson> allSalarysonu(@RequestBody FinanceSalaryson financeSalaryson){
        return   financeSalarysonService.allSalarysonu(financeSalaryson);
    }
}
