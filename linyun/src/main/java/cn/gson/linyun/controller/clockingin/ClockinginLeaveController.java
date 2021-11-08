package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.controller.clockingin.vo.OvertimeVO;
import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.service.clockingin.ClockinginLeaveService;
import cn.gson.linyun.model.service.workflow.AlinkeyService;
import cn.gson.linyun.model.utils.MyResult;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@RequestMapping("/leave")
public class ClockinginLeaveController {

    @Autowired
    ClockinginLeaveService leaveService;

    @Autowired
    AlinkeyService alinkeyService;

    @GetMapping
    public MyResult selectAllByEmpIdLeave(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "empId",defaultValue = "1") Integer empId,
                                          @RequestParam(value = "datastart",defaultValue = "") String datastart,
                                          @RequestParam(value = "datafinish",defaultValue = "") String datafinish){
        PageInfo<ClockinginLeave> clockinginLeavePageInfo =
                leaveService.selectAllByEmpId(pageNo, pageSize, empId,datastart,datafinish);
        return MyResult.SUCCESS_Object(clockinginLeavePageInfo);
    }

    @GetMapping("selectAlinkey")
    public List<Alinkey> selectAlinkey(@RequestParam("alinkId") Integer alinkId){
        return alinkeyService.selectByAlinkeyId(alinkId);
    }

    /*请假申请新增*/
    @PostMapping("insertLeave")
    public Integer insertLeave(@RequestBody OvertimeVO vo){
        Integer integer = leaveService.insertLeave(vo);
        return integer;
    }

}
