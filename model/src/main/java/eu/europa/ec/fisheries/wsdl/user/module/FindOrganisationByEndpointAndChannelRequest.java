
package eu.europa.ec.fisheries.wsdl.user.module;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{module.user.wsdl.fisheries.ec.europa.eu}UserBaseRequest">
 *       &lt;sequence>
 *         &lt;element name="endpointName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelDataFlow" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "endpointName",
    "channelDataFlow"
})
@XmlRootElement(name = "findOrganisationByEndpointAndChannelRequest")
public class FindOrganisationByEndpointAndChannelRequest
    extends UserBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String endpointName;
    @XmlElement(required = true)
    protected String channelDataFlow;

    /**
     * Gets the value of the endpointName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpointName() {
        return endpointName;
    }

    /**
     * Sets the value of the endpointName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpointName(String value) {
        this.endpointName = value;
    }

    /**
     * Gets the value of the channelDataFlow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelDataFlow() {
        return channelDataFlow;
    }

    /**
     * Sets the value of the channelDataFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelDataFlow(String value) {
        this.channelDataFlow = value;
    }

}
