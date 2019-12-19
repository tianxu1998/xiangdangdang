package com.xiangdangdang.controller;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.service.TaskService;
import com.xiangdangdang.util.Result;
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

    @ResponseBody
    @RequestMapping("/findtaskbytagid")
    public List<Task> findTaskByTagId(Long tag_id) {
        List<Task> res = taskService.findByTag(tag_id);
        res.sort(Comparator.comparingInt(Task::getRead_count).reversed());
        return res;
    }

    @RequestMapping("/findbyid")
    @ResponseBody
    public Task findById(Long task_id){
        Task task = taskService.findById(task_id);
        return task;
    }


    @RequestMapping("/readcountplus")
    @ResponseBody
    public Result readCountPlus(Long task_id, Integer read_count) {
        try {
            taskService.readCountPlus(task_id, read_count);
        } catch (Exception e) {
            return new Result(0, "失败");
        }
        return new Result(1, "成功");
    }

    @ResponseBody
    @RequestMapping("/publish")
    public Result publish(String title, String context, Long publish_uid,String price, Long tag_id) {
        try {
            taskService.publish(title, context,publish_uid,Double.valueOf(price),tag_id);
        } catch (Exception e) {
            return new Result(0, "发布失败");
        }
        return new Result(1, "发布成功");
    }

    @ResponseBody
    @RequestMapping("/accept")
    public Result accept(Long accept_uid, Long task_id) {
        try {
            taskService.accept(accept_uid, task_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(0,"领取失败");
        }
        return new Result(1, "领取成功");
    }

    @ResponseBody
    @RequestMapping("/end")
    public Result end(Long task_id) {
        try {
            taskService.end(task_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(0,"失败");
        }
        return new Result(1, "成功");
    }

}
