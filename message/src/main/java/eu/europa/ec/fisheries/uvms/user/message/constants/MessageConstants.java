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
package eu.europa.ec.fisheries.uvms.user.message.constants;

public class MessageConstants {

    public static final String CONNECTION_FACTORY = "java:/ConnectionFactory";
    public static final String CONNECTION_TYPE = "javax.jms.MessageListener";
    public static final String DESTINATION_TYPE_QUEUE = "javax.jms.Queue";
    public static final String USER_MESSAGE_IN_QUEUE = "java:/jms/queue/UVMSUserEvent";
    public static final String USER_MESSAGE_IN_QUEUE_NAME = "UVMSUserEvent";
    public static final String USER_RESPONSE_QUEUE = "java:/jms/queue/UVMSUser";
    //public static final String QUEUE_DATASOURCE_INTERNAL = "java:/jms/queue/UVMSComponentModel"; //Internal db source 
    //public static final String QUEUE_DATASOURCE_INTEGRATION = "java:/jms/queue/UVMSIntegration"; //Integration source

}