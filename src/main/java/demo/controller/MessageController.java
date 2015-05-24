package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Message;
import demo.service.MessageService;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Controller
@RequestMapping("message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("add")
    private String add(Message message) {
        message.setTime(new Date());
        messageService.add(message);
        return "redirect:/index.jsp";
    }

    @RequestMapping("list")
    private String list() {
        super.session.setAttribute("list", messageService.list());
        return "redirect:list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("message", messageService.search(id));
        return "redirect:/message/edit.jsp";
    }

    @RequestMapping("fuzzy")
    private String fuzzy(Message message) {
        try {
           session.setAttribute("list", messageService.fuzzy(BeanUtils.describe(message)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:list.jsp";
    }

    @RequestMapping("modify")
    private String modify(Message message) {
        messageService.modify(message);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        messageService.remove(id);
        return "redirect:/message/list";
    }
}