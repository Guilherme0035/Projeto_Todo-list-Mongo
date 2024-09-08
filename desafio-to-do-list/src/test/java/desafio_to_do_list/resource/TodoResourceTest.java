package desafio_to_do_list.resource;

import com.jayway.jsonpath.Criteria;
import desafio_to_do_list.entity.Todo;
import desafio_to_do_list.repository.TodoRepository;
import desafio_to_do_list.service.TodoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataMongoTest
@ActiveProfiles("test")
class TodoResourceTest {

    @Autowired
    TodoRepository todoRepository;

    @Test
    @DisplayName("Created Todo Success")
    void createSuccessTodo() {
        Todo todo = new Todo("tarefa 1", "descri todo", false, 1);

        Todo result = todoRepository.save(todo);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
    }

    @Test
    @DisplayName("Cread Todo Failed")
    void createdFailedTodo() {
        Todo todo = new Todo("teste 1 ", "desci todo", false, 1);

        TodoRepository mockRepository = mock(TodoRepository.class);

        when(mockRepository.save(any(Todo.class))).thenReturn(null);

        Todo result = mockRepository.save(todo);

        assertThat(result).isNull();
        verify(mockRepository, times(1)).save(todo);
    }

    @Test
    @DisplayName("list success todos")
    void listSuccess() {
        Todo todo = new Todo("tafera 1", "descri 1", false, 2);
        Todo todo2 = new Todo("tafera 2", "descri 1", false, 2);

        List<Todo> todos = todoRepository.saveAll(Arrays.asList(todo, todo2));

        assertThat(todos).isNotNull();
        assertThat(todos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("list failure todos")
    void listFailure() {
        Todo todo = new Todo("tafera 1", "descri 1", false, 2);
        Todo todo2 = new Todo("tafera 2", "descri 1", false, 2);

        TodoRepository mockRepository = mock(TodoRepository.class);

        when(mockRepository.saveAll(anyList())).thenReturn(null);

        List<Todo> results = mockRepository.saveAll(Arrays.asList(todo, todo2));

        assertThat(results).isNull();
        verify(mockRepository, times(1)).saveAll(Arrays.asList(todo, todo2));
    }

    @Test
    @DisplayName("Update todo success")
    void updateTodoSucess() {
        Todo createTodo = new Todo("Tarefa 1 ", "descri 1 ", false, 1);
        Todo saveTodo = todoRepository.save(createTodo);

        saveTodo.setName("tarefa 2");
        saveTodo.setDescricao("descricao 2");
        saveTodo.setRealiazada(true);
        saveTodo.setPrioridade(2);

        Todo udpateTodo = todoRepository.save(saveTodo);

        assertThat(udpateTodo).isNotNull();
        assertThat(udpateTodo.getName()).isEqualTo("tarefa 2");
        assertThat(udpateTodo.getDescricao()).isEqualTo("descricao 2");
        assertThat(udpateTodo.getRealiazada()).isEqualTo(true);
        assertThat(udpateTodo.getPrioridade()).isEqualTo(2);
    }

    @Test
    @DisplayName("Failed update Todo")
    void failedUpdateTodo() {
        Todo todo = new Todo("Tarefa 1 ", "descri 1", false, 1);

        TodoRepository mockiRepository = mock(TodoRepository.class);

        when(mockiRepository.save(any(Todo.class))).thenReturn(todo);

        when(mockiRepository.save(any(Todo.class))).thenReturn(null);

        todo.setName("tarefa att");
        todo.setDescricao("descr todo att");
        todo.setPrioridade(1);

        Todo update = mockiRepository.save(todo);

        assertThat(update).isNull();
        verify(mockiRepository, times(1)).save(todo);
    }

    @Test
    @DisplayName("Deleted Todo Success")
    void deleteSuccessTodo() {
        Todo todo = new Todo("tarefa 1", "descr 1", false, 1);

        Todo savedTodo = todoRepository.save(todo);

        todoRepository.delete(savedTodo);

        Optional<Todo> buscaTodo = todoRepository.findById(savedTodo.getId());
        assertThat(buscaTodo).isEmpty();
    }

    @Test
    @DisplayName("Failed todo delete")
    void failedDeleteTodo () {
        Todo todo = new Todo("tarefa 1", "descri 1", false,1);

        TodoRepository mockiRepository = mock(TodoRepository.class);

        doThrow(new RuntimeException("erro ao deletar todo")).when(mockiRepository).delete(todo);

        assertThrows(RuntimeException.class, () ->{
            mockiRepository.delete(todo);

        });

        verify(mockiRepository, times(1)).delete(todo);
    }

}

