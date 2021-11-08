package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceChecksonMpper;
import cn.gson.linyun.model.mapper.flnance.FinanceSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FinanceSalaryService {
    @Autowired
    FinanceSalaryMapper financeSalaryMpper;
}
