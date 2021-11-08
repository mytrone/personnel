package cn.gson.linyun.controller.clockingin.vo;

import java.math.BigDecimal;
import java.util.List;

public class ReimburseVo {
    private Integer empId;
    private Integer deptId;
    private Integer flowId;
    private Integer postId;
    private BigDecimal zje;
    private List<DetailsVo> xq;

    @Override
    public String toString() {
        return "ReimburseVo{" +
                "empId=" + empId +
                ", deptId=" + deptId +
//                ", flowId=" + flowId +
                ", postId=" + postId +
                ", zje=" + zje +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public BigDecimal getZje() {
        return zje;
    }

    public void setZje(BigDecimal zje) {
        this.zje = zje;
    }

    public List<DetailsVo> getXq() {
        return xq;
    }

    public void setXq(List<DetailsVo> xq) {
        this.xq = xq;
    }
}
