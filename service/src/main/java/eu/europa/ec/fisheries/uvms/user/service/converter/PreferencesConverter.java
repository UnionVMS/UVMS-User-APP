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

import eu.europa.ec.mare.usm.information.domain.Preference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PreferencesConverter {


    /**
     * Information-Model
     * package eu.europa.ec.mare.usm.information.domain;
     * private Set<Preference> preferences;
     * <p>
     * user-model
     * package eu.europa.ec.fisheries.wsdl.user.types;
     * protected List<Preference> preference;
     */
    public static eu.europa.ec.fisheries.wsdl.user.types.Preferences convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.Preferences domainPreferences) {
        eu.europa.ec.fisheries.wsdl.user.types.Preferences typesPreferences = new eu.europa.ec.fisheries.wsdl.user.types.Preferences();
        List<eu.europa.ec.fisheries.wsdl.user.types.Preference> typesPreferencesList = typesPreferences.getPreference();
        Set<eu.europa.ec.mare.usm.information.domain.Preference> domainPreferencesSet = domainPreferences.getPreferences();
        for (Preference domainPreferenceElement : domainPreferencesSet) {
            eu.europa.ec.fisheries.wsdl.user.types.Preference typesPreferenceElement = PreferenceConverter.convertInformationModelToUserModel(domainPreferenceElement);
            typesPreferencesList.add(typesPreferenceElement);
        }
        return typesPreferences;
    }


    public static eu.europa.ec.mare.usm.information.domain.Preferences
    convertUserModelToInformationModel(eu.europa.ec.fisheries.wsdl.user.types.Preferences typesPreferences) {
        eu.europa.ec.mare.usm.information.domain.Preferences domainPreferences =
                new eu.europa.ec.mare.usm.information.domain.Preferences();
        Set<eu.europa.ec.mare.usm.information.domain.Preference> domainPreferencesSet = new HashSet<eu.europa.ec.mare.usm.information.domain.Preference>();
        domainPreferences.setPreferences(domainPreferencesSet);
        List<eu.europa.ec.fisheries.wsdl.user.types.Preference> typesPreferencesList = typesPreferences.getPreference();
        for (eu.europa.ec.fisheries.wsdl.user.types.Preference typesPreferenceElement : typesPreferencesList) {
            Preference domainPreferenceElement = PreferenceConverter.convertUserModelToInformationModel(typesPreferenceElement);
            domainPreferencesSet.add(domainPreferenceElement);
        }
        return domainPreferences;

    }
}