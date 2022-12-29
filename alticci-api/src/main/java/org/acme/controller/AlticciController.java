package org.acme.controller;

import org.acme.BaseApi;
import org.acme.model.AlticciResult;
import org.acme.service.AlticciService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Param;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(BaseApi.ALTICCI_URL)
@Tag(name = "Alticci Service", description = "All operations in the context of Alticci Sequence")
public class AlticciController {

    @Inject
    private AlticciService alticciService;

    private static final Logger LOGGER = Logger.getLogger(AlticciController.class);

    @GET
    @Path("{n}")
    @Operation(summary = "Compute Alticci Sequence")
    @Produces(MediaType.APPLICATION_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Success",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = AlticciResult.class)
            )
    )
    public RestResponse<AlticciResult> calculate(@Parameter(description = "Number to be computed") @PathParam("n")Long n) {
        LOGGER.info("Starting Calculation");

        //No definition on how the responses must be given, so i decided to return the object with one value
        //You can run the test to validate de sequence given N value
        AlticciResult alticciResult = new AlticciResult(alticciService.calculateSequence(n));

        LOGGER.info("Calculation Done");
        return RestResponse.ok(alticciResult);
    }
}