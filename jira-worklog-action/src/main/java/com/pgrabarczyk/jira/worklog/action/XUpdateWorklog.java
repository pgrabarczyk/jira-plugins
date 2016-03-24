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
import com.atlassian.jira.web.action.issue.UpdateWorklog;
import com.pgrabarczyk.jira.worklog.MyExtraLogicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XUpdateWorklog extends UpdateWorklog {

	private static final long serialVersionUID = 8432551294556579352L;

	public XUpdateWorklog(
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
		super(worklogService, commentService, projectRoleManager, jiraDurationUtils, dateTimeFormatterFactory,
				fieldVisibilityManager, fieldLayoutManager, rendererManager, userUtil, featureManager);
	}
	
	@Override
	@RequiresXsrfCheck
	public String doExecute() throws Exception {
		String superResult = super.doExecute();
		log.debug("super.doExecute: {}", superResult);
		if (NONE.equals(superResult)) {
			String messageToUser = MyExtraLogicService.myExtraLogic();
			return returnMsgToUser(getReturnUrl(), messageToUser, MessageType.ERROR, true, null);
		}
		return superResult;
	}
}
