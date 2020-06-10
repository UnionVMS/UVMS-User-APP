package eu.europa.fisheries.uvms.user.service.converter;

import eu.europa.ec.fisheries.uvms.user.service.converter.OrganizationMapper;
import eu.europa.ec.fisheries.uvms.user.service.converter.OrganizationMapperImpl;
import eu.europa.ec.fisheries.uvms.user.service.dto.ChannelDto;
import eu.europa.ec.fisheries.uvms.user.service.dto.EndPointDto;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganisationDto;
import eu.europa.ec.mare.usm.information.entity.ChannelEntity;
import eu.europa.ec.mare.usm.information.entity.EndPointEntity;
import eu.europa.ec.mare.usm.information.entity.OrganisationEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrganisationMapperTest {

    private static final Long ORG_ID = 1L;
    private static final String NAME = "name";
    private static final String ISO_A3_CODE = "iso_a_3_code";

    private static final Long END_POINT_ID = 2L;
    private static final String END_POINT_NAME = "EPname";
    private static final String END_POINT_URI = "END_POINT_URI";

    private static final Long CHANNEL_ID = 3L;
    private static final String DATA_FLOW = "DATA_FLOW";
    private static final String SERVICE = "SERVICE";

    @Test
    public void testOrganisationEntityToOrganisationDto(){

        OrganizationMapper mapp = new OrganizationMapperImpl();

        OrganisationEntity e1 = new OrganisationEntity();
        e1.setOrganisationId(ORG_ID);
        e1.setName(NAME);
        e1.setIsoa3code(ISO_A3_CODE);


        EndPointEntity ep1 = new EndPointEntity();
        ep1.setOrganisation(e1);
        ep1.setEndPointId(END_POINT_ID);
        ep1.setName(END_POINT_NAME);
        ep1.setUri(END_POINT_URI);

        List<EndPointEntity> eplist = new ArrayList<>();
        eplist.add(ep1);

        e1.setEndPointList(eplist);

        ChannelEntity c1 = new ChannelEntity();
        c1.setChannelId(CHANNEL_ID);
        c1.setDataflow(DATA_FLOW);
        c1.setService(SERVICE);

        c1.setEndPoint(ep1);
        List<ChannelEntity> c1list = new ArrayList<>();
        c1list.add(c1);
        ep1.setChannel(c1list);

        OrganisationDto orgDTO = mapp.organisationEntityToOrganisationDto(e1);

        Assert.assertEquals("Returned mapped OrganisationDto.id wasn't what expected",ORG_ID,orgDTO.getOrganisationId());
        Assert.assertEquals("Returned mapped OrganisationDto.name wasn't what expected",NAME,orgDTO.getName());
        Assert.assertEquals("Returned mapped OrganisationDto.isoa3code wasn't what expected",ISO_A3_CODE,orgDTO.getIsoa3code());

        Assert.assertNotNull(orgDTO.getEndPointList());
        Assert.assertEquals("Returned mapped OrganisationDto.endPointList size wasn't what expected",eplist.size(),orgDTO.getEndPointList().size());

        EndPointDto endPointDto = orgDTO.getEndPointList().get(0);

        Assert.assertEquals("Returned mapped EndPointDto.id wasn't what expected",END_POINT_ID,endPointDto.getEndPointId());
        Assert.assertEquals("Returned mapped EndPointDto.name wasn't what expected",END_POINT_NAME,endPointDto.getName());
        Assert.assertEquals("Returned mapped EndPointDto.uri wasn't what expected",END_POINT_URI,endPointDto.getUri());

        Assert.assertNotNull(endPointDto.getChannel());
        Assert.assertEquals("Returned mapped endPointDto.channel list size wasn't what expected",c1list.size(),endPointDto.getChannel().size());

        ChannelDto channelDto = endPointDto.getChannel().get(0);

        Assert.assertEquals("Returned mapped ChannelDto.channelId wasn't what expected",CHANNEL_ID,channelDto.getChannelId());
        Assert.assertEquals("Returned mapped ChannelDto.dataflow wasn't what expected",DATA_FLOW,channelDto.getDataflow());
        Assert.assertEquals("Returned mapped ChannelDto.service wasn't what expected",SERVICE,channelDto.getService());

    }
}
