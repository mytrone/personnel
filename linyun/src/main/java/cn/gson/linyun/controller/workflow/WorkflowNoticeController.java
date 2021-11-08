package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.service.workflow.WorkflowNoticeService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("noti")
public class WorkflowNoticeController {

    @Autowired
    WorkflowNoticeService workflowNoticeService;

    @PostMapping("update")
    /**
     * 已读消息
     */
    public MyResult Update(@RequestParam("id") Integer id,
                              @RequestParam("emp") Integer emp){
        System.out.println(id);
        System.out.println(emp);
        Integer i= workflowNoticeService.UpdateState(emp,id);
        if (i > 0) {
            return MyResult.SUCCESS;
        } else {
            return MyResult.FAILURE("读取失败！");
        }
    }


    /**
     * 根据用编号查询i消息
     * @param id
     * @return
     */
    @PostMapping("selectid")
    public MyResult selectID(@RequestParam("id")Integer id){
        return MyResult.SUCCESS_DATA(workflowNoticeService.SelectByid(id));
    }

}
