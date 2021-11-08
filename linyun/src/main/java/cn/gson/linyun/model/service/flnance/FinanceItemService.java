package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceItemMapper;
import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceItemService {
    @Autowired
    FinanceItemMapper financeTemplateMapper;
    public void allFinance(FinanceItem financeItem){//新增项目表
        financeTemplateMapper.allFinance(financeItem);
    }
    public List<FinanceItem> sllFinance(FinanceItem financeItem){//查询项目表
      return   financeTemplateMapper.sllFinance(financeItem);
    }
    public void deFinance(FinanceItem financeItem){//删除项目
        financeTemplateMapper.deFinance(financeItem);
    }
    public List<Alinkey>allAlinkey(){//查询考核类别表
        return financeTemplateMapper.allAlinkey();
    }
}
