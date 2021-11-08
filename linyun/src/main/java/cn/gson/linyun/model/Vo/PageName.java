package cn.gson.linyun.model.Vo;


import lombok.Data;

@Data
public class PageName {

    private Integer no;
    private Integer size;
    private String name;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
