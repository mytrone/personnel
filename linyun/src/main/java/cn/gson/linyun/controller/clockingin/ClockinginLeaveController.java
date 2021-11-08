package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.service.clockingin.ClockinginLeaveService;
import cn.gson.linyun.model.utils.MyResult;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
@RequestMapping("/leave")
public class ClockinginLeaveController {

    @Autowired
    ClockinginLeaveService leaveService;

    @GetMapping
    public MyResult selectAllByEmpIdLeave(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "empId",defaultValue = "1") Integer empId){
        PageInfo<ClockinginLeave> clockinginLeavePageInfo =
                leaveService.selectAllByEmpId(pageNo, pageSize, empId);
        return MyResult.SUCCESS_Object(clockinginLeavePageInfo);
    }

}
