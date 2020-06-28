package com.example.server.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "service")
    private List<Employee> employees;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(final String Name) {
		this.name = Name;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service [description=" + description + ", id=" + id + ", name=" + name
                + "]";
    }

    public Service(final String Name, final String description) {
        this.name = Name;
        this.description = description;
    }

    public Service() {
    }

}
