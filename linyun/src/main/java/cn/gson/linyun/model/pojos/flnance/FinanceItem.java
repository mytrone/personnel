package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "finance_item", schema = "person", catalog = "")
public class FinanceItem {

    private Integer itemId;
    private String itemName;
    private String itemExplain;



    @Id
    @Column(name = "Item_id")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "Item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_explain")
    public String getItemExplain() {
        return itemExplain;
    }

    public void setItemExplain(String itemExplain) {
        this.itemExplain = itemExplain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceItem that = (FinanceItem) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(itemName, that.itemName) && Objects.equals(itemExplain, that.itemExplain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemExplain);
    }
}
