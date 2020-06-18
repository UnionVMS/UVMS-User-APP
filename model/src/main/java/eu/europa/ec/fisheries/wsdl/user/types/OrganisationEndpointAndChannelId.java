
package eu.europa.ec.fisheries.wsdl.user.types;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganisationEndpointAndChannelId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationEndpointAndChannelId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="organisationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="endpointId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="channelId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationEndpointAndChannelId", propOrder = {
    "organisationId",
    "endpointId",
    "channelId"
})
public class OrganisationEndpointAndChannelId
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected long organisationId;
    protected long endpointId;
    protected long channelId;

    /**
     * Gets the value of the organisationId property.
     * 
     */
    public long getOrganisationId() {
        return organisationId;
    }

    /**
     * Sets the value of the organisationId property.
     * 
     */
    public void setOrganisationId(long value) {
        this.organisationId = value;
    }

    /**
     * Gets the value of the endpointId property.
     * 
     */
    public long getEndpointId() {
        return endpointId;
    }

    /**
     * Sets the value of the endpointId property.
     * 
     */
    public void setEndpointId(long value) {
        this.endpointId = value;
    }

    /**
     * Gets the value of the channelId property.
     * 
     */
    public long getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     */
    public void setChannelId(long value) {
        this.channelId = value;
    }

}
