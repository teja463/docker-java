package com.teja.dockerjava.todo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teja.dockerjava.todo.TodoController.UpdateTodoRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RequestMapping("/todo")
@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
 
    @PostMapping
    public Todo createTodo(@RequestBody @Valid TodoRequest requestTodo) {
        Todo t = new Todo();
        t.setTodo(requestTodo.todo());
        t.setCompleted(false);
        Todo entity = todoRepository.save(t);
        return entity;
    }
    
    @PutMapping
    public Todo updateTodo(@RequestBody @Valid UpdateTodoRequest requestTodo) {
        Todo t = todoRepository.findById(requestTodo.id()).orElseThrow();
        t.setCompleted(requestTodo.completed());
        Todo entity = todoRepository.save(t);
        return entity;
    }


    record TodoRequest(@NotEmpty String todo) {}

    record UpdateTodoRequest(@NotNull Integer id, @NotNull Boolean completed) {}

}
