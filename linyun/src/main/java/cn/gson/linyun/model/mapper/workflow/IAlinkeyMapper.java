package cn.gson.linyun.model.mapper.workflow;

import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAlinkeyMapper {

    /**
     * 根据编号查询类别
     * @return
     */
    List<Alinkey> SelectByid(Integer id);

    /*根据名称查询 selectAlinkeyByName*/
    Alinkey selectAlinkeyByName(String name);
}
