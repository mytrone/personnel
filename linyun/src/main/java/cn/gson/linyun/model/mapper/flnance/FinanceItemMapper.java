package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceItemMapper {
    public void allFinance(FinanceItem financeItem);//新增项目表
    public List<FinanceItem> sllFinance(FinanceItem financeItem);//查询项目表
    public void deFinance(FinanceItem financeItem);//删除项目
    public List<Alinkey>allAlinkey();//查询考核类别表
}
