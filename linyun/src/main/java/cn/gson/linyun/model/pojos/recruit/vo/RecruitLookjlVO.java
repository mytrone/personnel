package cn.gson.linyun.model.pojos.recruit.vo;

public class RecruitLookjlVO {
    private Integer lookjlId;
    private String lookjlName;
    private String lookjlStudy;

    @Override
    public String toString() {
        return "RecruitLookjlVO{" +
                "lookjlId=" + lookjlId +
                ", lookjlName='" + lookjlName + '\'' +
                ", lookjlStudy='" + lookjlStudy + '\'' +
                '}';
    }

    public Integer getLookjlId() {
        return lookjlId;
    }

    public void setLookjlId(Integer lookjlId) {
        this.lookjlId = lookjlId;
    }

    public String getLookjlName() {
        return lookjlName;
    }

    public void setLookjlName(String lookjlName) {
        this.lookjlName = lookjlName;
    }

    public String getLookjlStudy() {
        return lookjlStudy;
    }

    public void setLookjlStudy(String lookjlStudy) {
        this.lookjlStudy = lookjlStudy;
    }
}
