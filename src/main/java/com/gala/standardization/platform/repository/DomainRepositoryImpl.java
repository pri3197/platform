// package com.gala.standardization.platform.repository;

// import java.util.List;



// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// import com.gala.standardization.platform.entities.Domain;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.TypedQuery;

// @Repository
// @Transactional
// public class DomainRepositoryImpl implements DomainRepository {

// @PersistenceContext
// private EntityManager eManager;
// @Override
// public List<Domain> getDomainsByCity(String cityId){
//    TypedQuery <Domain> query =eManager.createNamedQuery("Domain.findByCityId", Domain.class);
//    query.setParameter("cityID", cityId);
//     return query.getResultList();
// }
// @Override
// public Domain getDomain(String cityId, long domainId) {
//     return null;}

// @Override
// public Domain addDomain(Domain domain) {
   
//     return domain;
// }
// @Override
// public List<Domain> findAll(){ 
//     return null;}

// @Override
// public boolean existsById(Long id){
//     return false;}

// @Override
// public long count(){
//     return 2131545;}
// }
