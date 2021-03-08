package com.di.sd.backapi.todos;

import javax.validation.Valid;

import com.di.sd.backapi.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/agenda/todo")
public class TodoController {
    @Autowired
    MapVAlidationErrorService mVerrors;
    @Autowired
    TodoRepo todorepo;

    @PostMapping("")
    public ResponseEntity<?> addTodo(@Valid @RequestBody Todo todo, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Todo format = todorepo.save(todo);
        return new ResponseEntity<Todo>(format, HttpStatus.OK);

    }

    @GetMapping("")
    public TodoResponse getAllProjects() {

        TodoResponse todoResponse = new TodoResponse();

        todoResponse.setInstances(todorepo.findByDoneFalse());
        todoResponse.setTermines(todorepo.findTop7ByDoneTrue());
        return todoResponse;

    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        todorepo.delete(todorepo.findById(projectId).get());

        return new ResponseEntity<String>("todo Deleted", HttpStatus.OK);
    }

    @GetMapping("/done/{projectId}")
    public ResponseEntity<?> doneTodo(@PathVariable Long projectId) {

        Todo todo = todorepo.findById(projectId).get();
        todo.setDone(true);
        todorepo.save(todo);
        return new ResponseEntity<String>("todo done", HttpStatus.OK);
    }
}
