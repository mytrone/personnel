package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceSalaryMapper;
import cn.gson.linyun.model.mapper.flnance.FinanceSalarysonMapper;
import cn.gson.linyun.model.pojos.flnance.FinanceSalaryson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceSalarysonService {
    @Autowired
    FinanceSalarysonMapper financeSalarysonMapper;

    public void addCheckson(FinanceSalaryson financeSalaryson) {
        financeSalarysonMapper.addSalaryson(financeSalaryson);
    }
    public List<FinanceSalaryson> allSalaryson(FinanceSalaryson financeSalaryson){
      return   financeSalarysonMapper.allSalaryson(financeSalaryson);
    }
    public List<FinanceSalaryson> allSalarysonu(FinanceSalaryson financeSalaryson){
        return   financeSalarysonMapper.allSalarysonu(financeSalaryson);
    }
}
