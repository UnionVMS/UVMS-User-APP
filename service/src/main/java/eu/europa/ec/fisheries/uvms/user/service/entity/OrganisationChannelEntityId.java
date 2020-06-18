package eu.europa.ec.fisheries.uvms.user.service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrganisationChannelEntityId {
    private Long channelId;
    private Long endpointId;
    private Long organisationId;
}
