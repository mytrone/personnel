package cn.gson.linyun.model.mapper.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArchivesEmpMapper {
    List<ArchivesEmp> selectAll();

    /**
     * 职位层级查询员工
     * @param id
     * @return
     */
    List<ArchivesEmp> SelectByPostGrade(Integer id);

    /**
     * 根据职位查询
     * @param id
     * @return
     */
    ArchivesEmp SelectByPostPo(Integer id);

}

