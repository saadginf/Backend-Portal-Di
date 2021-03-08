package com.di.sd.backapi.todos;

import java.util.ArrayList;
import java.util.List;

public class TodoResponse {
    private List<Todo> instances = new ArrayList<Todo>();
    private List<Todo> termines = new ArrayList<Todo>();

    /**
     * @return List<Todo> return the instances
     */
    public List<Todo> getInstances() {
        return instances;
    }

    /**
     * @param instances the instances to set
     */
    public void setInstances(List<Todo> instances) {
        this.instances = instances;
    }

    /**
     * @return List<Todo> return the termines
     */
    public List<Todo> getTermines() {
        return termines;
    }

    /**
     * @param termines the termines to set
     */
    public void setTermines(List<Todo> termines) {
        this.termines = termines;
    }

    public TodoResponse() {
    }

}
