package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * 消息通知
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowNotice {
    private int noticeId;//编号
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp noticeTime;//时间
    private String noticeNews;//内容
    private ArchivesEmp archivesEmp;//创建人

}
