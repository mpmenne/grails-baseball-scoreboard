<%@ page import="com.github.grailsbaseballscoreboard.Team" %>



<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="team.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${teamInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'homeStadium', 'error')} ">
	<label for="homeStadium">
		<g:message code="team.homeStadium.label" default="Home Stadium" />
		
	</label>
	<g:textField name="homeStadium" value="${teamInstance?.homeStadium}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'teamName', 'error')} ">
	<label for="teamName">
		<g:message code="team.teamName.label" default="Team Name" />
		
	</label>
	<g:textField name="teamName" value="${teamInstance?.teamName}"/>
</div>

