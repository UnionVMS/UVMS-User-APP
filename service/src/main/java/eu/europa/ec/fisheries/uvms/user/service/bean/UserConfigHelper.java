package eu.europa.ec.fisheries.uvms.user.service.bean;

import eu.europa.ec.fisheries.uvms.config.constants.ConfigHelper;
import eu.europa.ec.fisheries.uvms.user.service.config.ParameterKey;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class UserConfigHelper implements ConfigHelper {

    @PersistenceContext
    protected EntityManager em;

    private final static String CONFIG_PU = "internalPU";

    @Override
    public List<String> getAllParameterKeys() {
        List<String> keys = new ArrayList<String>();
        for (ParameterKey parameterKey : ParameterKey.values()) {
            keys.add(parameterKey.getKey());
        }

        return keys;
    }

    @Override
    public String getModuleName() {
        return CONFIG_PU;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

