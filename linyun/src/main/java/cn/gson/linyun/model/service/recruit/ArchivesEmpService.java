package cn.gson.linyun.model.service.recruit;

import cn.gson.linyun.model.mapper.recruit.ArchivesEmpMapper;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivesEmpService {
    @Autowired
    private ArchivesEmpMapper mapper;

    public List<ArchivesEmp> selectAll(){
        return mapper.selectAll();
    }

}
