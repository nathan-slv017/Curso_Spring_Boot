package com.example.demo.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if (existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com essa descrição");
        }
    }

    private boolean existeTodoComDescricao(String descricao){
        return repository.existsByDescricao(descricao);

    }
}
