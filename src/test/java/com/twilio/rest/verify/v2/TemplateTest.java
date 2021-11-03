/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class TemplateTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VERIFY.toString(),
                                          "/v2/Templates");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Template.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testListVerificationTemplatesResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"templates\": [{\"sid\": \"HJaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"Base Verification Template 2 with do not share\",\"translations\": {\"en\": {\"is_default_translation\": true,\"status\": \"approved\",\"locale\": \"en\",\"text\": \"Your {{friendly_name}} verification code is: {{code}}. Do not share this code with anyone.\",\"date_updated\": \"2021-07-29T20:38:28.759979905Z\",\"date_created\": \"2021-07-29T20:38:28.165602325Z\"}}}],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://verify.twilio.com/v2/Templates?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://verify.twilio.com/v2/Templates?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"templates\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Template.reader().read());
    }
}