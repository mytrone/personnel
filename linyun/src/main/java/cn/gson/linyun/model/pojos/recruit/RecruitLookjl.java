package cn.gson.linyun.model.pojos.recruit;

import javax.persistence.*;
import java.util.Objects;

public class RecruitLookjl {
    private Integer lookjlId;
    private String lookjlName;
    private String lookjlStudy;

    @Override
    public String toString() {
        return "RecruitLookjl{" +
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruitLookjl that = (RecruitLookjl) o;
        return Objects.equals(lookjlId, that.lookjlId) && Objects.equals(lookjlName, that.lookjlName) && Objects.equals(lookjlStudy, that.lookjlStudy);
    }

    public int hashCode() {
        return Objects.hash(lookjlId, lookjlName, lookjlStudy);
    }
}
