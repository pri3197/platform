package com.gala.standardization.platform.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.stereotype.Service;

import com.gala.standardization.platform.entities.Domain;




@Service
public class DomainServiceImpl implements DomainService {

List<Domain> domainList = new ArrayList<>(Arrays.asList(
    new Domain(2221, "Transportation", "Domain for transportation data", "NYC"),
    new Domain(2222, "Environment", "Domain for environmental data", "NYC"),
    new Domain(2223, "Healthcare", "Domain for healthcare data", "LON")
));
   
    @Override
    public List<Domain> getDomainsByCity(String cityId) {
        List<Domain> domainListbyCity = new ArrayList<>();
        for (Domain domain : domainList) {
            if (domain.getCityId().equals(cityId))
             domainListbyCity.add(domain);
        }
        return domainListbyCity;
    }

    @Override
    public Domain getDomain(String cityId, long domainId) {
       
        for (Domain domain : domainList) {
            if (domain.getCityId().equals(cityId)&& domain.getId()==domainId)
            return domain;
        }
       
     return null;
    }

    @Override
    public Domain addDomain(Domain domain) {
        domainList.add(domain);
        return domain;
    }
}
