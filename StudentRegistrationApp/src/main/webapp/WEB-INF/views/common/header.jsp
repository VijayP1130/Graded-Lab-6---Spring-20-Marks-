<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration System</title>
    <link href="<c:url value='/css/style.css' />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/students/list' />">Student Registration</a>
            <div class="navbar-nav ms-auto">
                <sec:authorize access="isAuthenticated()">
                    <span class="navbar-text me-3">
                        Welcome, <sec:authentication property="name" />
                        (<sec:authentication property="authorities" />)
                    </span>
                    <a class="nav-link" href="<c:url value='/logout' />">Logout</a>
                </sec:authorize>
            </div>
        </div>
    </nav>
    <div class="container mt-4">