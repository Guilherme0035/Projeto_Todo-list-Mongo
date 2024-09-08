package desafio_to_do_list.resource;

import desafio_to_do_list.entity.Todo;
import desafio_to_do_list.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoResource {

    @Autowired
    public TodoService todoService;

    @PostMapping
    public List <Todo> create (@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    public List <Todo> list (){
        return todoService.list();
    }

    @PutMapping(value = "/{id}")
    public List <Todo> update (@PathVariable String id,@RequestBody Todo todo){
        todoService.update(id, todo);
        return list();
    }

    @DeleteMapping(value = "/{id}")
    public List <Todo> delete (@PathVariable String id){
        return todoService.delete(id);
    }

}


