/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Serverless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.serverless.v1.service.environment;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;

public class LogReader extends Reader<Log> {

    private String pathServiceSid;
    private String pathEnvironmentSid;
    private String functionSid;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Long pageSize;

    public LogReader(
        final String pathServiceSid,
        final String pathEnvironmentSid
    ) {
        this.pathServiceSid = pathServiceSid;
        this.pathEnvironmentSid = pathEnvironmentSid;
    }

    public LogReader setFunctionSid(final String functionSid) {
        this.functionSid = functionSid;
        return this;
    }

    public LogReader setStartDate(final ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LogReader setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public LogReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Log> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Log> firstPage(final TwilioRestClient client) {
        String path =
            "/v1/Services/{ServiceSid}/Environments/{EnvironmentSid}/Logs";
        path =
            path.replace(
                "{" + "ServiceSid" + "}",
                this.pathServiceSid.toString()
            );
        path =
            path.replace(
                "{" + "EnvironmentSid" + "}",
                this.pathEnvironmentSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.SERVERLESS.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Log> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Log read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "logs",
            response.getContent(),
            Log.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Log> previousPage(
        final Page<Log> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.SERVERLESS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Log> nextPage(
        final Page<Log> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.SERVERLESS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Log> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (functionSid != null) {
            request.addQueryParam("FunctionSid", functionSid);
        }
        if (startDate != null) {
            request.addQueryParam(
                "StartDate",
                startDate.toInstant().toString()
            );
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
