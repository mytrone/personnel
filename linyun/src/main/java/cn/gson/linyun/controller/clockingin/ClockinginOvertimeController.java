package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.controller.clockingin.vo.OvertimeVO;
import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import cn.gson.linyun.model.service.clockingin.ClockinginOvertimeService;
import cn.gson.linyun.model.service.workflow.WorkflowApproveService;
import cn.gson.linyun.model.service.workflow.WorkflowFlowService;
import cn.gson.linyun.model.utils.MyResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overtime")
public class ClockinginOvertimeController {

    @Autowired
    ClockinginOvertimeService overtimeService;



    /*查询当前员工所有的加班申请 selectOverAllByEmpId*/
    @GetMapping
    public MyResult selectOverAllByEmpId(@RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
                                         @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                         @RequestParam(value = "empId",defaultValue = "0") Integer empId,
                                         @RequestParam(value = "start",defaultValue = "")String start,
                                         @RequestParam(value = "finsh",defaultValue = "")String finsh){
        System.out.println(start+"====");
        PageInfo<ClockinginOvertime> clockinginOvertimePageInfo = overtimeService.selectOverAllByEmpId(pageNo, pageSize, empId,start,finsh);
        return MyResult.SUCCESS_Object(clockinginOvertimePageInfo);
    }

    @PostMapping("insertOvertime")
    public Integer setOvertimeService(@RequestBody OvertimeVO vo){
        System.out.println(vo);
        /*ClockinginOvertime overtime=new ClockinginOvertime();*/
        Integer integer = overtimeService.insertOvertime(vo);



        return integer;
//        overtime.setOvertimeReason();
        /*ClockinginOvertime overtime = new ClockinginOvertime();
        overtime.setOvertimeReason("5588");
        Integer integer = overtimeService.insertOvertime(overtime);
        System.out.println("自动生成的主键"+overtime.getOvertimeId());*/
    }


    @PostMapping("selectid")
    /**
     * 根据主键查询
     */
    public MyResult setOvertimeService(@RequestParam("id")Integer id){
      return  MyResult.SUCCESS_Object(overtimeService.selectOvertimeById(id)) ;


    }

}
