package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Admin;
import demo.service.AdminService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("add")
    private String add(Admin admin) {
        adminService.add(admin);
        return "redirect:list";
    }

    @RequestMapping("list")
    private String list() {
        super.session.setAttribute("list", adminService.list());
        return "redirect:list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("admin", adminService.search(id));
        return "redirect:/admin/edit.jsp";
    }

    @RequestMapping("fuzzy")
    private String fuzzy(Admin admin) {
        try {
           session.setAttribute("list", adminService.fuzzy(BeanUtils.describe(admin)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:list.jsp";
    }

    @RequestMapping("modify")
    private String modify(Admin admin) {
        adminService.modify(admin);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        adminService.remove(id);
        return "redirect:/admin/list";
    }


    @RequestMapping("login")
    private String login(Admin admin) {
        admin = adminService.login(admin);
        if (admin == null) {
            request.setAttribute("msg", "invalid username or password.");
            return "admin/login";
        } else {
            session.setAttribute("admin", admin);
            return "redirect:/activity/list.jsp";
        }
    }
}