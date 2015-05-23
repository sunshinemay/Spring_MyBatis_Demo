package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Activity;
import demo.service.ActivityService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("activity")
public class ActivityController extends BaseController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("add")
    private String add(Activity activity) {
        activityService.add(activity);
        return "redirect:list";
    }

    @RequestMapping("list")
    private String list() {
        super.session.setAttribute("list", activityService.list());
        return "redirect:list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("activity", activityService.search(id));
        return "redirect:/activity/edit.jsp";
    }

    @RequestMapping("fuzzy")
    private String fuzzy(Activity activity) {
        try {
           session.setAttribute("list", activityService.fuzzy(BeanUtils.describe(activity)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:list.jsp";
    }

    @RequestMapping("modify")
    private String modify(Activity activity) {
        activityService.modify(activity);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        activityService.remove(id);
        return "redirect:/activity/list";
    }
}