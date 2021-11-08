package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.service.flnance.FinanceSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submit")
public class FinanceSubmitContorller {
    @Autowired
    FinanceSubmitService financeSubmitService;
}
