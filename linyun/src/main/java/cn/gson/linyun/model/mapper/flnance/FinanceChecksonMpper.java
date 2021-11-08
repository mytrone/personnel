package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceCheckson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceChecksonMpper {
    public void addCheckson(FinanceCheckson bmp);//新增评分详细
   public List<FinanceCheckson> seCheckson(FinanceCheckson financeCheckson);//子表查询

}
