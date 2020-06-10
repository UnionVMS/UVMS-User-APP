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

import eu.europa.ec.fisheries.uvms.user.service.dto.ChannelDto;
import eu.europa.ec.fisheries.uvms.user.service.dto.EndPointDto;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganisationDto;

import java.util.ArrayList;
import java.util.List;

public class OrganisationTestHelper {


    static List<OrganisationDto> createFullFetchedMockList(){
        return createOrganisationMockList(true,true);
    }

    static List<OrganisationDto> createOrganisationMockList(boolean fetchEndPoints,boolean fetchChannels){

        List<OrganisationDto> list = new ArrayList<>();
        OrganisationDto o1 = new OrganisationDto();
        list.add(o1);
        o1.setIsoa3code("isoa3code_1");
        o1.setName("org_1");
        o1.setOrganisationId(1L);
        if(fetchEndPoints){
            o1.setEndPointList(createEndPointMockList(fetchChannels));
        }
        return list;
    }

    static List<EndPointDto> createEndPointMockList(boolean fetchChannels){

        List<EndPointDto> list = new ArrayList<>();
        EndPointDto e1 = new EndPointDto();
        list.add(e1);
        e1.setEndPointId(11L);
        e1.setName("endpoint_1_1");
        e1.setUri("endP/oint");
        if(fetchChannels){
            e1.setChannel(createChannelMockList());
        }
        return list;
    }

    static List<ChannelDto> createChannelMockList(){

        List<ChannelDto> list = new ArrayList<>();
        ChannelDto c1 = new ChannelDto();
        list.add(c1);
        c1.setChannelId(111L);
        c1.setDataflow("c1_df");
        c1.setService("c1_service");
        return list;
    }
}
