package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.model.mapper.clockingin.IClockinginBusinessMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockinginBusinesService {
    @Autowired
    IClockinginBusinessMapper businessMapper;

    //    查询未申请的出差报销单和为通过的 selectAllByEmpId
    public List<ClockinginBusiness> selectAllByEmpId(Integer empId){
        return businessMapper.selectAllByEmpId(empId);
    }
}
