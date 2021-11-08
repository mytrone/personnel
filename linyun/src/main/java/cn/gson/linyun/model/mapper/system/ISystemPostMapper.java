package cn.gson.linyun.model.mapper.system;

import cn.gson.linyun.model.pojos.system.SystemPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISystemPostMapper {
    //查看职位
    List<SystemPost> selPost();
    //新增职位
    void addPost(SystemPost systemPost);
    //修改职位
    void changePost(SystemPost post);
    //删除职位
    void delPost(int postId);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    SystemPost SelectByid(Integer id);
}
