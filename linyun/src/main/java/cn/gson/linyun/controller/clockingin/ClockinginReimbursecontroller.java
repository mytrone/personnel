package cn.gson.linyun.controller.clockingin;

import cn.gson.linyun.controller.clockingin.vo.ReimburseVo;
import cn.gson.linyun.model.pojos.clockingin.ClockinginBusiness;
import cn.gson.linyun.model.pojos.clockingin.ClockinginReimburse;
import cn.gson.linyun.model.service.clockingin.ClockinginBusinesService;
import cn.gson.linyun.model.service.clockingin.ClockinginReimburseService;
import cn.gson.linyun.model.utils.MyResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reimburse")
public class ClockinginReimbursecontroller {
    @Autowired
    ClockinginReimburseService reimburseService;

    @Autowired
    ClockinginBusinesService businesService;

    @GetMapping
    public MyResult selectAll(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                              @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                              @RequestParam(value = "empId",defaultValue = "")Integer empId){
        PageInfo<ClockinginReimburse> clockinginReimbursePageInfo = reimburseService.selectRim(pageNo, pageSize);
        return MyResult.SUCCESS_Object(clockinginReimbursePageInfo);
    }

    /*新增报销申请*/
    @PostMapping("insertRei")
    public void reimburse(@RequestBody ReimburseVo vo){
        System.out.println(vo);
        System.out.println(vo.getXq());
        reimburseService.insertReimburseBusiness(vo);
    }

    /*报销申请 查询出差单*/
    @GetMapping("selectByReId")
    public List<ClockinginBusiness> selectByReId(Integer empId){
        System.out.println(empId);
        List<ClockinginBusiness> clockinginBusinesses =
                businesService.selectAllByEmpId(empId);
        return clockinginBusinesses;
    }

}
