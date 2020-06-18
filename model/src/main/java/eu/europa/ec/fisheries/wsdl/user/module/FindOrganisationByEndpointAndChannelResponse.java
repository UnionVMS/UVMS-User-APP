
package eu.europa.ec.fisheries.wsdl.user.module;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.fisheries.wsdl.user.types.OrganisationEndpointAndChannelId;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{types.user.wsdl.fisheries.ec.europa.eu}OrganisationEndpointAndChannelId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result"
})
@XmlRootElement(name = "findOrganisationByEndpointAndChannelResponse")
public class FindOrganisationByEndpointAndChannelResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected OrganisationEndpointAndChannelId result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationEndpointAndChannelId }
     *     
     */
    public OrganisationEndpointAndChannelId getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationEndpointAndChannelId }
     *     
     */
    public void setResult(OrganisationEndpointAndChannelId value) {
        this.result = value;
    }

}
