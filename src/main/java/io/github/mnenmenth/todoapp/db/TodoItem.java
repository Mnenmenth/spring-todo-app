package io.github.mnenmenth.todoapp.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@Entity
public class TodoItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Boolean complete;

    public TodoItem() {}
    public TodoItem(String name, String description, Boolean complete)
    {
        this.name = name;
        this.description = description;
        this.complete = complete;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getComplete()
    {
        return complete;
    }

    public void setComplete(Boolean complete)
    {
        this.complete = complete;
    }

    @Override
    public String toString()
    {
        return String.format("TodoItem{id=%d, name='%s', description='%s', complete='%b'}",
                                id,
                                name,
                                description,
                                complete
                             );
    }
}
