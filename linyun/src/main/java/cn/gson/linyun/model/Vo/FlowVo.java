package cn.gson.linyun.model.Vo;

import cn.gson.linyun.model.pojos.workflow.Alinkey;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class FlowVo {
    private Integer id;
    private String name;
    private Integer type;
    private Integer position;
    private List<Alinkey> jieduan;
    private String web;
    private Boolean state;
    private Timestamp timestamp;


}
