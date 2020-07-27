<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var historyBack = '${historyBack}' == 'true';
	var alertMs = '${alertMs}'.trim();
	var reDirectUrl = '${reDirectUrl}'.trim();

	console.log(historyBack)
	console.log(alertMs)
	console.log(reDirectUrl)
	
	if (alertMs) {
		alert(alertMs);
	}

	if (historyBack) {
		history.back();
	}
	
	if (reDirectUrl) {
		location.replace(reDirectUrl);
	}
	
</script>