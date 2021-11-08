package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinancSubmitMpper;
import cn.gson.linyun.model.mapper.flnance.FinanceSalarysonMapper;
import cn.gson.linyun.model.pojos.flnance.ClockinginReimburse;
import cn.gson.linyun.model.pojos.flnance.FinanceSubmit;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceSubmitService {
    @Autowired
    FinancSubmitMpper financeSubmitMapper;
    public List<ClockinginReimburse> allSubmit( ArchivesEmp archivesEmp){
         return financeSubmitMapper.allSubmit(archivesEmp);
    }
    //添加记录
    public void  addSubmit(FinanceSubmit financSubmit){
        financeSubmitMapper.addSubmit(financSubmit);//新增记录
        ClockinginReimburse duy=new ClockinginReimburse();
        duy.setReimburseId(financSubmit.getSubmitId());
        financeSubmitMapper.upClocking(duy);//修改申请状态
    }
    public List<FinanceSubmit> allSubmitu(FinanceSubmit financeSubmit){//查询记录表
        return financeSubmitMapper.allSubmitu(financeSubmit);
    }
}
