/*
﻿Developed with the contribution of the European Commission - Directorate General for Maritime Affairs and Fisheries
© European Union, 2015-2016.

This file is part of the Integrated Fisheries Data Management (IFDM) Suite. The IFDM Suite is free software: you can
redistribute it and/or modify it under the terms of the GNU General Public License as published by the
Free Software Foundation, either version 3 of the License, or any later version. The IFDM Suite is distributed in
the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a
copy of the GNU General Public License along with the IFDM Suite. If not, see <http://www.gnu.org/licenses/>.
*/
package eu.europa.fisheries.uvms.organisation.service;

import eu.europa.ec.fisheries.uvms.user.service.dao.OrganisationDao;
import eu.europa.ec.mare.usm.information.entity.ChannelEntity;
import eu.europa.ec.mare.usm.information.entity.EndPointEntity;
import eu.europa.ec.mare.usm.information.entity.OrganisationEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class OrganisationServiceBeanTest {

    @Mock
    OrganisationDao organisationDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOrganisations() {

        List<OrganisationEntity> organisationEntities = new ArrayList<>();
        OrganisationEntity oe1 = new OrganisationEntity();
        organisationEntities.add(oe1);
        oe1.setOrganisationId(1L);
        oe1.setName("ORG_1");
        oe1.setIsoa3code("iosacode_1");
        oe1.setStatus("ACTIVE");

        List<EndPointEntity> endPointList = new ArrayList<>();
        oe1.setEndPointList(endPointList);
        EndPointEntity ep1 = new EndPointEntity();
        endPointList.add(ep1);
        ep1.setOrganisation(oe1);
        ep1.setUri("EP/1");
        ep1.setStatus("ACTIVE");
        ep1.setName("EP1");
        List<ChannelEntity> channelList = new ArrayList<>();
        ep1.setChannel(channelList);
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setEndPoint(ep1);
        channelEntity.setDataflow("DATAFLOW_1");
        channelEntity.setService("SERVICE_1");
        channelEntity.setPriority(1);
        channelList.add(channelEntity);

        when(organisationDao.findOrganisations()).thenReturn(organisationEntities);

        List<OrganisationEntity> dbMockEntities = organisationDao.findOrganisations();

        assertNotNull(dbMockEntities);
        assertFalse(dbMockEntities.isEmpty());
    }
}
