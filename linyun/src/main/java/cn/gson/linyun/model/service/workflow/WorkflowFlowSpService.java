package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.mapper.workflow.WorkflowFlowSpMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Service
@Transactional(rollbackOn = Exception.class)
/**
 * 流程审批Service
 */
public class WorkflowFlowSpService {

    @Autowired
    WorkflowFlowSpMapper flowSpMapper;

    /**
     * 创建流程审批
     * @param WorkflowFlowSpVo
     * @return
     */
    public  Integer Insert(WorkflowFlowSpVo WorkflowFlowSpVo){
        try {
            Integer i= flowSpMapper.Insert(WorkflowFlowSpVo);
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
     * 修改流程审批
     * @param
     * @param state
     * @return
     */
    public  Integer Update(Integer id, Boolean state, String row, Timestamp timestamp){
        try {
            Integer i= flowSpMapper.Update(id, state, row,timestamp);
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
