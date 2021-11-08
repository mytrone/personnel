package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.mapper.workflow.WorkflowApproveMapper;
import cn.gson.linyun.model.mapper.workflow.WorkflowFlowSpMapper;
import cn.gson.linyun.model.pojos.workflow.WorkflowApprove;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
/**
 * 流程实例Service
 */
public class WorkflowApproveService {

    @Autowired
    WorkflowApproveMapper workflowApproveMapper;
    @Autowired
    WorkflowFlowSpMapper flowSpMapper;
    @Autowired
    WorkflowNodeService nodeService;

    /**
     * 根据申请编号 流程 查询
     * @param id
     * @param flow
     * @return
     */
    public WorkflowApprove SelectBYid(Integer id,Integer flow){
        return workflowApproveMapper.SelectBYid(id, flow);
    }


    /**
     * 创建申请实例
     * @param workflowApprove
     * @return
     */
    public  Integer Insert(WorkflowApproveVo workflowApprove){
        try {
            Integer i= workflowApproveMapper.Insert(workflowApprove);
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
     * 查询所有申请
     * @return
     */
    public PageInfo SelectAll(Integer no, Integer size, String name){
        System.out.println("name"+name);
        PageHelper.startPage(no,size);
        List<WorkflowApprove> list=workflowApproveMapper.SelectAll(name);
        PageInfo<WorkflowApprove> info=new PageInfo<>(list);
        return info;
    }

    /**
     * 查询历史审批记录 根据流程实例编号
     * @param id
     * @return
     */
    public WorkflowApprove SelectHistory(Integer id){
        return workflowApproveMapper.SelectHistory(id);
    }


    /**
     * 申请  审批节点第一步
     * @param workflowApproveVo
     * @return
     */
    public  Integer AddApprove(WorkflowApproveVo workflowApproveVo
                                ){
        Timestamp timestamp=new Timestamp(new Date().getTime());
        workflowApproveVo.setApproveTime(timestamp);//流程申请时间
        //找到此流程节点
        List<WorkflowNode> nodes=nodeService.SelectByFlow(workflowApproveVo.getApprove_flow());
        System.out.println("nodes__________"+nodes.toString());
        workflowApproveVo.setWorkflowNode(nodes.get(0).getNodeId());

        try {
            Integer i1=Insert(workflowApproveVo);//创建流程实例
            WorkflowFlowSpVo flowSpVo=new WorkflowFlowSpVo();
            flowSpVo.setWorkflowApprove(workflowApproveVo.getApproveId());//流程编号
            flowSpVo.setArchivesEmpsp(workflowApproveVo.getSpPeople());//审批人
            flowSpVo.setWorkflowNode(nodes.get(0).getNodeId());
            Integer i2=flowSpMapper.Insert(flowSpVo);//创建节点
            if (i1>0 && i2>0){
                return 1;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    /**
     * 修改状态
     * @param id
     * @param state
     * @return
     */
    public Integer Update(Integer id,Integer state){
        try {
            Integer i= workflowApproveMapper.Update(id, state);
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
     * 修改节点
     * @param id
     * @param node
     * @return
     */
    public Integer UpdateNode(Integer id,Integer node){
        try {
            Integer i= workflowApproveMapper.UpdateNode(id, node);
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
}
