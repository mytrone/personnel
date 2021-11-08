package cn.gson.linyun.model.service.flnance;

import cn.gson.linyun.model.mapper.flnance.FinanceCheckMpper;
import cn.gson.linyun.model.mapper.flnance.FinanceChecksonMpper;
import cn.gson.linyun.model.pojos.flnance.FinanceCheck;
import cn.gson.linyun.model.pojos.flnance.FinanceCheckson;
import cn.gson.linyun.model.pojos.flnance.FinanceItem;
import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.utils.MyUtil;
import com.alibaba.fastjson.JSON;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FinanceCheckService {
    @Autowired
    FinanceCheckMpper financeCheckMpper;
    @Autowired
    FinanceChecksonMpper financeChecksonMpper;
    public List<ArchivesEmp> allEmp(){//查询员工
        return financeCheckMpper.allEmp();
    }
    public void  addEmp(Map<String,Object> datas){//批量新增
        //新增考核表

        System.out.println(datas);
        List<Integer>empId=(List<Integer>)datas.get("archivesEmpList");
        String str= JSON.toJSONString(datas.get("financeCheckson"));
        List<FinanceCheckson> list=JSON.parseArray(str,FinanceCheckson.class);



        String checkPy=(String) datas.get("checkRemark") ;//获取值
        String checkMz=(String)datas.get("checkTemplate") ;



        int sun=0;
        int kw=0;
        for (Integer k: empId) {//按人员来新增主表数据、前台选中多少人循环多少次
            kw+=1;

            FinanceCheck rmp=new FinanceCheck();
            String number=  MyUtil.genrateNo("KH");//随机生成模板编号


            if(kw<=empId.size()){



              for (FinanceCheckson souy:list) {
                   FinanceCheckson bmp=new FinanceCheckson();
                    bmp.setChecksonName(souy.getChecksonName());
                    bmp.setChecksonPoints(souy.getChecksonPoints());
                    bmp.setChecksonScore(souy.getChecksonScore());
                    bmp.setChecksonExplain(souy.getChecksonExplain());
                    bmp.setCheckSerial(number);
                    sun+=souy.getChecksonPoints();
                   financeChecksonMpper.addCheckson(bmp);



               }
                rmp.setCheckPoints(sun);
                continue;
            }
            rmp.setEmpId(k);
            rmp.setCheckRemark(checkPy);
            rmp.setCheckTemplate(checkMz);
            rmp.setCheckSerial(number);

            financeCheckMpper.addEmp(rmp);
            continue;


        }

    }
    //评分查询
    public List<ArchivesEmp>allCheckson(FinanceCheck financeCheck){
        return financeCheckMpper.allCheckson(financeCheck);
    }

}
