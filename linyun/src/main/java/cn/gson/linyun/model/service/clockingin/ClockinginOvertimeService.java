package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.controller.clockingin.vo.OvertimeVO;
import cn.gson.linyun.model.mapper.clockingin.IClockinginOvertimeMapper;
import cn.gson.linyun.model.mapper.recruit.ArchivesEmpMapper;
import cn.gson.linyun.model.mapper.system.ISystemDepartmentMapper;
import cn.gson.linyun.model.mapper.system.ISystemPostMapper;
import cn.gson.linyun.model.mapper.workflow.AlinkeyMapper;
import cn.gson.linyun.model.mapper.workflow.WorkflowFlowMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.Area;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClockinginOvertimeService {
    @Autowired
    IClockinginOvertimeMapper iClockinginOvertimeMapper;

    @Autowired
    AlinkeyMapper alinkeyMapper;/*类型*/

    @Autowired
    ArchivesEmpMapper empMapper;/*员工*/

    @Autowired
    ISystemPostMapper systemPostMapper;/*职位*/

    @Autowired
    ISystemDepartmentMapper departmentMapper;/*部门*/

    @Autowired
    WorkflowFlowMapper flowMapper;

    /*查询当天是否有通过的加班申请 selectOvertimeByEmpId*/
    public List<ClockinginOvertime> selectOvertimeByEmpId(Integer empId){
        return iClockinginOvertimeMapper.selectOvertimeByEmpId(empId);
    }

    /*查询当前员工所有的加班申请 selectOverAllByEmpId*/
    public PageInfo<ClockinginOvertime> selectOverAllByEmpId(Integer pageNo,Integer pageSize,Integer empId,String start,String finsh){
        PageHelper.startPage(pageNo,pageSize);
        List<ClockinginOvertime> clockinginOvertimes = iClockinginOvertimeMapper.selectOverAllByEmpId(empId,start,finsh);
        PageInfo<ClockinginOvertime> of = PageInfo.of(clockinginOvertimes);
        return of;
    }

    public Integer insertOvertime(OvertimeVO vo){

        Alinkey alinkey = alinkeyMapper.selectAlinkeyByName(vo.getTypeName());/*查询的加班类型*/
        ArchivesEmp archivesEmp = empMapper.selectEmpById(vo.getEmpId());/*查询申请人*/
        ArchivesEmp approver=empMapper.selectEmpById(vo.getSpr());/*查询是否存在这个审批人*/
        SystemPost systemPost = systemPostMapper.selectByPostId(vo.getPostId());/*职位*/
        SystemDepartment systemDepartment = departmentMapper.selectByDeptId(vo.getDeptId());
        WorkflowFlow flow=flowMapper.SelectByid(vo.getFlowId());

        ClockinginOvertime overtime=new ClockinginOvertime();
        overtime.setOvertimeStart(vo.getStart());
        overtime.setOvertimeFinish(vo.getFinish());
        overtime.setAlinkeyByAlinkeyId(alinkey);
        overtime.setOvertimeReason(vo.getExplain());
        overtime.setArchivesEmpByEmpId(archivesEmp);
        overtime.setArchivesEmpByArcEmpId(approver);
        overtime.setSystemPostBySystemPost(systemPost);
        overtime.setOvertimeState(1);
        overtime.setSystemDepartmentByDepartmentId(systemDepartment);
        overtime.setOvertimeDuration(vo.getReason());
        overtime.setWorkflowFlowByFlowId(flow);

        Integer integer = iClockinginOvertimeMapper.insertOvertime(overtime);/*新增加班申请记录*/

        System.out.println("生成的加班编号"+overtime.getOvertimeId());

        return 1;
//        return iClockinginOvertimeMapper.insertOvertime(overtime);
    }

}
