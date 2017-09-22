package com.jiraTest.jiaApiApp02;

import java.net.URI;
import java.util.Optional;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

public class JRC {
	final String url = "https://milton.atlassian.net";
	final String username = "dm.inbox.me@gmail.com";
	final String password = "abcd@123";
	final String jiraId = "SAM-1";

	public Issue getIssue(String issueKey) throws Exception {
		// final URI jiraServerUri = new URI("https://jira-domain");
		final URI jiraServerUri = new URI(url);
		final JiraRestClient restClient = new AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(jiraServerUri, username, password);
		Promise issuePromise = restClient.getIssueClient().getIssue(issueKey);
		return Optional.ofNullable((Issue) issuePromise.claim()).orElseThrow(() -> new Exception("No such issue"));
	}

}
