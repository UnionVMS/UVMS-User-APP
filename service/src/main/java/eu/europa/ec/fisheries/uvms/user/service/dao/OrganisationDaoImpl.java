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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;

import java.util.List;

@ApplicationScoped
public class OrganisationDaoImpl implements OrganisationDao{

    private EntityManager em;

    @Inject
    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Default constructor for frameworks.
     */
    @SuppressWarnings("unused")
    OrganisationDaoImpl() {
        // NOOP
    }

    @Override
    public List<OrganisationChannelEntityId> findOrganizationByDataFlowAndEndpointName(String dataFlow, String endpointName) {
        TypedQuery<OrganisationChannelEntityId> query = em.createQuery(
             "SELECT new eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId(c.id, c.endPoint.id, c.endPoint.organisation.id) " +
                "FROM ChannelEntity c " +
                "WHERE c.dataflow = :dataflow " +
                "AND c.endPoint.name = :name", OrganisationChannelEntityId.class);
        query.setParameter("dataflow",dataFlow);
        query.setParameter("name",endpointName);
        return query.getResultList();
    }

    @Override
    public List<OrganisationEntity> findOrganisations() {
        CriteriaQuery<OrganisationEntity> criteria = em.getCriteriaBuilder().createQuery(OrganisationEntity.class);

        criteria.distinct(true)
                .from(OrganisationEntity.class)
                .fetch("endPointList", JoinType.LEFT);

        return em.createQuery( criteria ).getResultList();
    }
}
