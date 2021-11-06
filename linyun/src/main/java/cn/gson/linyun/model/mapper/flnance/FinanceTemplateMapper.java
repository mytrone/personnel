package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import cn.gson.linyun.model.pojos.flnance.Relationship34;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinanceTemplateMapper {
    public void addTemplate(FinanceTemplate financeTemplate);//新增末班表
    public void addRelationship(Relationship34 relationship34);//新增中间表
}
