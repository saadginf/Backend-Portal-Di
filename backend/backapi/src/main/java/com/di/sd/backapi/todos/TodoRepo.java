package com.di.sd.backapi.todos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    public List<Todo> findTop7ByDoneTrue();

    public List<Todo> findByDoneFalse();
}
