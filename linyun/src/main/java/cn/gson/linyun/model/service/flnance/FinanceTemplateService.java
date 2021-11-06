package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceTemplateMapper;
import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import cn.gson.linyun.model.pojos.flnance.Relationship34;
import cn.gson.linyun.model.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceTemplateService {
    @Autowired
    FinanceTemplateMapper financeTemplateMaper;
    public void addTemplate(FinanceTemplate financeTemplate){
        String danhao=  MyUtil.genrateNo("MB");//订单编号
        financeTemplate.setTemplateSerial(danhao);//
        List<FinanceItem>item=financeTemplate.getFinanceItem();//前台数组
        financeTemplateMaper.addTemplate(financeTemplate);
    }



}
