package cn.gson.linyun.model.Vo;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/***
 * 消息
 */
@Data
public class WorkflowNoticeVo {
    private int noticeId;//编号
    private Timestamp noticeTime;//时间
    private String noticeNews;//内容
    private Integer archivesEmp;//创建人
}
