package br.edu.usj.ads.pw.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TodoController {

    
    //List<String> list = new ArrayList<>();

    @Autowired
    TodoRepository todoRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        //buscar todos do repositorio e criar uma lista com eles
        List<Todo> list = todoRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todo_list", list);
        return modelAndView;
    }



    @PostMapping(value="/add")
    public String postAdd(@RequestParam String todo) {
        //list.add(todo);
    
        Todo newTodo = new Todo();
        newTodo.setDescription(todo);
        // 1- Cria o objeto,  pega o que vem do form ("todo") e seta na descrição 

        // 2- adicionar no repository e do repository joga no banco de dados
        todoRepository.save(newTodo);
        //apagou o mv, apenas para retornar a raiz após a adição de tarefa
        // colocou String no lugar de mv .. postadd
        //foi chamado, adicionado a atarefa e enviado pra raiz.
        return "redirect:/";
    } 
}    
