package cn.gson.linyun.model.service.system;

import cn.gson.linyun.model.mapper.system.ISystemStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SystemStaffService {
    @Autowired
    ISystemStaffMapper iSystemStaffMapper;
}
