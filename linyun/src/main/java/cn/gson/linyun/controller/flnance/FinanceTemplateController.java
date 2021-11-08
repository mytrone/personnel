package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import cn.gson.linyun.model.service.flnance.FinanceTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class FinanceTemplateController {
    @Autowired
    FinanceTemplateService financeTemplateService;
    @RequestMapping("/addtemplate")
    public String addTemplatey(@RequestBody FinanceTemplate financeTemplate){//循环新增模板表和项目表
        try{
            System.out.println(financeTemplate);
            financeTemplateService.addTemplate(financeTemplate);
            return "ok";
        }catch (Exception e){
            return "fail";
        }

    }
    @RequestMapping("/alltemplatew")
    public List<FinanceTemplate> alltemplate(@RequestBody FinanceTemplate financeTemplate){
        return financeTemplateService.alltemplate(financeTemplate);
    }
    @RequestMapping("/dlltemplatew")
    public  String delTemplate(@RequestBody FinanceTemplate financeTemplate){//删除模板表
        try{
            financeTemplateService.delTemplate(financeTemplate);
            return "ok";
        }catch (Exception e){
            return "fail";
        }
    }
    @RequestMapping("/allmiddelw")
    public List<FinanceItem>allmiddel(@RequestBody  FinanceTemplate financeTemplate){//查询模板表
        return financeTemplateService.allmiddel(financeTemplate);
    }
    @RequestMapping("/alltemplatesu")
    public List<FinanceTemplate>alltemplates(@RequestBody  FinanceTemplate financeTemplate){
        return financeTemplateService.alltemplates(financeTemplate);
    }
}
