package cn.gson.linyun.model.mapper.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IWorkflowPersonnelMapper {

    /**
     * 消息绑定人员
     * @param emp_id
     * @param arr
     * @return
     */
    Integer Insert(@Param("emp_id") Integer[] emp_id,
                   @Param("notice_id")  Integer arr
                   );

    /**
     * 将消息转为已读
     * @param emp
     * @param notice_id
     * @return
     */
    Integer UpdateState(@Param("emp") Integer emp,@Param("note") Integer notice_id);

}
