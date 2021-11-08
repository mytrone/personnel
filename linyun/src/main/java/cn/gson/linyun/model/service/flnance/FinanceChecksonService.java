package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceCheckMpper;
import cn.gson.linyun.model.mapper.flnance.FinanceChecksonMpper;
import cn.gson.linyun.model.pojos.flnance.FinanceCheckson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceChecksonService {
    @Autowired
    FinanceChecksonMpper financeChecksonMpper;
    //子表查询
    public List<FinanceCheckson> seCheckson(FinanceCheckson financeCheckson){
        return financeChecksonMpper.seCheckson(financeCheckson);
    }

}
