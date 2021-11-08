package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceSalaryson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceSalarysonMapper {
    public void addSalaryson(FinanceSalaryson financeSalaryson) ;
    public List<FinanceSalaryson> allSalaryson(FinanceSalaryson financeSalaryson);
    public List<FinanceSalaryson> allSalarysonu(FinanceSalaryson financeSalaryson);

}
