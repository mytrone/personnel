package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.mapper.workflow.WorkflowNodeMapper;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class WorkflowNodeService {

    @Autowired
    WorkflowNodeMapper workflowNodeMapper;

    /**
     * 根据流程创建节点
     * @return
     */

    public Integer Insert(FlowVo flowVo,Integer[] arr){
        try {
            Integer i= workflowNodeMapper.Insert(flowVo,arr);
            if(i>0){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除节点
     * @return
     */

    public Integer Delect(Integer id){
        try {
            Integer i= workflowNodeMapper.Delete(id);
            if(i>0){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据流程编号查询
     * @param id
     * @return
     */
    public List<WorkflowNode> SelectByFlow(Integer id){
        return workflowNodeMapper.SelectByFlow(id);
    }



}
