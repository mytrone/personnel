package cn.gson.linyun.controller.flnance;

import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.service.flnance.FinanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceItemController {
    @Autowired
    FinanceItemService financeItemService;
    @RequestMapping("/addFinance")//新增项目表
    public String allFinance(@RequestBody FinanceItem financeItem){
        try {
            financeItemService.allFinance(financeItem);
            return "ok";//新增成功
        } catch (Exception e) {

            return "fail";
        }



    }
    @RequestMapping("/allFinance")
    public List<FinanceItem> sllFinance(@RequestBody FinanceItem financeItem){//查询项目表
          return financeItemService.sllFinance(financeItem);
    }
    @RequestMapping("/deFinances")//删除路径
    public String deFinance(@RequestBody FinanceItem financeItem){
        try {
            financeItemService.deFinance(financeItem);
                return "ok";//删除成功
            } catch (Exception e) {

                return "fail";//失败
            }
    }
    @RequestMapping("/allAlinkey")//查询考核类别表
    public List<Alinkey>allAlinkey(){
        return financeItemService.allAlinkey();
    }

}
