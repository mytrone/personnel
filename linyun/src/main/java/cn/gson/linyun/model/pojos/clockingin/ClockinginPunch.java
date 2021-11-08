package cn.gson.linyun.model.pojos.clockingin;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class ClockinginPunch {/*打卡表*/
    private Integer punchId;/*打卡编号*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp punchCard;/*打卡的时间*/
    private Alinkey alinkeyByAlinkeyId;/*状态*/
    private ArchivesEmp archivesEmpByArchivesId;/*员工编号外键*/

    public ClockinginPunch(Integer punchId, Timestamp punchCard) {
        this.punchId = punchId;
        this.punchCard = punchCard;
    }

    public ClockinginPunch() {

    }

    public ArchivesEmp getArchivesEmpByArchivesId() {
        return archivesEmpByArchivesId;
    }

    public void setArchivesEmpByArchivesId(ArchivesEmp archivesEmpByArchivesId) {
        this.archivesEmpByArchivesId = archivesEmpByArchivesId;
    }

    public Integer getPunchId() {
        return punchId;
    }

    public void setPunchId(Integer punchId) {
        this.punchId = punchId;
    }

    public Timestamp getPunchCard() {
        return punchCard;
    }

    public void setPunchCard(Timestamp punchCard) {
        this.punchCard = punchCard;
    }

    @Override
    public String toString() {
        return "ClockinginPunch{" +
                "punchId=" + punchId +
                ", punchCard=" + punchCard +
                '}';
    }

    public Alinkey getAlinkeyByAlinkeyId() {
        return alinkeyByAlinkeyId;
    }

    public void setAlinkeyByAlinkeyId(Alinkey alinkeyByAlinkeyId) {
        this.alinkeyByAlinkeyId = alinkeyByAlinkeyId;
    }
}
