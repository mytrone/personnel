package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import cn.gson.linyun.model.service.flnance.FinanceTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("template")
public class FinanceTemplateController {
    @Autowired
    FinanceTemplateService financeTemplateService;
    @RequestMapping("/addtemplate")
    public String addTemplatey(@RequestBody FinanceTemplate financeTemplate){
        System.out.println(financeTemplate);
            financeTemplateService.addTemplate(financeTemplate);
            return "ok";
    }

}
