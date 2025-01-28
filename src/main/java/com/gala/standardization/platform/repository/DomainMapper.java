package com.gala.standardization.platform.repository;



import com.gala.standardization.platform.repository.DomainDTO;
import com.gala.standardization.platform.entities.Domain;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper {
    
    public DomainDTO toDTO(Domain domain) {
        return new DomainDTO(
                domain.getDomainId(),
                domain.getDomainName(),
                domain.getCity() != null ? domain.getCity().getCityId() : null,  // Prevent NullPointerException
                domain.getStandardProtocol() != null ? domain.getStandardProtocol().getStandardId() : null,
                domain.getDataReleaseAlgorithm() != null ? domain.getDataReleaseAlgorithm().getAlgoId() : null
        );
    }

    public Domain toEntity(DomainDTO dto) {
        Domain domain = new Domain();
        domain.setDomainId(dto.getDomainId());
        domain.setDomainName(dto.getDomainName());
        
        // City, StandardProtocol, PrivacyProtocol, and DataReleaseAlgorithm
        // should be set in the Service Layer (Ensure they exist before setting)
        
        return domain;
    }
}
