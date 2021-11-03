package br.edu.usj.ads.pw.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TodoController {

    List<String> list = new ArrayList<>();


    @PostMapping(value="/add")
    public ModelAndView postAdd(@RequestParam String todo) {
        list.add(todo);
        System.out.println(todo);
        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("todo_list", list);
        return modelAndview;    }
    
}
