package cn.gson.linyun.controller.recruit;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.service.recruit.ArchivesEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/archivesEmp")
public class ArchivesEmpController {
    @Autowired
    ArchivesEmpService service;

    @RequestMapping("/selectAll")
    public List<ArchivesEmp> selectAll(){
        System.out.println("我进来了"+service.selectAll());
        return service.selectAll();
    }

}
