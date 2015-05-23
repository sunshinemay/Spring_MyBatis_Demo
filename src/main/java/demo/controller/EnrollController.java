package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Enroll;
import demo.service.EnrollService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("enroll")
public class EnrollController extends BaseController {

    @Autowired
    private EnrollService enrollService;

    @RequestMapping("add")
    private String add(Enroll enroll) {
        System.out.println(enroll);
        enrollService.add(enroll);
        return "redirect:/index.jsp";
    }

    @RequestMapping("list")
    private String list() {
        super.session.setAttribute("list", enrollService.list());
        return "redirect:list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("enroll", enrollService.search(id));
        return "redirect:/enroll/edit.jsp";
    }

    @RequestMapping("fuzzy")
    private String fuzzy(Enroll enroll) {
        try {
           session.setAttribute("list", enrollService.fuzzy(BeanUtils.describe(enroll)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:list.jsp";
    }

    @RequestMapping("modify")
    private String modify(Enroll enroll) {
        enrollService.modify(enroll);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        enrollService.remove(id);
        return "redirect:/enroll/list";
    }
}