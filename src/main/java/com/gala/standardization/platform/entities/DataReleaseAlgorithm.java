package com.gala.standardization.platform.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="data_release_algorithms")
public class DataReleaseAlgorithm {
 @Id
 @GeneratedValue
  @Column(name = "algorithm_id")  // Ensure it matches the actual column name
    private UUID algoId;
    @Column(name = "algorithm_name", nullable = false)
    private String algoName;

    @Column(name = "code_reference", nullable = false)
    private String codeRef;
    @OneToOne(mappedBy = "dataReleaseAlgorithm")
    private Domain domain;
   
    
    public DataReleaseAlgorithm() {
       
    }
    public DataReleaseAlgorithm(UUID algoId, String algoName, Domain domain, String codeRef) {
        this.algoId = algoId;
        this.algoName = algoName;
        this.domain = domain;
        this.codeRef = codeRef;
    }
    public UUID getAlgoId() {
        return algoId;
    }
    public void setAlgoId(UUID algoId) {
        this.algoId = algoId;
    }
    public String getAlgoName() {
        return algoName;
    }
    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }
 
    public Domain getDomain() {
        return domain;
    }
    public void setDomainId(Domain domain) {
        this.domain = domain;
    }
    public String getCodeRef() {
        return codeRef;
    }
    public void setCodeRef(String codeRef) {
        this.codeRef = codeRef;
    }
    

}
