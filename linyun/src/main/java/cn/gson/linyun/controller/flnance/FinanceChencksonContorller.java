package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceCheck;
import cn.gson.linyun.model.pojos.flnance.FinanceCheckson;
import cn.gson.linyun.model.pojos.flnance.FinanceSalaryson;
import cn.gson.linyun.model.service.flnance.FinanceChecksonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chenckson")
public class FinanceChencksonContorller {
    @Autowired
    FinanceChecksonService financeChecksonService;
    @RequestMapping("/chencksonp")
    public List<FinanceCheckson> seCheckson(@RequestBody FinanceCheck financeCheckw){//从表查询
        return financeChecksonService.seCheckson(financeCheckw);
    }

}
