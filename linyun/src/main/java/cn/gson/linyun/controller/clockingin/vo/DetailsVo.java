package cn.gson.linyun.controller.clockingin.vo;

import java.math.BigDecimal;

public class DetailsVo {
    private String name;
    private BigDecimal je;

    @Override
    public String toString() {
        return "DetailsVo{" +
                "name='" + name + '\'' +
                ", je=" + je +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }
}
