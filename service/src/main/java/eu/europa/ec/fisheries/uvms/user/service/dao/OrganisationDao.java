/*
 * Developed by the European Commission - Directorate General for Maritime
 * Affairs and Fisheries © European Union, 2015-2016.
 *
 * This file is part of the Integrated Fisheries Data Management (IFDM) Suite.
 * The IFDM Suite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or any later version.
 * The IFDM Suite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details. You should have received a copy of the GNU General Public
 * License along with the IFDM Suite. If not, see http://www.gnu.org/licenses/.
 */

package eu.europa.ec.fisheries.uvms.user.service.dao;

import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;
import eu.europa.ec.mare.usm.information.entity.OrganisationEntity;

import java.util.List;

public interface OrganisationDao {

    List<OrganisationChannelEntityId> findOrganizationByDataFlowAndEndpoint(String dataflow, String endpoint);

    List<OrganisationEntity> findOrganisations();
}
