package eu.europa.ec.fisheries.uvms.user.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class EndPointDto {

    private Long endPointId;

    private String name;

    private String uri;

    private List<ChannelDto> channel;
}
