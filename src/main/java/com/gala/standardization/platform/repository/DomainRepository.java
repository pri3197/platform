// package com.gala.standardization.platform.repository;

// import com.gala.standardization.platform.entities.Domain;
// import java.util.List;

// public interface DomainRepository  {
//     List<Domain> getDomainsByCity(String cityId);
//     Domain getDomain(String cityId, long domainId);
//     List<Domain> findAll();
//     Domain addDomain(Domain domain);
//     boolean existsById(Long id);
//     long count();

// }
package com.gala.standardization.platform.repository;

import com.gala.standardization.platform.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DomainRepository extends JpaRepository<Domain, String> {
    List<Domain> findByCity_CityId(String cityId); // Get all domains for a given city
}
