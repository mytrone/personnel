package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import cn.gson.linyun.model.pojos.flnance.Relationship34;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceTemplateMapper {
    public void addTemplate(FinanceTemplate financeTemplate);//新增模板表
    public void addRelationship(Relationship34 relationship34);//新增中间表
    public List<FinanceTemplate>alltemplate(FinanceTemplate financeTemplate);//连表查询
    public void uplTemplate(FinanceTemplate financeTemplate);//删除模板
    public void demiddel(Relationship34 relationship34);//删除项目
    public List<FinanceItem>allmiddel(FinanceTemplate financeTemplate);//查询模板下的项目

    public List<FinanceTemplate>alltemplates();//模板项目查询
}
