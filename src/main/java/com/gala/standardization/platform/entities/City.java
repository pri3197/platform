package com.gala.standardization.platform.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column(nullable = false)
    private String cityId;

    @Column(nullable = false)
    private String city_name;
   
    @Column(nullable = true)
    private Date createdAt;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domain> domains;
    public String getCityId() {
        return cityId;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
  
    public String getCity_name() {
        return city_name;
    }
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
  
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public List<Domain> getDomains() {
        return domains;
    }
    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }
    @Override
    public String toString() {
        return "City [cityId=" + cityId + ", city_name=" + city_name + ", createdAt=" + createdAt + ", domains="
                + domains + "]";
    }

    
}
