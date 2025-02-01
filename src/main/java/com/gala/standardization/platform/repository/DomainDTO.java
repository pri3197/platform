package com.gala.standardization.platform.repository;


import lombok.*;

import java.util.UUID;

import com.gala.standardization.platform.entities.Domain;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainDTO {
    private String domainId;
    private String domainName;
    private String cityId;  // Only sending the City ID, not the entire City object
    private UUID standardProtocolId;  //Only sending the Standard ID,
    private UUID dataReleaseAlgorithmId;// Only sending the data release algorithm ID,
}

