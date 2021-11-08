package cn.gson.linyun.model.mapper.workflow;

import cn.gson.linyun.model.Vo.WorkflowNoticeVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import cn.gson.linyun.model.pojos.workflow.WorkflowNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
/**
 * 消息
 */
public interface IWorkflowNoticeMapper {

    /**
     * 创建消息
     * @return
     */
    Integer Insert(WorkflowNoticeVo vo);

    /**
     * 根据用户编号读取消息
     * @return
     */
    List<WorkflowNotice> SelectByid(Integer id);

}
