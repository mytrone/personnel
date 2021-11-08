package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.mapper.workflow.AlinkeyMapper;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
/**
 * 类型Service
 */
@Transactional(rollbackFor = Exception.class)
public class AlinkeyService {

    @Autowired
    AlinkeyMapper alinkeyMapper;

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

    /*根据类型查询子类 selectByAlinkeyId alinkeyId*/
    public List<Alinkey> selectByAlinkeyId(Integer alinkeyId){
        return alinkeyMapper.selectByAlinkeyId(alinkeyId);
    }
}
