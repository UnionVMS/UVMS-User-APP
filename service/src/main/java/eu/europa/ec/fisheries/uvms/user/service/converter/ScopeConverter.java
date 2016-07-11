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
package eu.europa.ec.fisheries.uvms.user.service.converter;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.europa.ec.fisheries.wsdl.user.types.Dataset;
import eu.europa.ec.mare.usm.information.domain.DataSet;

public class ScopeConverter {
	
	/*
	Information-Model
	package eu.europa.ec.mare.usm.information.domain;
	  private String scopeName;
	  private Date activeFrom;
	  private Date activeTo;
	  private Date dataFrom;
	  private Date dataTo;
	  private Set<DataSet> datasets;
	
	
	user-model
	eu.europa.ec.fisheries.wsdl.user.types;
	    protected String scopeName;	
	    protected XMLGregorianCalendar activeFrom;	
	    protected XMLGregorianCalendar activeTo;	   
	    protected XMLGregorianCalendar dataFrom;	   
	    protected XMLGregorianCalendar dataTo;
	    protected List<Dataset> dataset;
	
	
	
	*/
	
	
	public static eu.europa.ec.fisheries.wsdl.user.types.Scope
	    convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.Scope domainScope)
	    {
		eu.europa.ec.fisheries.wsdl.user.types.Scope typesScope = 
				new eu.europa.ec.fisheries.wsdl.user.types.Scope();
		
		typesScope.setScopeName(domainScope.getScopeName());
		
		typesScope.setActiveFrom(
				convertDateToXMLGregorianCalendar(domainScope.getActiveFrom()));
		typesScope.setActiveTo(
				convertDateToXMLGregorianCalendar(domainScope.getActiveTo()));
		typesScope.setDataFrom(
				convertDateToXMLGregorianCalendar(domainScope.getDataFrom()));
		typesScope.setDataTo(
				convertDateToXMLGregorianCalendar(domainScope.getDataTo()));
		
		/*Set<eu.europa.ec.fisheries.wsdl.user.types.Dataset> typesDatasets =
				new HashSet<eu.europa.ec.fisheries.wsdl.user.types.Dataset>();*/
		Set<eu.europa.ec.mare.usm.information.domain.DataSet> domainDatasets = 
				domainScope.getDatasets();
		if (domainDatasets != null) {
	        Iterator<eu.europa.ec.mare.usm.information.domain.DataSet> iterator =
	                domainDatasets.iterator();
	        while(iterator.hasNext()) {
	            eu.europa.ec.mare.usm.information.domain.DataSet domainDatasetElement = iterator.next();
	            eu.europa.ec.fisheries.wsdl.user.types.Dataset typesDatasetElement = DatasetConverter.convertDomainInformationModelToUserModel(domainDatasetElement);
	            /*typesDatasets.add(typesDatasetElement);*/
	            typesScope.getDataset().add(typesDatasetElement);
	        }		    
		}
	    
	    return typesScope;

}
	
	public static eu.europa.ec.mare.usm.information.domain.Scope 
	   convertUserModelToInformationModel(eu.europa.ec.fisheries.wsdl.user.types.Scope typesScope)
	   {
		 eu.europa.ec.mare.usm.information.domain.Scope domainScope = 
				 new  eu.europa.ec.mare.usm.information.domain.Scope();
		 
		 domainScope.setScopeName(typesScope.getScopeName());
		 domainScope.setActiveFrom(convertXMLGregorianCalendarToDate(typesScope.getActiveFrom()));
		 domainScope.setActiveTo(convertXMLGregorianCalendarToDate(typesScope.getActiveTo()));
		 domainScope.setDataFrom(convertXMLGregorianCalendarToDate(typesScope.getDataFrom()));
		 domainScope.setDataTo(convertXMLGregorianCalendarToDate(typesScope.getDataTo()));
		 
		 Set<eu.europa.ec.mare.usm.information.domain.DataSet> domainDatasets = new HashSet<eu.europa.ec.mare.usm.information.domain.DataSet>();
		 domainScope.setDatasets(domainDatasets);
		 List<eu.europa.ec.fisheries.wsdl.user.types.Dataset> typesDatasets = 
				 typesScope.getDataset();
		 Iterator<eu.europa.ec.fisheries.wsdl.user.types.Dataset> iterator = 
				 typesDatasets.iterator();
		 while(iterator.hasNext())
		 {
			 eu.europa.ec.fisheries.wsdl.user.types.Dataset typesDatasetElement = iterator.next();
			 eu.europa.ec.mare.usm.information.domain.DataSet domainDatasetElement = DatasetConverter.convertUserModelToDomainInformationModel(typesDatasetElement);
			 domainDatasets.add(domainDatasetElement);
		 }
		 
		 return domainScope;
	   }
	
	public static XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date d)
	{
		if(d==null)
			return null;
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
		XMLGregorianCalendar xmlDate;
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			xmlDate = null;
		}
		
		return xmlDate;
	}
	
	public static Date convertXMLGregorianCalendarToDate(XMLGregorianCalendar x)
	{
		if(x==null)
			return null;
		return x.toGregorianCalendar().getTime();
	}
	

	
	
}