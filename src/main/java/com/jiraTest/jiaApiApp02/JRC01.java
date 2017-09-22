package com.jiraTest.jiaApiApp02;

import java.io.IOException;
import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class JRC01 {
	private String url = "https://milton.atlassian.net";
	private String username = "dm.inbox.me@gmail.com";
	private String password = "abcd@123";
	private String issueKey = "SAM-1";

	public void printIssue() throws Exception {
		JiraRestClient jiraRestClient = createJiraRestClient(url, username, password);
		Issue issue = jiraRestClient.getIssueClient().getIssue(issueKey).claim();
		try {
			System.out.println(issueKey + " Issue Summary : " + issue.getSummary());
			System.out.println(issueKey + " Issue Priority : " + issue.getPriority().getName());
			System.out.println(issueKey + " Issue IssueType : " + issue.getIssueType().getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// cleanup the restClient
			try {
				jiraRestClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static JiraRestClient createJiraRestClient(String url, String username, String password) {
		final JiraRestClientFactory jiraRestClientFactory = new AsynchronousJiraRestClientFactory();

		return jiraRestClientFactory.createWithBasicHttpAuthentication(URI.create(url), username, password);
	}
}
