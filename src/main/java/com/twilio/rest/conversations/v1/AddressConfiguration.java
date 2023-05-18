/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AddressConfiguration extends Resource {
    private static final long serialVersionUID = 162346024858734L;

    public static AddressConfigurationCreator creator(final AddressConfiguration.Type type, final String address){
        return new AddressConfigurationCreator(type, address);
    }

    public static AddressConfigurationDeleter deleter(final String pathSid){
        return new AddressConfigurationDeleter(pathSid);
    }

    public static AddressConfigurationFetcher fetcher(final String pathSid){
        return new AddressConfigurationFetcher(pathSid);
    }

    public static AddressConfigurationReader reader(){
        return new AddressConfigurationReader();
    }

    public static AddressConfigurationUpdater updater(final String pathSid){
        return new AddressConfigurationUpdater(pathSid);
    }

    /**
    * Converts a JSON String into a AddressConfiguration object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return AddressConfiguration object represented by the provided JSON
    */
    public static AddressConfiguration fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AddressConfiguration.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a AddressConfiguration object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return AddressConfiguration object represented by the provided JSON
    */
    public static AddressConfiguration fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AddressConfiguration.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum AutoCreationType {
        WEBHOOK("webhook"),
        STUDIO("studio"),
        DEFAULT("default");

        private final String value;

        private AutoCreationType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static AutoCreationType forValue(final String value) {
            return Promoter.enumFromString(value, AutoCreationType.values());
        }
    }
    public enum Method {
        GET("GET"),
        POST("POST");

        private final String value;

        private Method(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Method forValue(final String value) {
            return Promoter.enumFromString(value, Method.values());
        }
    }
    public enum Type {
        SMS("sms"),
        WHATSAPP("whatsapp"),
        MESSENGER("messenger"),
        GBM("gbm");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String type;
    private final String address;
    private final String friendlyName;
    private final Map<String, Object> autoCreation;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final String addressCountry;

    @JsonCreator
    private AddressConfiguration(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("type")
        final String type,

        @JsonProperty("address")
        final String address,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("auto_creation")
        final Map<String, Object> autoCreation,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("address_country")
        final String addressCountry
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.type = type;
        this.address = address;
        this.friendlyName = friendlyName;
        this.autoCreation = autoCreation;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.addressCountry = addressCountry;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getType() {
            return this.type;
        }
        public final String getAddress() {
            return this.address;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final Map<String, Object> getAutoCreation() {
            return this.autoCreation;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final String getAddressCountry() {
            return this.addressCountry;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AddressConfiguration other = (AddressConfiguration) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(type, other.type) &&  Objects.equals(address, other.address) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(autoCreation, other.autoCreation) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(addressCountry, other.addressCountry)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, type, address, friendlyName, autoCreation, dateCreated, dateUpdated, url, addressCountry);
    }

}

