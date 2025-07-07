<%@ include file="../common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row justify-content-center">
    <div class="col-md-6">
        <h2>Student Details</h2>
        
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${student.firstName} ${student.lastName}</h5>
                
                <table class="table table-bordered">
                    <tr>
                        <th>Student ID:</th>
                        <td>${student.studentId}</td>
                    </tr>
                    <tr>
                        <th>First Name:</th>
                        <td>${student.firstName}</td>
                    </tr>
                    <tr>
                        <th>Last Name:</th>
                        <td>${student.lastName}</td>
                    </tr>
                    <tr>
                        <th>Course:</th>
                        <td>${student.course}</td>
                    </tr>
                    <tr>
                        <th>Country:</th>
                        <td>${student.country}</td>
                    </tr>
                </table>
                
                <div class="mt-3">
                    <a href="<c:url value='/students/list' />" class="btn btn-secondary">Back to List</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="<c:url value='/students/edit/${student.studentId}' />" 
                           class="btn btn-warning">Edit</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>