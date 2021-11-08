package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.ArchivesEmpMapper;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArchivesEmpService {
    @Autowired
    private ArchivesEmpMapper mapper;

    public List<ArchivesEmp> selectAll(){
        return mapper.selectAll();
    }

    /*根据员工编号查询 selectEmpById*/
    public ArchivesEmp selectEmpById(Integer empId){
        return  mapper.selectEmpById(empId);
    }

}
