package com.example.demo.controller;


import com.example.demo.annotation.Log;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Log
    @RequestMapping("test/{str}")
    public String test(@PathVariable("str")String str){
        System.out.println("test"+str);
        return str;
    }

    /**
     * @author xiaofu
     * @description 启动流程
     * @date 2020/8/26 17:36
     */
    @RequestMapping(value = "startLeaveProcess")
    @ResponseBody
    public String startLeaveProcess(String staffId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaveTask", staffId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Leave", map);
        StringBuilder sb = new StringBuilder();
        sb.append("创建请假流程 processId：" + processInstance.getId());
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(staffId).orderByTaskCreateTime().desc().list();
        for (org.flowable.task.api.Task task : tasks) {
            sb.append("任务taskId:" + task.getId());
        }
        return sb.toString();
    }



}
