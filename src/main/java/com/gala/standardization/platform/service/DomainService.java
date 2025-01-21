package com.gala.standardization.platform.service;
import com.gala.standardization.platform.entities.Domain;
import java.util.List;

public interface DomainService {

    List<Domain> getDomainsByCity(String cityId);
    Domain getDomain(String cityId, long domainId);
    Domain addDomain(Domain domain);
}
