
<%@ page import="com.github.grailsbaseballscoreboard.Team" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-team" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-team" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list team">
			
				<g:if test="${teamInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="team.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${teamInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teamInstance?.homeStadium}">
				<li class="fieldcontain">
					<span id="homeStadium-label" class="property-label"><g:message code="team.homeStadium.label" default="Home Stadium" /></span>
					
						<span class="property-value" aria-labelledby="homeStadium-label"><g:fieldValue bean="${teamInstance}" field="homeStadium"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teamInstance?.teamName}">
				<li class="fieldcontain">
					<span id="teamName-label" class="property-label"><g:message code="team.teamName.label" default="Team Name" /></span>
					
						<span class="property-value" aria-labelledby="teamName-label"><g:fieldValue bean="${teamInstance}" field="teamName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${teamInstance?.id}" />
					<g:link class="edit" action="edit" id="${teamInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
