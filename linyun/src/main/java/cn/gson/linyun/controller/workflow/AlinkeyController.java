package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.service.workflow.AlinkeyService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("type")
public class AlinkeyController {

    @Autowired
    AlinkeyService alinkeyService;

    @PostMapping("select")
    /**
     * 根据编号查询类别
     */
    public MyResult result(@RequestParam(value = "id") Integer id){
        return MyResult.SUCCESS_DATA(alinkeyService.SelectByid(id));
    }

}
