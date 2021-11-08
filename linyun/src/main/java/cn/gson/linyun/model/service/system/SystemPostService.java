package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemPostMapper;
import cn.gson.linyun.model.pojos.system.SystemPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemPostService {
    @Autowired
    ISystemPostMapper iSystemPostMapper;
    //查看职位
    public List<SystemPost> selPost(){
        return iSystemPostMapper.selPost();
    }
    //新增职位
    public void addPost(SystemPost systemPost){
        iSystemPostMapper.addPost(systemPost);
    }
    //修改职位
    public void changePost(SystemPost post){
        iSystemPostMapper.changePost(post);
    }
    //删除职位
    public void delPost(int postId){
        iSystemPostMapper.delPost(postId);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    public SystemPost SelectByid(Integer id){
        return iSystemPostMapper.SelectByid(id);
    }
}
