package cn.gson.linyun.model.mapper.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceCheck;
import cn.gson.linyun.model.pojos.flnance.FinanceCheckson;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceCheckMpper{
    public List<ArchivesEmp> allEmp();//查询员工
    public void  addEmp(FinanceCheck financeCheck);//新增考核表
    public List<ArchivesEmp>allCheckson(FinanceCheck financeCheck);//评分查询
}
