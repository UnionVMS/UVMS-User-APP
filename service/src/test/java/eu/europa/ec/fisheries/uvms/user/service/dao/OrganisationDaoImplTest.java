package eu.europa.ec.fisheries.uvms.user.service.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;
import eu.europa.ec.mare.usm.information.entity.OrganisationEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class OrganisationDaoImplTest extends BaseUserInMemoryTest {


    @Before
    public void prepare() {
        Operation operation = sequenceOf(INSERT_ORGANIZATION,INSERT_ENDPOINT,INSERT_CHANNEL);
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(ds), operation);
        dbSetupTracker.launchIfNecessary(dbSetup);
    }

    @Test
    public void findOrganizationByDataFlow() {
        List<OrganisationChannelEntityId> organisationChannelEntityId = (new OrganisationDaoImpl(em)).findOrganizationByDataFlowAndEndpointName("dataflow","FLUX.GRC_backup");
        assertFalse(organisationChannelEntityId.isEmpty());
        assertEquals((long)organisationChannelEntityId.get(0).getOrganisationId(),4);
        assertEquals((long)organisationChannelEntityId.get(0).getChannelId(),1);
        assertEquals((long)organisationChannelEntityId.get(0).getEndpointId(),5);
    }


    @Test
    public void testFindOrganisations() {
        List<OrganisationEntity> organisationEntities = new OrganisationDaoImpl(em).findOrganisations();
        assertNotNull(organisationEntities);
        assertFalse(organisationEntities.isEmpty());
    }
}
