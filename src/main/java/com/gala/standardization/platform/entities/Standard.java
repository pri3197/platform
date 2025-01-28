package com.gala.standardization.platform.entities;

import java.util.UUID;

import com.gala.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="standard")
public class Standard {
 @Id
 @GeneratedValue
private UUID standardId;

@Column(nullable = false)
private String standardName;
@OneToOne(mappedBy = "standardProtocol")
private Domain domain;
@Column(columnDefinition = "TEXT")
private String description;
private String version;
   @Enumerated(EnumType.STRING)  // ✅ Maps ENUM as STRING, fixing the issue!
    @Column(name = "compliance_level", nullable = false)
private Status complianceLevel;

// Default constructor
public Standard() {
    super();
}

public UUID getStandardId() {
    return standardId;
}

public void setStandardId(UUID standardId) {
    this.standardId = standardId;
}

public String getStandardName() {
    return standardName;
}

public void setStandardName(String standardName) {
    this.standardName = standardName;
}

public Domain getDomain() {
    return domain;
}

public void setDomain(Domain domain) {
    this.domain = domain;
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

public Status getComplianceLevel() {
    return complianceLevel;
}

public void setComplianceLevel(Status complianceLevel) {
    this.complianceLevel = complianceLevel;
}

public Standard(UUID standardId, String standardName, Domain domain, String description, String version,
        Status complianceLevel) {
    this.standardId = standardId;
    this.standardName = standardName;
    this.domain = domain;
    this.description = description;
    this.version = version;
    this.complianceLevel = complianceLevel;
}

@Override
public String toString() {
    return "Standard [standardId=" + standardId + ", standardName=" + standardName + ", domain=" + domain
            + ", description=" + description + ", version=" + version + ", complianceLevel=" + complianceLevel + "]";
}

}
