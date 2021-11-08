package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.controller.clockingin.vo.ReimburseVo;
import cn.gson.linyun.model.mapper.clockingin.IClockinginDetailsMapper;
import cn.gson.linyun.model.mapper.clockingin.IClockinginLeaveMapper;
import cn.gson.linyun.model.mapper.clockingin.IClockinginReimburseMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginBusiness;
import cn.gson.linyun.model.pojos.clockingin.ClockinginDetails;
import cn.gson.linyun.model.pojos.clockingin.ClockinginReimburse;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockinginReimburseService {

    @Autowired
    IClockinginReimburseMapper reimburseMapper;

    @Autowired
    IClockinginDetailsMapper detailsMapper;

    /*新增报销申请记录 insertReimburse*/
    public Integer insertReimburse(ClockinginReimburse clockinginReimburse){
        return reimburseMapper.insertReimburse(clockinginReimburse);
    }

    /*报销申请记录业务处理方法*/
    public Integer insertReimburseBusiness(ReimburseVo vo){

        ClockinginBusiness business=new ClockinginBusiness();
        business.setBusinessId(vo.getFlowId());

        Alinkey alinkey=new Alinkey();
        alinkey.setAlinkeyId(25);
        ArchivesEmp emp=new ArchivesEmp();
        emp.setEmpId(vo.getEmpId());
        WorkflowFlow flow=new WorkflowFlow();
//        flow.setFlowId(vo.get);

        ClockinginReimburse reimburse=new ClockinginReimburse();
        reimburse.setReimburseMoney(vo.getZje());
        reimburse.setAlinkeyId(alinkey);
        reimburse.setEmpId(emp);
        reimburse.setClockinginBusiness(business);
        reimburse.setReimburseMoney(vo.getZje());
        Integer integer = this.insertReimburse(reimburse);
        System.out.println(reimburse.getAlinkeyId()+"返回的主键");
        int c=0;
        if(vo.getXq().size()>0){
            for(int i=0;i<vo.getXq().size();i++){
                ClockinginDetails details=new ClockinginDetails();
                details.setReimburseId(reimburse);
                details.setDetailsMoney(vo.getXq().get(i).getJe());
                details.setDetailsName(vo.getXq().get(i).getName());
                Integer integer1 = detailsMapper.insertDetails(details);
                c+=integer1;
            }
        }
        System.out.println(c);
        return integer;
    }

    //    查询 报销申请 selectRim
    public PageInfo<ClockinginReimburse> selectRim(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<ClockinginReimburse> clockinginReimburses = reimburseMapper.selectRim();
        return PageInfo.of(clockinginReimburses);
    }

}
