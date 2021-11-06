package cn.gson.linyun.model.pojos.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 类别自连表
 */
public class Alinkey {
    private int alinkeyId;//编号
    private String alinkeyName;//名称
    private Integer alinkeyFather;//上级编号


}
