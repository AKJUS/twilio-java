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

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class InsightsQuestionnairesQuestionCreator extends Creator<InsightsQuestionnairesQuestion>{
    private String categorySid;
    private String question;
    private String answerSetId;
    private Boolean allowNa;
    private String authorization;
    private String description;

    public InsightsQuestionnairesQuestionCreator(final String categorySid, final String question, final String answerSetId, final Boolean allowNa) {
        this.categorySid = categorySid;
        this.question = question;
        this.answerSetId = answerSetId;
        this.allowNa = allowNa;
    }

    public InsightsQuestionnairesQuestionCreator setCategorySid(final String categorySid){
        this.categorySid = categorySid;
        return this;
    }
    public InsightsQuestionnairesQuestionCreator setQuestion(final String question){
        this.question = question;
        return this;
    }
    public InsightsQuestionnairesQuestionCreator setAnswerSetId(final String answerSetId){
        this.answerSetId = answerSetId;
        return this;
    }
    public InsightsQuestionnairesQuestionCreator setAllowNa(final Boolean allowNa){
        this.allowNa = allowNa;
        return this;
    }
    public InsightsQuestionnairesQuestionCreator setAuthorization(final String authorization){
        this.authorization = authorization;
        return this;
    }
    public InsightsQuestionnairesQuestionCreator setDescription(final String description){
        this.description = description;
        return this;
    }

    @Override
    public InsightsQuestionnairesQuestion create(final TwilioRestClient client){
        String path = "/v1/Insights/QualityManagement/Questions";

        path = path.replace("{"+"CategorySid"+"}", this.categorySid.toString());
        path = path.replace("{"+"Question"+"}", this.question.toString());
        path = path.replace("{"+"AnswerSetId"+"}", this.answerSetId.toString());
        path = path.replace("{"+"AllowNa"+"}", this.allowNa.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            path
        );
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InsightsQuestionnairesQuestion creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InsightsQuestionnairesQuestion.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (categorySid != null) {
            request.addPostParam("CategorySid", categorySid);
    
        }
        if (question != null) {
            request.addPostParam("Question", question);
    
        }
        if (answerSetId != null) {
            request.addPostParam("AnswerSetId", answerSetId);
    
        }
        if (allowNa != null) {
            request.addPostParam("AllowNa", allowNa.toString());
    
        }
        if (description != null) {
            request.addPostParam("Description", description);
    
        }
    }
    private void addHeaderParams(final Request request) {
        if (authorization != null) {
            request.addHeaderParam("Authorization", authorization);

        }
    }
}
