package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArchivesEmpMapper {
    List<ArchivesEmp> selectAll();

    /*根据员工编号查询 selectEmpById*/
    ArchivesEmp selectEmpById(Integer empId);
}

