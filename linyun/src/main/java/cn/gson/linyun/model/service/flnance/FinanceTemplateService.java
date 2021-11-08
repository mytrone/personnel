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


        String number=  MyUtil.genrateNo("MB");//随机生成模板编号
        financeTemplate.setTemplateSerial(number);//放入模板实体类
        financeTemplateMaper.addTemplate(financeTemplate);//新增并且返回主键

        List<FinanceItem>item=financeTemplate.getFinanceItem();//接收前台关系数组或者集合
        for (FinanceItem l:item) {//循环

            FinanceItem km=new FinanceItem();//新建项目对象
            km.setItemId(l.getItemId());//在循环中赋值项目id

            Relationship34 intermediate= new Relationship34();//新建中间表对象
            intermediate.setFinanceTemplateByTemplateId(financeTemplate);//赋值模板对象的自增主键
            intermediate.setFinanceItemByItemId(km);//赋值项目对象

            financeTemplateMaper.addRelationship(intermediate);//新增中间表
        }

    }
    public List<FinanceTemplate>alltemplate(FinanceTemplate financeTemplate){
        return financeTemplateMaper.alltemplate(financeTemplate);
    }
    public  void delTemplate(FinanceTemplate financeTemplate){//删除模板表
        Relationship34 intermediate= new Relationship34();//新建中间表对象
       intermediate.setFinanceTemplateByTemplateId(financeTemplate);//赋值模板对象的自增主键
        financeTemplateMaper.demiddel(intermediate);//删除中间表
        System.out.println(financeTemplate.getTemplateId());
        financeTemplateMaper.uplTemplate(financeTemplate);//删除模板表


    }//查询模板下的项目
    public List<FinanceItem>allmiddel(FinanceTemplate financeTemplate){
        return financeTemplateMaper.allmiddel(financeTemplate);
    }//模板项目查询
    public List<FinanceTemplate>alltemplates(FinanceTemplate financeTemplate){

        return financeTemplateMaper.alltemplates(financeTemplate);
    }

}
