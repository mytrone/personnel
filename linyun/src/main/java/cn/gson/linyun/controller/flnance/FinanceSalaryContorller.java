package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.service.flnance.FinanceChecksonService;
import cn.gson.linyun.model.service.flnance.FinanceSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class FinanceSalaryContorller {
    @Autowired
    FinanceSalaryService financeSalaryService;
}
