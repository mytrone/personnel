package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import cn.gson.linyun.model.pojos.clockingin.ClockinginPunch;
import cn.gson.linyun.model.service.clockingin.ClockinginOvertimeService;
import cn.gson.linyun.model.service.clockingin.ClockinginPunchService;
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

    @PostMapping("addPunch")
    public Integer addPunch(String date,Integer empid,String state) throws ParseException {
        //注意format的格式要与日期String的格式相匹配
        Timestamp ts = Timestamp.valueOf(date);
        System.out.println(ts);
        ClockinginPunch clockinginPunch=new ClockinginPunch();/*打卡表*/
        clockinginPunch.setPunchCard(ts);
        System.out.println(clockinginPunch);
        Integer integer = clockinginPunchService.insertPunch(clockinginPunch);/*新增打卡记录信息*/
        System.out.println(date+"====="+empid+"======="+state);
        return integer;
    }
}
