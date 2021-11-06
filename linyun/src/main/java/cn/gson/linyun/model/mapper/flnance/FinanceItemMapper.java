package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceItemMapper {
    public void allFinance(FinanceItem financeItem);
    public List<FinanceItem> sllFinance(FinanceItem financeItem);
    public void deFinance(FinanceItem financeItem);
    public List<Alinkey>allAlinkey();
}
