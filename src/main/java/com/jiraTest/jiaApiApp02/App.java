package com.jiraTest.jiaApiApp02;

import java.sql.Time;
import java.util.Timer;

import org.joda.time.DateTimeUtils;

/**
 * Hello JIRA!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello JIRA!");

		try {
			// Sample 1
			/*
			 * JRC01 jiraBot = new JRC01(); jiraBot.printIssue();
			 */

			// Sample 2

			JRC02 jiraBot = new JRC02();
			// jiraBot.getIssueDetails();

			// System.out.println("Issue Count - " + jiraBot.getIssueCount());
			// System.out.println("Issue Count - " + jiraBot.getIssueCountForCustomJql01());
			// System.out.println("Issue Count - " + jiraBot.getIssueCountForCustomJql02());
			// System.out.println("Issue Count - " + jiraBot.getIssueCountForCustomJql03());
			// System.out.println("Issue Count - " + jiraBot.getIssueCountForCustomJql04());

			String startDate1 = "2017/05/01";
			String endDate1 = "2017/05/31";
			String startDate2 = "2017/04/01";
			String endDate2 = "2017/04/30";

			// jiraBot.printProjectwisePriorityReportHeading();
			// jiraBot.getProjectwisePriorityReport("VMS Program", startDate1, endDate1);
			// jiraBot.getProjectwisePriorityReport("VMS Program", startDate2, endDate2);
			// jiraBot.getProjectwisePriorityReport("Vx : Pro", startDate1, endDate1);
			// jiraBot.getProjectwisePriorityReport("Vx : Pro", startDate2, endDate2);
			// jiraBot.getProjectwisePriorityReport("VX : Toolbox", startDate1, endDate1);
			// jiraBot.getProjectwisePriorityReport("VX : Toolbox", startDate2, endDate2);

			long t1 = DateTimeUtils.currentTimeMillis();
			jiraBot.printProjectwisePriorityReportHeading2();
			jiraBot.getProductwiseVMSProgramPriorityReport("Media Storage Manager", startDate1, endDate1);
			jiraBot.getProductwiseVMSProgramPriorityReport("Media Storage Manager", startDate2, endDate2);
			jiraBot.getProductwiseVMSProgramPriorityReport("Core", startDate1, endDate1);
			jiraBot.getProductwiseVMSProgramPriorityReport("Core", startDate2, endDate2);
			jiraBot.getProductwiseVMSProgramPriorityReport("VxToolBox", startDate1, endDate1);
			jiraBot.getProductwiseVMSProgramPriorityReport("VxToolBox", startDate2, endDate2);
			jiraBot.getProductwiseVMSProgramPriorityReport("VxPro", startDate1, endDate1);
			jiraBot.getProductwiseVMSProgramPriorityReport("VxPro", startDate2, endDate2);
			jiraBot.getProductwiseVMSProgramPriorityReport("Admin Portal", startDate1, endDate1);
			jiraBot.getProductwiseVMSProgramPriorityReport("Admin Portal", startDate2, endDate2);

			long t2 = DateTimeUtils.currentTimeMillis();
			System.out.println("Took - " + ((t2 - t1) / 1000) + " Seconds");
		} catch (Exception e) {
			System.out.println("EXCEPTION " + e.getMessage());
		}
	}
}
