package com.ibm.websphere.samples.daytrader.web.prims.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/jaxrs")
@Path("sync")
public class JAXRSSyncService {

  /**
   * note: this should be the basic code path for jaxrs process
   * @param input
   * @return
   */
  @GET
  @Path("echoText")   
  public String echoString(@QueryParam("input") String input) {
    return input;
  }

  /**
   *  note: this code path involves JSON marshaller & un-marshaller based on basic code path
   * @param p  Person Object
   * @return  Person Object
   */
  @POST
  @Path("echoJSON")
  @Produces(value={MediaType.APPLICATION_JSON})
  @Consumes(value={MediaType.APPLICATION_JSON})
  public TestJSONObject echoObject(TestJSONObject jsonObject) {
    return jsonObject;
  }

  @POST
  @Path("echoXML")
  @Produces(value={MediaType.TEXT_XML,MediaType.APPLICATION_XML})
  @Consumes(value={MediaType.TEXT_XML,MediaType.APPLICATION_XML})
  public XMLObject echoObject(XMLObject xmlObject) {
    return xmlObject;
  }
}

