
package eu.europa.ec.fisheries.wsdl.user.module;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.fisheries.wsdl.user.types.EndPoint;


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
 *         &lt;element name="endpoint" type="{types.user.wsdl.fisheries.ec.europa.eu}EndPoint"/>
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
    "endpoint"
})
@XmlRootElement(name = "findEndpointResponse")
public class FindEndpointResponse
    extends UserBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected EndPoint endpoint;

    /**
     * Gets the value of the endpoint property.
     * 
     * @return
     *     possible object is
     *     {@link EndPoint }
     *     
     */
    public EndPoint getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the value of the endpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndPoint }
     *     
     */
    public void setEndpoint(EndPoint value) {
        this.endpoint = value;
    }

}
