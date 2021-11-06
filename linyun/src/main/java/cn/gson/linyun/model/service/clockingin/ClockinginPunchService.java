package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.model.mapper.clockingin.IClockinginPunchMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginPunch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClockinginPunchService {

    @Autowired
    IClockinginPunchMapper iClockinginPunchMapper;

    public Integer insertPunch(ClockinginPunch clockinginPunch ){
        return iClockinginPunchMapper.insertPunch(clockinginPunch);
    }

    /*查看打卡为什么状态 是否已打完卡 selectPunchByEmpId*/
    public List<ClockinginPunch> selectPunchByEmpId(Integer empId){
        return iClockinginPunchMapper.selectPunchByEmpId(empId);
    }

}
