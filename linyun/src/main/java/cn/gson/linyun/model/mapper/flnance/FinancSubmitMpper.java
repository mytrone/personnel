package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.ClockinginReimburse;
import cn.gson.linyun.model.pojos.flnance.FinanceSubmit;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinancSubmitMpper {
    public List<ClockinginReimburse> allSubmit( ArchivesEmp archivesEmp);//查询报销申请
    public void  addSubmit(FinanceSubmit financSubmit);//添加记录
    public void  upClocking(ClockinginReimburse clockinginReimburse);//修改状态
    public List<FinanceSubmit> allSubmitu(FinanceSubmit financeSubmit);
}
