package com.example.demo;

import com.example.demo.todos.TodoEntity;
import com.example.demo.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    public void BeanGenerator(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }
}