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
package eu.europa.ec.fisheries.uvms.organisation.rest;

import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseCode;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseDto;
import eu.europa.ec.fisheries.uvms.user.rest.service.OrganisationResource;
import eu.europa.ec.fisheries.uvms.user.service.OrganisationService;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganisationDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OrganisationResourceTest {

    private final ResponseDto<List<OrganisationDto>> SUCCESS_RESULT;

    private List<OrganisationDto> organisationDtoList = OrganisationTestHelper.createFullFetchedMockList();

    @Mock
    private OrganisationService organisationService;

    @InjectMocks
    OrganisationResource organisationResource;

    public OrganisationResourceTest(){

        SUCCESS_RESULT = new ResponseDto<>(organisationDtoList,ResponseCode.OK);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrganisationWithEndPointsAndChannels() {

        when(organisationService.findOrganisationsWithEndPointsAndChannels()).thenReturn(organisationDtoList);

        ResponseDto<List<OrganisationDto>> response = organisationResource.getOrganisationsWithEndPointsAndChannels();
        assertEquals(SUCCESS_RESULT.toString(), response.toString());
    }
}
