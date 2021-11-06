package cn.gson.linyun.model.mapper.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkflowFlowMapper {

    /**
     * 查询所有流程
     * @param name 流程名
     * @return
     */
    List<WorkflowFlow> SelectAll(@Param("name") String name);

    /**
     * 新建流程
     * @param vo
     * @return
     */
    Integer Insert(FlowVo vo);

    /**
     * 删除流程
     * @param id
     * @return
     */
    Integer Delete(Integer id);

    /**
     * 查询单条记录
     * @param id
     * @return
     */
    WorkflowFlow SelectByid(Integer id);

    /**
     * 根据编号修改
     * @param id
     * @return
     */
    Integer Update(@Param("flag") Boolean flag,@Param("id") Integer id);

    /**
     * 修改流程
     * @param flowVo
     * @return
     */
    Integer UpdateFlow(FlowVo flowVo);

}
