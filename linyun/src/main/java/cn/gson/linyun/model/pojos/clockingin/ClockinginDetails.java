package cn.gson.linyun.model.pojos.clockingin;


import java.math.BigDecimal;

public class ClockinginDetails {

  private Integer detailsId;
  private ClockinginReimburse reimburseId;
  private String detailsName;
  private BigDecimal detailsMoney;
  private String detailsReceipt;

  @Override
  public String toString() {
    return "ClockinginDetails{" +
            "detailsId=" + detailsId +
            ", detailsName='" + detailsName + '\'' +
            ", detailsMoney=" + detailsMoney +
            ", detailsReceipt='" + detailsReceipt + '\'' +
            '}';
  }

  public Integer getDetailsId() {
    return detailsId;
  }

  public void setDetailsId(Integer detailsId) {
    this.detailsId = detailsId;
  }

  public ClockinginReimburse getReimburseId() {
    return reimburseId;
  }

  public void setReimburseId(ClockinginReimburse reimburseId) {
    this.reimburseId = reimburseId;
  }

  public String getDetailsName() {
    return detailsName;
  }

  public void setDetailsName(String detailsName) {
    this.detailsName = detailsName;
  }

  public BigDecimal getDetailsMoney() {
    return detailsMoney;
  }

  public void setDetailsMoney(BigDecimal detailsMoney) {
    this.detailsMoney = detailsMoney;
  }

  public String getDetailsReceipt() {
    return detailsReceipt;
  }

  public void setDetailsReceipt(String detailsReceipt) {
    this.detailsReceipt = detailsReceipt;
  }
}
