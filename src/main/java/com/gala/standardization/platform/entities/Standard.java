package com.gala.standardization.platform.entities;

public class Standard {
private long id;
private String standardName;
private String description;
private String version;
private String status;
private String category;
private String scope;
private String requirements;
private String guidelines;

// Default constructor
public Standard() {
    super();
}

// Parameterized constructor
public Standard(long id, String standardName, String description, String version, 
               String status, String category, String scope, String requirements, String guidelines) {
    super();
    this.id = id;
    this.standardName = standardName;
    this.description = description;
    this.version = version;
    this.status = status;
    this.category = category;
    this.scope = scope;
    this.requirements = requirements;
    this.guidelines = guidelines;
}

// Getter and Setter methods
public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getStandardName() {
    return standardName;
}

public void setStandardName(String standardName) {
    this.standardName = standardName;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getVersion() {
    return version;
}

public void setVersion(String version) {
    this.version = version;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getScope() {
    return scope;
}

public void setScope(String scope) {
    this.scope = scope;
}

public String getRequirements() {
    return requirements;
}

public void setRequirements(String requirements) {
    this.requirements = requirements;
}

public String getGuidelines() {
    return guidelines;
}

public void setGuidelines(String guidelines) {
    this.guidelines = guidelines;
}

@Override
public String toString() {
    return "Standard [id=" + id + 
           ", standardName=" + standardName + 
           ", description=" + description +
           ", version=" + version +
           ", status=" + status +
           ", category=" + category +
           ", scope=" + scope +
           ", requirements=" + requirements +
           ", guidelines=" + guidelines + "]";
}

}
