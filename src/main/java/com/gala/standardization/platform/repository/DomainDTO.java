package com.gala.standardization.platform.repository;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainDTO {
    private String domainId;
    private String domainName;
    private String cityId;  // Only sending the City ID, not the entire City object
    private UUID standardProtocolId;
    private UUID dataReleaseAlgorithmId;
}

