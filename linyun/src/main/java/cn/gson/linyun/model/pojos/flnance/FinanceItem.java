package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


public class FinanceItem {

    private Integer itemId;//主键
    private String itemName;//项目名
    private String itemExplain;//项目说明
    private Collection<Relationship34> relationship34sByItemId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemExplain() {
        return itemExplain;
    }

    public void setItemExplain(String itemExplain) {
        this.itemExplain = itemExplain;
    }

    @Override
    public String toString() {
        return "FinanceItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemExplain='" + itemExplain + '\'' +
                '}';
    }


    @OneToMany(mappedBy = "financeItemByItemId")
    public Collection<Relationship34> getRelationship34sByItemId() {
        return relationship34sByItemId;
    }

    public void setRelationship34sByItemId(Collection<Relationship34> relationship34sByItemId) {
        this.relationship34sByItemId = relationship34sByItemId;
    }
}
