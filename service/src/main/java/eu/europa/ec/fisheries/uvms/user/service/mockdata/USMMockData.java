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
package eu.europa.ec.fisheries.uvms.user.service.mockdata;

import eu.europa.ec.mare.usm.information.domain.deployment.Application;
import eu.europa.ec.mare.usm.information.domain.deployment.Dataset;
import eu.europa.ec.fisheries.wsdl.user.types.Organisation;
import eu.europa.ec.fisheries.wsdl.user.types.Channel;
import eu.europa.ec.fisheries.wsdl.user.types.EndPoint;

public class USMMockData {

    public static Application generateMockApplication() {
        // TODO Auto-generated method stub
        
        Application application = new Application();
        
        application.setName("TEST USER UNIONVMS");
        application.setDescription("TEST USER UNIONVMS DESCRIPTION");
        application.setParent("TEST USER UNIONVMS PARENT");
        
        Dataset dataset = new Dataset();
        dataset.setName("TEST USER UNIONVMS DATASET NAME");
        dataset.setDescription("TEST USER UNIONVMS DATASET DESCRIPTION");
        dataset.setCategory("TEST USER UNIONVMS DATASET CATEGORY");
        dataset.setDiscriminator("TEST USER UNIONVMS DATASET DISCRIMINATOR");
        
        application.getDataset().add(dataset);
        
        return application;
    }


    
}