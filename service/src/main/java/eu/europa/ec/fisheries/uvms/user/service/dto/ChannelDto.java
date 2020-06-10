package eu.europa.ec.fisheries.uvms.user.service.dto;

import lombok.Data;

@Data
public class ChannelDto {

    private Long channelId;

    private String dataflow;

    private String service;
}
