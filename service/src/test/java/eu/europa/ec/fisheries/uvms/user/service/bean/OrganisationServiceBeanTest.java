package eu.europa.ec.fisheries.uvms.user.service.bean;

import eu.europa.ec.fisheries.uvms.user.service.dao.OrganisationDao;
import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    public void testFindOrganizationByEndpointAndChannel() {
        OrganisationChannelEntityId organisationChannelEntityId = new OrganisationChannelEntityId(1l,5l,4l);

        when(organisationDao.findOrganizationByDataFlowAndEndpointName("dataflow","FLUX.GRC_backup")).thenReturn(new ArrayList<>(Collections.singletonList(organisationChannelEntityId)));

        Optional<OrganisationChannelEntityId> result = serviceBean.findOrganizationByEndpointAndChannel("dataflow", "FLUX.GRC_backup");
        assertTrue(result.isPresent());
        assertEquals(organisationChannelEntityId,result.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindOrganizationByEndpointAndChannelException() {
        OrganisationChannelEntityId id1 = new OrganisationChannelEntityId(1l,5l,4l);
        OrganisationChannelEntityId id2 = new OrganisationChannelEntityId(2l,6l,7l);

        when(organisationDao.findOrganizationByDataFlowAndEndpointName("dataflow","FLUX.GRC_backup")).thenReturn(new ArrayList<>(Arrays.asList(id1, id2)));

        serviceBean.findOrganizationByEndpointAndChannel("dataflow", "FLUX.GRC_backup");
    }
}
