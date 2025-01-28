package com.gala.standardization.platform.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "domains")
@NamedQuery(name="Domain.findByCityId", query="SELECT d FROM Domain d WHERE d.city.cityId = :cityId")
public class Domain {
    
    @Id
    private String domainId;

    @Column(nullable = false, name = "domain_name") // Ensure correct column mapping
    private String domainName;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToOne
    @JoinColumn(name = "standard_protocol_id")
    private Standard standardProtocol;

    @OneToOne
    @JoinColumn(name = "algorithm_id")
    private DataReleaseAlgorithm dataReleaseAlgorithm;

    // Default constructor
    public Domain() {
        super();
    }

    // Parameterized constructor
    public Domain(String domainId, String domainName, City city, Standard standardProtocol,
                  DataReleaseAlgorithm dataReleaseAlgorithm) {
        this.domainId = domainId;
        this.domainName = domainName;
        this.city = city;
        this.standardProtocol = standardProtocol;
        this.dataReleaseAlgorithm = dataReleaseAlgorithm;
    }

    // Getters and Setters
    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCityId() {
        return city != null ? city.getCityId() : null;
    }

    public Standard getStandardProtocol() {
        return standardProtocol;
    }

    public void setStandardProtocol(Standard standardProtocol) {
        this.standardProtocol = standardProtocol;
    }

    public DataReleaseAlgorithm getDataReleaseAlgorithm() {
        return dataReleaseAlgorithm;
    }

    public void setDataReleaseAlgorithm(DataReleaseAlgorithm dataReleaseAlgorithm) {
        this.dataReleaseAlgorithm = dataReleaseAlgorithm;
    }

    @Override
    public String toString() {
        return "Domain [domainId=" + domainId + ", domainName=" + domainName + ", city=" + city
                + ", standardProtocol=" + standardProtocol + ", dataReleaseAlgorithm=" + dataReleaseAlgorithm + "]";
    }
}
