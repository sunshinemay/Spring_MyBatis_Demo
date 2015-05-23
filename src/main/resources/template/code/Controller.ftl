package ${package}.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ${package}.model.${model};
import ${package}.service.${model}Service;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("${model?lower_case}")
public class ${model}Controller extends BaseController {

    @Autowired
    private ${model}Service ${model?lower_case}Service;

    @RequestMapping("add")
    private String add(${model} ${model?lower_case}) {
        ${model?lower_case}Service.add(${model?lower_case});
        return "redirect:list";
    }

    @RequestMapping("list")
    private String list() {
        super.session.setAttribute("list", ${model?lower_case}Service.list());
        return "redirect:list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") ${PK} id) {
        super.session.setAttribute("${model?lower_case}", ${model?lower_case}Service.search(id));
        return "redirect:/${model?lower_case}/edit.jsp";
    }

    @RequestMapping("fuzzy")
    private String fuzzy(${model} ${model?lower_case}) {
        try {
           session.setAttribute("list", ${model?lower_case}Service.fuzzy(BeanUtils.describe(${model?lower_case})));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:list.jsp";
    }

    @RequestMapping("modify")
    private String modify(${model} ${model?lower_case}) {
        ${model?lower_case}Service.modify(${model?lower_case});
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") ${PK} id) {
        ${model?lower_case}Service.remove(id);
        return "redirect:/${model?lower_case}/list";
    }
}