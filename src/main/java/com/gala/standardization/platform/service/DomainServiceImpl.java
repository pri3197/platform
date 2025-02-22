package com.gala.standardization.platform.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gala.standardization.platform.entities.Domain;
import com.gala.standardization.platform.repository.DomainDTO;
import com.gala.standardization.platform.repository.DomainMapper;
import com.gala.standardization.platform.repository.DomainRepository;

import org.springframework.beans.factory.annotation.Autowired;




@Service
public class DomainServiceImpl  {
  @Autowired
    private DomainRepository domainRepository;


    @Autowired
    private DomainMapper domainMapper;


// List<Domain> domainList = new ArrayList<>(Arrays.asList(
//     new Domain(2221, "Transportation", "Domain for transportation data", "NYC"),
//     new Domain(2222, "Environment", "Domain for environmental data", "NYC"),
//     new Domain(2223, "Healthcare", "Domain for healthcare data", "LON")
// ));
   
    // @Override
    // public List<Domain> getDomainsByCity(String cityId) {
    //     List<Domain> domainListbyCity = new ArrayList<>();
    //     for (Domain domain : domainList) {
    //         if (domain.getCityId().equals(cityId))
    //          domainListbyCity.add(domain);
    //     }
    //     return domainListbyCity;
    // }

    // @Override
    // public Domain getDomain(String cityId, long domainId) {
       
    //     for (Domain domain : domainList) {
    //         if (domain.getCityId().equals(cityId)&& domain.getId()==domainId)
    //         return domain;
    //     }
       
    //  return null;
    // }

    // @Override
    // public Domain addDomain(Domain domain) {
    //     domainList.add(domain);
    //     return domain;
    // }

        // Get a domain by ID
    public DomainDTO getDomainById(String domainId) {
        Domain domain = domainRepository.findById(domainId)
                .orElseThrow(() -> new RuntimeException("Domain not found"));
        return domainMapper.toDTO(domain);
    }

    // Get all domains for a city
    public List<DomainDTO> getDomainsByCity(String cityId) {
        List<Domain> domains = domainRepository.findByCity_CityId(cityId);
        return domains.stream().map(domainMapper::toDTO).collect(Collectors.toList());
    }
}
