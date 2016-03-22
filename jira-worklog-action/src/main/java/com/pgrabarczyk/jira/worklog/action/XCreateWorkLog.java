package com.pgrabarczyk.jira.worklog.action;

import com.atlassian.jira.bc.issue.comment.CommentService;
import com.atlassian.jira.bc.issue.worklog.WorklogService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.FeatureManager;
import com.atlassian.jira.datetime.DateTimeFormatterFactory;
import com.atlassian.jira.issue.RendererManager;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutManager;
import com.atlassian.jira.security.roles.ProjectRoleManager;
import com.atlassian.jira.user.util.UserUtil;
import com.atlassian.jira.util.JiraDurationUtils;
import com.atlassian.jira.web.FieldVisibilityManager;
import com.atlassian.jira.web.action.issue.CreateWorklog;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XCreateWorkLog extends CreateWorklog {

	private static final long serialVersionUID = 2665262982560525050L;
	
	public XCreateWorkLog(
			WorklogService worklogService,
			CommentService commentService,
			ProjectRoleManager projectRoleManager,
//			JiraDurationUtils jiraDurationUtils,
			DateTimeFormatterFactory dateTimeFormatterFactory,
			FieldVisibilityManager fieldVisibilityManager,
			FieldLayoutManager fieldLayoutManager,
			RendererManager rendererManager,
			UserUtil userUtil,
			FeatureManager featureManager) {
		super(worklogService, commentService, projectRoleManager, ComponentAccessor.getComponent(JiraDurationUtils.class),
				dateTimeFormatterFactory, fieldVisibilityManager, fieldLayoutManager, rendererManager, userUtil, featureManager);
		log.debug("XCreateWorkLog");
	}
	
/** constructor for JIRA <= 7.0.X */
/* public XCreateWorkLog(
			WorklogService worklogService,
		    CommentService commentService,
		    ProjectRoleManager projectRoleManager,
		    JiraDurationUtils jiraDurationUtils,
		    OutlookDateManager outlookDateManager,
		    FieldVisibilityManager fieldVisibilityManager,
		    FieldLayoutManager fieldLayoutManager,
		    RendererManager rendererManager,
		    UserUtil userUtil,
		    FeatureManager featureManager) {
		super(worklogService, commentService, projectRoleManager, ComponentAccessor.getComponent(JiraDurationUtils.class), outlookDateManager, fieldVisibilityManager, fieldLayoutManager, rendererManager, userUtil, featureManager);
		log.debug("XCreateWorkLog");
	}*/
	
	@Override
	protected String doExecute() throws Exception {
		log.debug("doExecute");
		return super.doExecute();
	}
	
	@Override
	protected void doValidation() {
		log.debug("doValidation");
		super.doValidation();
	}
	
	@Override
	public String doDefault() throws Exception {
		log.debug("doDefault");
		return super.doDefault();
	}
}