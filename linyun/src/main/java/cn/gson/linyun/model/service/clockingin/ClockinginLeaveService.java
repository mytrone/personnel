package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.model.mapper.clockingin.IClockinginLeaveMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClockinginLeaveService {
    @Autowired
    IClockinginLeaveMapper leaveMapper;

    public PageInfo<ClockinginLeave> selectAllByEmpId(Integer pageNo,Integer pageSize,Integer empId){
        PageHelper.startPage(pageNo,pageSize);
        List<ClockinginLeave> clockinginLeaves = leaveMapper.selectAllByEmpId(empId);
        PageInfo<ClockinginLeave> of = PageInfo.of(clockinginLeaves);
        return of;
    }
}
