package eu.europa.ec.fisheries.wsdl.user.module;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2016-07-11T11:14:06.907+02:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", name = "UserModulePortType")
@XmlSeeAlso({eu.europa.ec.fisheries.wsdl.user.types.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UserModulePortType {

    @WebMethod(operationName = "DeletePreference")
    @WebResult(name = "deletePreferenceResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public DeletePreferenceResponse deletePreference(
        @WebParam(partName = "body", name = "deletePreferenceRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        DeletePreferenceRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "UndeployApplication")
    public void undeployApplication(
        @WebParam(partName = "body", mode = WebParam.Mode.INOUT, name = "undeployApplicationRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        javax.xml.ws.Holder<UndeployApplicationRequest> body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "DeleteDataset")
    @WebResult(name = "deleteDatasetResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public DeleteDatasetResponse deleteDataset(
        @WebParam(partName = "body", name = "deleteDatasetRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        DeleteDatasetRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "FindOrganisations")
    @WebResult(name = "findOrganisationsResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public FindOrganisationsResponse findOrganisations(
        @WebParam(partName = "body", name = "findOrganisationsRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        FindOrganisationsRequest body
    ) throws FindOrganisationsFault;

    @WebMethod(operationName = "RedeployApplication")
    @WebResult(name = "redeployApplicationResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public RedeployApplicationResponse redeployApplication(
        @WebParam(partName = "body", name = "redeployApplicationRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        RedeployApplicationRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "GetUserContext")
    @WebResult(name = "getUserContextResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public GetUserContextResponse getUserContext(
        @WebParam(partName = "body", name = "getUserContextRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        GetUserContextRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "PutPreference")
    @WebResult(name = "putPreferenceResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public PutPreferenceResponse putPreference(
        @WebParam(partName = "body", name = "putPreferenceRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        PutPreferenceRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "UpdatePreference")
    @WebResult(name = "updatePreferenceResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public UpdatePreferenceResponse updatePreference(
        @WebParam(partName = "body", name = "updatePreferenceRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        UpdatePreferenceRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "Ping")
    @WebResult(name = "pingResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public PingResponse ping(
        @WebParam(partName = "body", name = "pingRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        PingRequest body
    );

    @WebMethod(operationName = "UpdateDataset")
    @WebResult(name = "updateDatasetResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public UpdateDatasetResponse updateDataset(
        @WebParam(partName = "body", name = "updateDatasetRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        UpdateDatasetRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "GetContactDetails")
    @WebResult(name = "getContactDetailResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public GetContactDetailResponse getContactDetails(
        @WebParam(partName = "body", name = "getContactDetailsRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        GetContactDetailsRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "CreateDataset")
    @WebResult(name = "createDatasetResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public CreateDatasetResponse createDataset(
        @WebParam(partName = "body", name = "createDatasetRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        CreateDatasetRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "GetDeploymentDescriptor")
    @WebResult(name = "getDeploymentDescriptorResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public GetDeploymentDescriptorResponse getDeploymentDescriptor(
        @WebParam(partName = "body", name = "getDeploymentDescriptorRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        GetDeploymentDescriptorRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "GetOrganisation")
    @WebResult(name = "getOrganisationResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public GetOrganisationResponse getOrganisation(
        @WebParam(partName = "body", name = "getOrganisationRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        GetOrganisationRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "DeployApplication")
    @WebResult(name = "deployApplicationResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public DeployApplicationResponse deployApplication(
        @WebParam(partName = "body", name = "deployApplicationRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        DeployApplicationRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "CreatePreference")
    @WebResult(name = "createPreferenceResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public CreatePreferenceResponse createPreference(
        @WebParam(partName = "body", name = "createPreferenceRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        CreatePreferenceRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "PutUserPreferences")
    @WebResult(name = "putUserPreferencesResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public PutUserPreferencesResponse putUserPreferences(
        @WebParam(partName = "body", name = "putUserPreferencesRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        PutUserPreferencesRequest body
    ) throws UserModuleFaultException;

    @WebMethod(operationName = "FindDatasets")
    @WebResult(name = "filterDatasetResponse", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu", partName = "body")
    public FilterDatasetResponse findDatasets(
        @WebParam(partName = "body", name = "filterDatasetRequest", targetNamespace = "module.user.wsdl.fisheries.ec.europa.eu")
        FilterDatasetRequest body
    ) throws UserModuleFaultException;
}
