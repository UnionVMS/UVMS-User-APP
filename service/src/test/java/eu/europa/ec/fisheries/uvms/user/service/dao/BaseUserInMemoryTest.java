/*
 Developed by the European Commission - Directorate General for Maritime Affairs and Fisheries @ European Union, 2015-2016.

 This file is part of the Integrated Fisheries Data Management (IFDM) Suite. The IFDM Suite is free software: you can redistribute it
 and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of
 the License, or any later version. The IFDM Suite is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 details. You should have received a copy of the GNU General Public License along with the IFDM Suite. If not, see <http://www.gnu.org/licenses/>.
 */

package eu.europa.ec.fisheries.uvms.user.service.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public abstract class BaseUserInMemoryTest extends BaseDAOTest {


    static final Operation INSERT_ENDPOINT = sequenceOf(insertInto("usm.end_point_t")
            .columns("end_point_id","name","description","uri","status","organisation_id","created_by","created_on","modified_by","modified_on","e_mail")
            .values(0,"FLUX.EEC","European Commission main FLUX node","http://main.flux.eu/","E",0,"USM", d("20200101"),null,null,null)
            .values(1,"FLUX.EEC_backup","European Commission backup FLUX node","http://backup.flux.eu/","D",0,"USM",d("20200101"),"USM",d("20200101"),null)
            .values(2,"FLUX.FRA","Main FLUX node for France","http://main.flux.fr/","E",3,"USM",d("20200101"),null,null,null)
            .values(3,"FLUX.FRA_backup","Backup FLUX node for France","http://backup.flux.fr/","D",3,"USM",d("20200101"),"USM",d("20200101"),null)
            .values(4,"FLUX.GRC","Main FLUX node for Greece","http://main.flux.gr/","E",4,"USM",d("20200101"),null,null,null)
            .values(5,"FLUX.GRC_backup","Backup FLUX node for Greece","http://backup.flux.gr/","D",4,"USM",d("20200101"),"USM",d("20200101"),null)
            .build());

    static final Operation INSERT_CHANNEL = sequenceOf(insertInto("usm.channel_t")
            .columns("channel_id","dataflow","service","priority","end_point_id","created_by","created_on","modified_by","modified_on")
            .values(1L,"dataflow","service",1,5,"USM", d("20200101"),null,null)
            .build());

    static final Operation INSERT_ORGANIZATION = sequenceOf(insertInto("usm.organisation_t")
            .columns("organisation_id","name","isoa3code","description","status","parent_id","created_by","created_on","modified_by","modified_on","e_mail")
            .values(0,"EC","EEC","European Commission","E",null,"USM",d("20200101"),null,null,null)
            .values(1,"DG-MARE","EEC","European Commission DG-MARE","E",0,"USM",d("20200101"),null,null,null)
            .values(2,"Unit-D4","EEC","DG-MARE Unit D4","D",1,"USM",d("20200101"),null,null,null)
            .values(3,"FRA","FRA","French ministry of agriculture","E",null,"USM",d("20200101"),null,null,null)
            .values(4,"GRC","GRC","Greek ministry of agriculture","E",null,"USM",d("20200101"),null,null,null)
            .build());


    @Override protected String getSchema() {
        return "usm";
    }

    @Override protected String getPersistenceUnitName() {
        return "testPU";
    }

    static Date d(String s) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
