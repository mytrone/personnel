package cn.gson.linyun.model.service.clockingin;

import cn.gson.linyun.model.mapper.clockingin.IClockinginDetailsMapper;
import cn.gson.linyun.model.pojos.clockingin.ClockinginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockinginDetailsService {
    @Autowired
    IClockinginDetailsMapper detailsMapper;

    //新增报销详情 insertDetails
    public Integer insertDetails(ClockinginDetails details){
        return detailsMapper.insertDetails(details);
    }
}
