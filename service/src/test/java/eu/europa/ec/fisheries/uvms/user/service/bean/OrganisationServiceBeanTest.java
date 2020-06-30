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
        OrganisationChannelEntityId organisationChannelEntityId = new OrganisationChannelEntityId(1L,5L,4L);

        when(organisationDao.findOrganizationByDataFlowAndEndpoint("service","GRC:backup")).thenReturn(new ArrayList<>(Collections.singletonList(organisationChannelEntityId)));

        Optional<OrganisationChannelEntityId> result = serviceBean.findOrganizationByEndpointAndChannel("service", "GRC:backup");
        assertTrue(result.isPresent());
        assertEquals(organisationChannelEntityId,result.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindOrganizationByEndpointAndChannelException() {
        OrganisationChannelEntityId id1 = new OrganisationChannelEntityId(1L,5L,4L);
        OrganisationChannelEntityId id2 = new OrganisationChannelEntityId(2L,6L,7L);

        when(organisationDao.findOrganizationByDataFlowAndEndpoint("dataflow","FLUX.GRC_backup")).thenReturn(new ArrayList<>(Arrays.asList(id1, id2)));

        serviceBean.findOrganizationByEndpointAndChannel("dataflow", "FLUX.GRC_backup");
    }
}
