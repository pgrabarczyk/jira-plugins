# jira-worklog-action

Idea of this plugin is to extends exists action "CreateWorkLog" to do something extra when user log time.

Actual problem:

2016-03-17 15:23:13,010 http-nio-2990-exec-2 DEBUG admin 923x4692x1 1of3uno 127.0.0.1 /secure/CreateWorklog!default.jspa [c.p.j.worklog.action.XCreateWorkLog] XCreateWorkLog
2016-03-17 15:23:13,080 http-nio-2990-exec-2 DEBUG admin 923x4692x1 1of3uno 127.0.0.1 /secure/CreateWorklog!default.jspa [c.p.j.worklog.action.XCreateWorkLog] doDefault
2016-03-17 15:23:17,713 http-nio-2990-exec-4 ERROR admin 923x4695x1 1of3uno 127.0.0.1 /secure/XCreateWorkLog.jspa [c.a.j.web.dispatcher.JiraWebworkActionDispatcher] Exception thrown from action 'XCreateWorkLog', returning 404 
WebworkConfigurationNotFoundException{class=class webwork.config.XMLActionConfiguration, message='No such view mapping', name='XCreateWorkLog.actionRoles.actionRoles'}

To reproduce:
install plugin into JIRA (v 7.1.X) then try to logwork on any issue. After select time and try to confirm exception occurs.