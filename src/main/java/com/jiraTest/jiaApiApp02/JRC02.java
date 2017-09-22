package com.jiraTest.jiaApiApp02;

import java.io.IOException;
import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class JRC02 {
	final private String baseUrl = "http://syseng.pelco.org/tasks";
	private String username = "milton.t";
	private String password = "Welcome3";
	// final String jiraId = "VXINT-863";
	final String jiraId = "VMS-11336";

	public void getIssueDetails() throws Exception {
		System.out.println("print a specific issue's details");
		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		Issue issue = jiraRestClient.getIssueClient().getIssue(jiraId).claim();
		try {
			System.out.println(jiraId + " Issue Summary : " + issue.getSummary());
			System.out.println(jiraId + " Issue Priority : " + issue.getPriority().getName());
			System.out.println(jiraId + " Issue IssueType : " + issue.getIssueType().getName());
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

	public int getIssueCount() throws Exception {
		int tc = 0;

		final String jql = "assignee = aswathy.sukumaran AND status!=Open";
		// final Set<String> fields = new HashSet<String>();
		// fields.add("id");
		// fields.add("key");
		// int maxResults = 100;
		// int startAt = 0;
		// System.out.println("fields : " + fields.toString());

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// tc = jiraRestClient.getSearchClient().searchJql(jql, maxResults, startAt, fields).claim().getTotal();
			System.out.println("JQL : " + jql);
			System.out.println("Total : " + tc);
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
		return tc;
	}

	public int getIssueCountForCustomJql01() throws Exception {
		int tc = 0;

		final String jql =
				"issuetype = Bug AND reporter in (anu.john, praveena.sasikumar, Anamika.Radha, anildas.hridayadas) and createdDate >= '2017/06/01' ORDER BY created DESC";
		// final Set<String> fields = new HashSet<String>();
		// fields.add("id");
		// fields.add("key");
		// int maxResults = 100;
		// int startAt = 0;
		// System.out.println("fields : " + fields.toString());

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// tc = jiraRestClient.getSearchClient().searchJql(jql, maxResults, startAt, fields).claim().getTotal();
			System.out.println("JQL : " + jql);
			System.out.println("Total : " + tc);
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
		return tc;
	}

	public int getIssueCountForCustomJql02() throws Exception {
		int tc = 0;

		final String jql =
				"issuetype = Bug AND reporter in (anu.john, praveena.sasikumar, Anamika.Radha, anildas.hridayadas) and status = closed and resolution = 'Fixed/Complete' and updatedDate >= '2017/06/01'  ORDER BY created DESC";
		// final Set<String> fields = new HashSet<String>();
		// fields.add("id");
		// fields.add("key");
		// int maxResults = 100;
		// int startAt = 0;
		// System.out.println("fields : " + fields.toString());

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// tc = jiraRestClient.getSearchClient().searchJql(jql, maxResults, startAt, fields).claim().getTotal();
			System.out.println("JQL : " + jql);
			System.out.println("Total : " + tc);
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
		return tc;
	}

	public int getIssueCountForCustomJql03() throws Exception {
		int tc = 0;

		final String jql = "project = 'VMS Program' AND resolution = Unresolved ORDER BY issuetype ASC, priority DESC, 'Risk Priority Number' DESC";
		// final Set<String> fields = new HashSet<String>();
		// fields.add("id");
		// fields.add("key");
		// int maxResults = 100;
		// int startAt = 0;
		// System.out.println("fields : " + fields.toString());

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// tc = jiraRestClient.getSearchClient().searchJql(jql, maxResults, startAt, fields).claim().getTotal();
			System.out.println("JQL : " + jql);
			System.out.println("Total : " + tc);
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
		return tc;
	}

	public int getIssueCountForCustomJql04() throws Exception {
		int tc = 0;

		final String jql = "project = 'Vx : Core' AND resolution = Unresolved ORDER BY issuetype ASC, priority DESC, 'Risk Priority Number' DESC";

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// tc = jiraRestClient.getSearchClient().searchJql(jql, maxResults, startAt, fields).claim().getTotal();
			System.out.println("JQL : " + jql);
			System.out.println("Total : " + tc);
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
		return tc;
	}

	private int getIssueCountQ1(final String project, final int rpnLowerValue, final int rpnHigherValue, final String startDate, final String endDate)
			throws Exception {
		int tc = 0;

		final String jql = "project = '" + project + "' AND 'Risk Priority Number' >=" + rpnLowerValue + " AND 'Risk Priority Number' <=" + rpnHigherValue
				+ " AND createdDate>= '" + startDate + "' AND createdDate <= '" + endDate + "'  ORDER BY 'Risk Priority Number' DESC";

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
			// System.out.println("JQL : " + jql);
			// System.out.println("Total : " + tc);
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
		return tc;
	}

	private int getIssueCountQ2(final JiraRestClient jiraRestClient, final String project, final int rpnLowerValue, final int rpnHigherValue,
			final String startDate, final String endDate) throws Exception {
		int tc = 0;

		final String jql = "project = '" + project + "' AND 'Risk Priority Number' >=" + rpnLowerValue + " AND 'Risk Priority Number' <=" + rpnHigherValue
				+ " AND createdDate>= '" + startDate + "' AND createdDate <= '" + endDate + "'  ORDER BY 'Risk Priority Number' DESC";

		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tc;
	}

	private int getIssueCountQ3(final String project, final String product, final int rpnLowerValue, final int rpnHigherValue, final String startDate,
			final String endDate) throws Exception {
		int tc = 0;

		final String jql = "project = '" + project + "' AND 'Vx Products' = '" + product + "'   AND 'Risk Priority Number' >=" + rpnLowerValue
				+ " AND 'Risk Priority Number' <=" + rpnHigherValue + " AND createdDate>= '" + startDate + "' AND createdDate <= '" + endDate
				+ "' ORDER BY 'Risk Priority Number' DESC";

		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			tc = jiraRestClient.getSearchClient().searchJql(jql).claim().getTotal();
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
		return tc;
	}

	public void printProjectwisePriorityReportHeading() {
		System.out.println("Project\t\tPriority 01\tPriority 02\tPriority 03\tPriority 04\tStart Date\tEnd Date");
	}

	public void getProjectwisePriorityReport(final String project, final String startDate, final String endDate) throws Exception {
		int priority01 = getIssueCountQ1(project, 18, 25, startDate, endDate);
		int priority02 = getIssueCountQ1(project, 10, 17, startDate, endDate);
		int priority03 = getIssueCountQ1(project, 6, 9, startDate, endDate);
		int priority04 = getIssueCountQ1(project, 0, 5, startDate, endDate);

		System.out.println(project + "\t" + priority01 + "\t\t" + priority02 + "\t\t" + priority03 + "\t\t" + priority04 + "\t\t" + startDate + "\t" + endDate);
	}

	public void getProjectwisePriorityReports(final String project, final String startDate, final String endDate) throws Exception {
		JiraRestClient jiraRestClient = createJiraRestClient(baseUrl, username, password);
		try {
			int priority01 = getIssueCountQ2(jiraRestClient, project, 18, 25, startDate, endDate);
			int priority02 = getIssueCountQ2(jiraRestClient, project, 10, 17, startDate, endDate);
			int priority03 = getIssueCountQ2(jiraRestClient, project, 6, 9, startDate, endDate);
			int priority04 = getIssueCountQ2(jiraRestClient, project, 0, 5, startDate, endDate);

			System.out.println(
					project + "\t" + priority01 + "\t\t" + priority02 + "\t\t" + priority03 + "\t\t" + priority04 + "\t\t" + startDate + "\t" + endDate);
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

	public void printProjectwisePriorityReportHeading2() {
		System.out.println("DD By RPN\tPriority 01\tPriority 02\tPriority 03\tPriority 04\tStart Date\tEnd Date\tProject\t\tProduct");
	}

	public void getProductwiseVMSProgramPriorityReport(final String product, final String startDate, final String endDate) throws Exception {
		String project = "VMS Program";
		int priority01 = getIssueCountQ3(project, product, 18, 25, startDate, endDate);
		int priority02 = getIssueCountQ3(project, product, 10, 17, startDate, endDate);
		int priority03 = getIssueCountQ3(project, product, 6, 9, startDate, endDate);
		int priority04 = getIssueCountQ3(project, product, 0, 5, startDate, endDate);

		int ddByRpn = (8 * priority01) + (4 * priority02) + priority03;

		System.out.println(ddByRpn + "\t\t" + priority01 + "\t\t" + priority02 + "\t\t" + priority03 + "\t\t" + priority04 + "\t\t" + startDate + "\t" + endDate
				+ "\t" + project + "\t" + product);
	}

	private static JiraRestClient createJiraRestClient(String url, String username, String password) {
		final JiraRestClientFactory jiraRestClientFactory = new AsynchronousJiraRestClientFactory();

		return jiraRestClientFactory.createWithBasicHttpAuthentication(URI.create(url), username, password);
	}
}
