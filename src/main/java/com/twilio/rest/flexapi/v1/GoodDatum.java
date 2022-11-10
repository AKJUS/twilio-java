/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class GoodDatum extends Resource {
    private static final long serialVersionUID = 3143637009434L;

    public static GoodDatumCreator creator(){
        return new GoodDatumCreator();
    }





    /**
    * Converts a JSON String into a GoodDatum object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return GoodDatum object represented by the provided JSON
    */
    public static GoodDatum fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, GoodDatum.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a GoodDatum object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return GoodDatum object represented by the provided JSON
    */
    public static GoodDatum fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, GoodDatum.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String workspaceId;
    private final String sessionExpiry;
    private final String sessionId;
    private final URI url;

    @JsonCreator
    private GoodDatum(
        @JsonProperty("workspace_id")
        final String workspaceId,

        @JsonProperty("session_expiry")
        final String sessionExpiry,

        @JsonProperty("session_id")
        final String sessionId,

        @JsonProperty("url")
        final URI url
    ) {
        this.workspaceId = workspaceId;
        this.sessionExpiry = sessionExpiry;
        this.sessionId = sessionId;
        this.url = url;
    }

        public final String getWorkspaceId() {
            return this.workspaceId;
        }
        public final String getSessionExpiry() {
            return this.sessionExpiry;
        }
        public final String getSessionId() {
            return this.sessionId;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodDatum other = (GoodDatum) o;

        return Objects.equals(workspaceId, other.workspaceId) &&  Objects.equals(sessionExpiry, other.sessionExpiry) &&  Objects.equals(sessionId, other.sessionId) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workspaceId, sessionExpiry, sessionId, url);
    }

}

