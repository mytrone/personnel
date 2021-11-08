package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import cn.gson.linyun.model.pojos.clockingin.ClockinginPunch;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.service.clockingin.ClockinginOvertimeService;
import cn.gson.linyun.model.service.clockingin.ClockinginPunchService;
import cn.gson.linyun.model.service.recruit.ArchivesEmpService;
import cn.gson.linyun.model.service.workflow.AlinkeyService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/punch")
public class PunchConterller {/*打卡Conterller*/

    @Autowired
    ClockinginPunchService clockinginPunchService;//打卡表servie

    @Autowired
    ClockinginOvertimeService clockinginOvertimeService;//加班申请Service

    @Autowired
    ArchivesEmpService archivesEmpService;/*员工Service*/

    @Autowired
    AlinkeyService alinkeyService;/*状态Service*/

    MyResult myResult=new MyResult();

    @GetMapping
    public List<ClockinginPunch> selectAll(@RequestParam(value = "empid",defaultValue = "") Integer empid){
        System.out.println(empid);
        if(empid!=null){
            /*查看打卡为什么状态 是否已打完卡 selectPunchByEmpId*/
            List<ClockinginPunch> clockinginPunches =
                    clockinginPunchService.selectPunchByEmpId(empid);
            return clockinginPunches;
        }
        return null;
    }

    @GetMapping("OvertimeByEmpId")
    public MyResult selectOvertimeByEmpId(Integer empId){
        /*查询当天是否有通过的加班申请 selectOvertimeByEmpId*/
        List<ClockinginOvertime> clockinginOvertimes = clockinginOvertimeService.selectOvertimeByEmpId(empId);
        return MyResult.SUCCESS_DATA(clockinginOvertimes);
    }

    @PostMapping("addPunch")
    public MyResult addPunch(String date,Integer empid,String state) throws ParseException {
        if(date==null || empid==null || state==null){
            myResult.setMsg("打卡失败");
            myResult.setCode(0);
            return myResult;
        }

        //注意format的格式要与日期String的格式相匹配
        Timestamp ts = Timestamp.valueOf(date);
        System.out.println(ts);

        ArchivesEmp archivesEmp=null;
        if(empid!=null){
            archivesEmp= archivesEmpService.selectEmpById(empid);
        }
        Alinkey alinkey=null;
        if(state!=null){
            alinkey=alinkeyService.selectAlinkeyByName(state);
        }


        ClockinginPunch clockinginPunch=new ClockinginPunch();/*打卡表*/
        clockinginPunch.setPunchCard(ts);
        clockinginPunch.setArchivesEmpByArchivesId(archivesEmp);
        clockinginPunch.setAlinkeyByAlinkeyId(alinkey);
        System.out.println(clockinginPunch);
        Integer integer = clockinginPunchService.insertPunch(clockinginPunch);/*新增打卡记录信息*/
        System.out.println(date+"====="+empid+"======="+state);
        myResult.setMsg("打卡成功");
        myResult.setCode(integer);
        return myResult;
    }
}
