package eu.europa.ec.fisheries.uvms.user.service.bean;

import eu.europa.ec.fisheries.uvms.user.service.dao.OrganisationDao;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganizationByEndpointAndChannelDto;
import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;
import eu.europa.ec.mare.usm.information.entity.ChannelEntity;
import eu.europa.ec.mare.usm.information.entity.OrganisationEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class OrganisationServiceBeanTest{

    @InjectMocks
    OrganisationServiceBean serviceBean;

    @Mock
    OrganisationDao organisationDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findOrganizationByEndpointAndChannelTest() {

        OrganisationChannelEntityId organisationChannelEntityId = new OrganisationChannelEntityId(1l,5l,4l);

        when(organisationDao.findOrganizationByDataFlowAndEndpointName("dataflow","FLUX.GRC_backup")).thenReturn(new ArrayList<>(Arrays.asList(organisationChannelEntityId)));

        OrganizationByEndpointAndChannelDto organization = serviceBean.findOrganizationByEndpointAndChannel("dataflow", "FLUX.GRC_backup");
        assertEquals((long)organization.getOrganisationId(),4);
        assertEquals((long)organization.getChannelId(),1);
        assertEquals((long)organization.getEndpointId(),5);
    }
}
