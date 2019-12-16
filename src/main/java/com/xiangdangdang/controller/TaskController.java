package com.xiangdangdang.controller;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping("/hottask")
    public List<Task> limit(String limit) {
        if (limit == null || ("").equals(limit.trim()))
            limit = "5";

        int li = Integer.valueOf(limit);
        List<Task> res = taskService.findTaskLimit(li);
        System.out.println(res);
        res.sort(Comparator.comparing(Task::getTitle));
        return res;
    }

    @ResponseBody
    @RequestMapping("/todaypublish")
    public Integer todayPublish() {
        return taskService.findTodayTaskCount();
    }

    @ResponseBody
    @RequestMapping("/todayend")
    public Integer todayEnd() {
        return taskService.findTodayEndCount();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Task> search(String keyword) {
        if (keyword == null) keyword = "";
        List<Task> res = taskService.search(keyword);
        System.out.println(res);
        res.sort((o1, o2) -> {
            if (o1.getEnd_time() != null) {
                return -1;
            }
            if (o1.getEnd_time() == null && o2.getEnd_time() != null){
                return 1;
            }
            return o2.getPublish_time().compareTo(o1.getPublish_time());
        });
        return res;
    }

}
