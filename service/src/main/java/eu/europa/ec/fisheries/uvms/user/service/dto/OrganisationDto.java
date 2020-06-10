package eu.europa.ec.fisheries.uvms.user.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrganisationDto {

    private Long organisationId;

    private String name;

    private String isoa3code;

    private List<EndPointDto> endPointList;

}
