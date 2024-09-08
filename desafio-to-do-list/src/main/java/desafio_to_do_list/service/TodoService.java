package desafio_to_do_list.service;

import desafio_to_do_list.entity.Todo;
import desafio_to_do_list.repository.TodoRepository;
import desafio_to_do_list.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    public TodoRepository todoRepository;

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(String id, Todo todo) {
        Optional<Todo> referTodo = todoRepository.findById(id);

        if (referTodo.isPresent()) {
            Todo entity = referTodo.get();

            entity.setName(todo.getName());
            entity.setDescricao(todo.getDescricao());
            entity.setPrioridade(todo.getPrioridade());
            entity.setRealiazada(todo.getRealiazada());

            todoRepository.save(entity);

            return list();
        } else {
            throw new ObjectNotFoundException("Todo não foi encontrada " + id);
        }
    }

    public List<Todo> delete(String id) {

        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Todo não foi encontrada " + id);
        }
        return list();
    }

}

