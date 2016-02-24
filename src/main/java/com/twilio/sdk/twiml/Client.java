package com.twilio.sdk.twiml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement
public class Client extends TwiML {

    @JacksonXmlProperty(isAttribute = true)
    private final String method;

    @JacksonXmlProperty(isAttribute = true)
    private final String url;

    @JacksonXmlText
    private final String name;

    private Client(String method, String url, String name) {
        this.method = method;
        this.url = url;
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private String method;
        private String url;
        private String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Client build() {
            return new Client(method, url, name);
        }
    }
}
