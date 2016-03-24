package com.pgrabarczyk.jira.worklog.action;

import com.atlassian.jira.bc.issue.comment.CommentService;
import com.atlassian.jira.bc.issue.worklog.WorklogService;
import com.atlassian.jira.config.FeatureManager;
import com.atlassian.jira.datetime.DateTimeFormatterFactory;
import com.atlassian.jira.issue.RendererManager;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutManager;
import com.atlassian.jira.security.roles.ProjectRoleManager;
import com.atlassian.jira.security.xsrf.RequiresXsrfCheck;
import com.atlassian.jira.user.util.UserUtil;
import com.atlassian.jira.util.JiraDurationUtils;
import com.atlassian.jira.web.FieldVisibilityManager;
import com.atlassian.jira.web.action.issue.CreateWorklog;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XCreateWorklog extends CreateWorklog {

	private static final long serialVersionUID = 2665262982560525050L;
	
	public XCreateWorklog(
			WorklogService worklogService,
			CommentService commentService,
			ProjectRoleManager projectRoleManager,
			JiraDurationUtils jiraDurationUtils,
			DateTimeFormatterFactory dateTimeFormatterFactory,
			FieldVisibilityManager fieldVisibilityManager,
			FieldLayoutManager fieldLayoutManager,
			RendererManager rendererManager,
			UserUtil userUtil,
			FeatureManager featureManager) {
		super(worklogService, commentService, projectRoleManager, jiraDurationUtils, dateTimeFormatterFactory, fieldVisibilityManager, fieldLayoutManager, rendererManager, userUtil, featureManager);
		log.debug("XCreateWorklog");
	}

	@Override
	@RequiresXsrfCheck
	public String doExecute() throws Exception {
		String superResult = super.doExecute();
		log.debug("super.doExecute: {}", superResult);
		if (NONE.equals(superResult)) {
			String messageToUser = myExtraLogic();
			return returnMsgToUser(getReturnUrl(), messageToUser, MessageType.ERROR, true, null);
		}
		return superResult;
	}

	private String myExtraLogic() {
		return "Here is message from my extra logic";
	}
}