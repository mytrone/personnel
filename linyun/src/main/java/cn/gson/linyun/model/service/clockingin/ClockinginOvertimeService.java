package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.model.mapper.clockingin.IClockinginOvertimeMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockinginOvertimeService {
    @Autowired
    IClockinginOvertimeMapper iClockinginOvertimeMapper;

    /*查询当天是否有加班申请 selectOvertimeByEmpId*/
    public List<ClockinginOvertime> selectOvertimeByEmpId(Integer empId){
        return iClockinginOvertimeMapper.selectOvertimeByEmpId(empId);
    }

}
