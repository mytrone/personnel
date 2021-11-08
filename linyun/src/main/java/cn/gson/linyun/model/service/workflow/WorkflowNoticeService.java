package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.Vo.WorkflowNoticeVo;
import cn.gson.linyun.model.mapper.workflow.IWorkflowNoticeMapper;
import cn.gson.linyun.model.mapper.workflow.IWorkflowPersonnelMapper;
import cn.gson.linyun.model.pojos.workflow.WorkflowNotice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkflowNoticeService {

    @Autowired
    IWorkflowNoticeMapper workflowNoticeMapper;
    @Autowired
    IWorkflowPersonnelMapper workflowPersonnelMapper;

    /**
     * 创建消息
     * @param vo
     * @param arr
     * @return
     */
    public Integer Insert(WorkflowNoticeVo vo,
                          Integer[] arr){
        try {
            Integer i= workflowNoticeMapper.Insert(vo);
            workflowPersonnelMapper.Insert(arr,vo.getNoticeId());
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
     * 已读消息

     * @return
     */
    public Integer UpdateState(Integer emp, Integer notice_id){
        try {
            Integer i= workflowPersonnelMapper.UpdateState(emp,notice_id);

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
     * 根据用户编号查询未读消息
     * @param id
     * @return
     */
    public List<WorkflowNotice> SelectByid(Integer id){
        return workflowNoticeMapper.SelectByid(id);
    }

}
