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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<Alinkey> getJieduan() {
        return jieduan;
    }

    public void setJieduan(List<Alinkey> jieduan) {
        this.jieduan = jieduan;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
