package com.gala.standardization.platform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "domains")
@NamedQuery(name="Domain.findByCityId", query="SELECT d FROM Domain d WHERE d.cityId = :cityId")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String cityId;

    // Default constructor
    public Domain() {
        super();
    }

    // Parameterized constructor
    public Domain(long id, String name, String description, String cityId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.cityId = cityId;
    }

    // Getter and Setter methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDomainName() {
        return name;
    }

    public void setDomainName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Domain [id=" + id + ", DomainName=" + name + ", description=" + description + "]";
    }
}