package cn.gson.linyun.model.service.workflow;


import cn.gson.linyun.model.mapper.workflow.IAlinkeyMapper;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * 类型Service
 */
public class AlinkeyService {

    @Autowired
    IAlinkeyMapper alinkeyMapper;

    /**
     * 根据编号查询类别
     * @return
     */
    public List<Alinkey> SelectByid(Integer id){
        return alinkeyMapper.SelectByid(id);
    }

    /*根据名称查询 selectAlinkeyByName*/
    public Alinkey selectAlinkeyByName(String name){
        return alinkeyMapper.selectAlinkeyByName(name);
    }
}
