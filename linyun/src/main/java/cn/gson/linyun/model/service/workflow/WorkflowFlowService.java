package cn.gson.linyun.model.service.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.mapper.workflow.IWorkflowFlowMapper;

import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
/**
 * 流程Service
 */
public class WorkflowFlowService {

    @Autowired
    IWorkflowFlowMapper workflowFlowMapper;
    @Autowired
    WorkflowNodeService workflowNodeService;

    /**
     * 查询所有流程
     * @param name 流程名
     * @return
     */
    public PageInfo SelectAll(Integer no,Integer size,String name){
        PageHelper.startPage(no,size);
        List<WorkflowFlow> list=workflowFlowMapper.SelectAll(name);
        PageInfo<WorkflowFlow> info=new PageInfo<>(list);
        return info;
    }


    /**
     * 新建流程
     * @param vo
     * @return
     */
    public Integer Insert(FlowVo vo){
        try {
            Integer i= workflowFlowMapper.Insert(vo);
            if(i>0){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 删除流程
     * @param vo
     * @return
     */
    public Integer Delete(Integer vo){
        try {
            Integer i= workflowFlowMapper.Delete(vo);;
            if(i>0){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    public WorkflowFlow SelectByid(Integer id){
        return workflowFlowMapper.SelectByid(id);
    }


    /**
     * url查询单条
     * @param url
     * @return
     */
    public List<WorkflowFlow> SelectByUrl(String url){
        return workflowFlowMapper.SelectByUrl(url);
    }

    /**
     * 修改状态
     * @param id
     * @return
     */
    public Integer Update(Boolean flag,Integer id){
        return workflowFlowMapper.Update(flag,id);
    }
    /**
     * 修改流程
     * @param vo
     * @return
     */
    public Integer UpdateFlow(FlowVo vo){
        return workflowFlowMapper.UpdateFlow(vo);
    }


    /**
     * 根据url和职位查询流程
     * @param id
     * @return
     */
    public  List<WorkflowFlow> SelectByUrlID(String URL,Integer id){
        return workflowFlowMapper.SelectByUrlID(URL,id);
    }


    /**
     * 停用流程
     * @param id
     * @return
     */
    public Integer UpdateZt(Integer id){
        return workflowFlowMapper.UpdateZt(id);
    }
    }
