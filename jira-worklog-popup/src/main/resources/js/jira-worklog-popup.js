AJS.$(function() {
	
	var divId = 'worklogpopup';
	
	AJS.$("body").on("submit", "#log-work", function(event) {
		event.preventDefault();
	    addDivMessage(divId);
		showMessage(divId);
	});
	
	JIRA.bind(JIRA.Events.NEW_CONTENT_ADDED, function(e, context, reason) {
        console.log('event ', e);
        console.log('context ', context);
        console.log('reason ', reason);
    });
	
});

function addDivMessage(divId) {
	var elemDiv = document.createElement('div');
	elemDiv.id = divId;
	elemDiv.style.cssText = 'position:absolute;z-index:100;width:80%;margin-left:10%;margin-right:10%;margin-top:10%;';
	document.body.insertBefore(elemDiv, document.body.firstChild);
}

function showMessage(divId) {
	AJS.messages.success( "#" + divId, {
		title : 'Title',
		body : '<p> Message about worklog .</p>',
		fadeout : true,
		delay : 3000,
		duration: 500
	});
}