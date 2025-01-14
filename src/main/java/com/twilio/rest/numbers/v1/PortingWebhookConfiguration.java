/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.numbers.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class PortingWebhookConfiguration extends Resource {

    private static final long serialVersionUID = 164865478946260L;

    public static PortingWebhookConfigurationCreator creator() {
        return new PortingWebhookConfigurationCreator();
    }

    /**
     * Converts a JSON String into a PortingWebhookConfiguration object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return PortingWebhookConfiguration object represented by the provided JSON
     */
    public static PortingWebhookConfiguration fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(
                json,
                PortingWebhookConfiguration.class
            );
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a PortingWebhookConfiguration object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return PortingWebhookConfiguration object represented by the provided JSON
     */
    public static PortingWebhookConfiguration fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(
                json,
                PortingWebhookConfiguration.class
            );
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public static String toJson(Object object, ObjectMapper mapper) {
        try {
            return mapper.writeValueAsString(object);
        } catch (final JsonMappingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (JsonProcessingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final URI url;
    private final URI portInTargetUrl;
    private final URI portOutTargetUrl;
    private final List<String> notificationsOf;

    @JsonCreator
    private PortingWebhookConfiguration(
        @JsonProperty("url") final URI url,
        @JsonProperty("port_in_target_url") final URI portInTargetUrl,
        @JsonProperty("port_out_target_url") final URI portOutTargetUrl,
        @JsonProperty("notifications_of") final List<String> notificationsOf
    ) {
        this.url = url;
        this.portInTargetUrl = portInTargetUrl;
        this.portOutTargetUrl = portOutTargetUrl;
        this.notificationsOf = notificationsOf;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final URI getPortInTargetUrl() {
        return this.portInTargetUrl;
    }

    public final URI getPortOutTargetUrl() {
        return this.portOutTargetUrl;
    }

    public final List<String> getNotificationsOf() {
        return this.notificationsOf;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PortingWebhookConfiguration other = (PortingWebhookConfiguration) o;

        return (
            Objects.equals(url, other.url) &&
            Objects.equals(portInTargetUrl, other.portInTargetUrl) &&
            Objects.equals(portOutTargetUrl, other.portOutTargetUrl) &&
            Objects.equals(notificationsOf, other.notificationsOf)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            url,
            portInTargetUrl,
            portOutTargetUrl,
            notificationsOf
        );
    }
}