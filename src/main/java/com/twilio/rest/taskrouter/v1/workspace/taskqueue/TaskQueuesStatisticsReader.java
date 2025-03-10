/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

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

public class TaskQueuesStatisticsReader extends Reader<TaskQueuesStatistics> {

    private String pathWorkspaceSid;
    private ZonedDateTime endDate;
    private String friendlyName;
    private Integer minutes;
    private ZonedDateTime startDate;
    private String taskChannel;
    private String splitByWaitTime;
    private Long pageSize;

    public TaskQueuesStatisticsReader(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public TaskQueuesStatisticsReader setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public TaskQueuesStatisticsReader setFriendlyName(
        final String friendlyName
    ) {
        this.friendlyName = friendlyName;
        return this;
    }

    public TaskQueuesStatisticsReader setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    public TaskQueuesStatisticsReader setStartDate(
        final ZonedDateTime startDate
    ) {
        this.startDate = startDate;
        return this;
    }

    public TaskQueuesStatisticsReader setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    public TaskQueuesStatisticsReader setSplitByWaitTime(
        final String splitByWaitTime
    ) {
        this.splitByWaitTime = splitByWaitTime;
        return this;
    }

    public TaskQueuesStatisticsReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<TaskQueuesStatistics> read(
        final TwilioRestClient client
    ) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<TaskQueuesStatistics> firstPage(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/TaskQueues/Statistics";
        path =
            path.replace(
                "{" + "WorkspaceSid" + "}",
                this.pathWorkspaceSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<TaskQueuesStatistics> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "TaskQueuesStatistics read failed: Unable to connect to server"
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
            "task_queues_statistics",
            response.getContent(),
            TaskQueuesStatistics.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<TaskQueuesStatistics> previousPage(
        final Page<TaskQueuesStatistics> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<TaskQueuesStatistics> nextPage(
        final Page<TaskQueuesStatistics> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<TaskQueuesStatistics> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }
        if (startDate != null) {
            request.addQueryParam(
                "StartDate",
                startDate.toInstant().toString()
            );
        }

        if (taskChannel != null) {
            request.addQueryParam("TaskChannel", taskChannel);
        }
        if (splitByWaitTime != null) {
            request.addQueryParam("SplitByWaitTime", splitByWaitTime);
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
