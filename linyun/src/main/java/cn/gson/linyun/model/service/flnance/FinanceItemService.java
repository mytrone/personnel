package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceItemMapper;
import cn.gson.linyun.model.pojos.flnance.Alinkey;
import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceItemService {
    @Autowired
    FinanceItemMapper financeTemplateMapper;
    public void allFinance(FinanceItem financeItem){
        financeTemplateMapper.allFinance(financeItem);
    }
    public List<FinanceItem> sllFinance(FinanceItem financeItem){
      return   financeTemplateMapper.sllFinance(financeItem);
    }
    public void deFinance(FinanceItem financeItem){
        financeTemplateMapper.deFinance(financeItem);
    }
    public List<Alinkey>allAlinkey(){
        return financeTemplateMapper.allAlinkey();
    }
}
