package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.controller.clockingin.vo.OvertimeVO;
import cn.gson.linyun.model.mapper.clockingin.IClockinginLeaveMapper;
import cn.gson.linyun.model.mapper.recruit.ArchivesEmpMapper;
import cn.gson.linyun.model.mapper.system.ISystemDepartmentMapper;
import cn.gson.linyun.model.mapper.system.ISystemPostMapper;
import cn.gson.linyun.model.mapper.workflow.AlinkeyMapper;
import cn.gson.linyun.model.mapper.workflow.WorkflowFlowMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import cn.gson.linyun.model.service.recruit.ArchivesEmpService;
import cn.gson.linyun.model.service.system.SystemDepartmentService;
import cn.gson.linyun.model.service.system.SystemPostService;
import cn.gson.linyun.model.service.workflow.AlinkeyService;
import cn.gson.linyun.model.service.workflow.WorkflowFlowService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClockinginLeaveService {
    @Autowired
    IClockinginLeaveMapper leaveMapper;

    @Autowired
    AlinkeyService alinkeyService;/*类型*/

    @Autowired
    ArchivesEmpService empService;/*员工*/

    @Autowired
    SystemPostService systemPostService;/*职位*/

    @Autowired
    SystemDepartmentService departmentService;/*部门*/

    @Autowired
    WorkflowFlowService flowService;/*流程*/

    public PageInfo<ClockinginLeave> selectAllByEmpId(Integer pageNo,Integer pageSize,Integer empId,String datastart,String datafinish){
        PageHelper.startPage(pageNo,pageSize);
        List<ClockinginLeave> clockinginLeaves = leaveMapper.selectAllByEmpId(empId,datastart,datafinish);
        PageInfo<ClockinginLeave> of = PageInfo.of(clockinginLeaves);
        return of;
    }

    /*新增请假信息 insertLeave*/
    public Integer insertAddLeave(ClockinginLeave leave){
        return leaveMapper.insertLeave(leave);
    }

    /*新增请假信息 insertLeave*/
    public Integer insertLeave(OvertimeVO leave){
        ArchivesEmp archivesEmp = empService.selectEmpById(leave.getEmpId());
        SystemDepartment systemDepartment = departmentService.selectByDeptId(leave.getDeptId());
        ArchivesEmp archivesEmp1 = empService.selectEmpById(leave.getSpr());
        Alinkey alinkeys =new Alinkey();
        alinkeys.setAlinkeyId(leave.getAlinkId());
        SystemPost systemPost = systemPostService.SelectByid(leave.getPostId());
        WorkflowFlow flow =
                flowService.SelectByid(leave.getFlowId());

        ClockinginLeave cleave=new ClockinginLeave();
        cleave.setLeaveDays(leave.getReasons());
        cleave.setLeaveReason(leave.getExplain());
        cleave.setLeaveFinish(leave.getFinish());
        cleave.setLeaveStart(leave.getStart());
        cleave.setEmpId(archivesEmp);
        cleave.setArcEmpId(archivesEmp1);
        cleave.setPostId(systemPost);
        cleave.setAlinkeyId(alinkeys);
        cleave.setFlowId(flow);
        cleave.setDepartmentId(systemDepartment);

        Integer integer = this.insertAddLeave(cleave);
        System.out.println("新增后返回的主键编号:"+cleave.getLeaveId());
        return integer;
    }
}
