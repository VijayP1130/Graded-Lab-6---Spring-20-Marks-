<%@ include file="../common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-12">
        <h2>Student Registration - Debate Event</h2>
        
        <!-- Success/Error Messages -->
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${successMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${errorMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        
        <!-- Action Buttons -->
        <div class="mb-3">
            <a href="<c:url value='/students/form' />" class="btn btn-primary">
                <i class="fas fa-plus"></i> Register New Student
            </a>
        </div>
        
        <!-- Students Table -->
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>Student ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Course</th>
                        <th>Country</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.studentId}</td>
                            <td>${student.firstName}</td>
                            <td>${student.lastName}</td>
                            <td>${student.course}</td>
                            <td>${student.country}</td>
                            <td>
                                <a href="<c:url value='/students/view/${student.studentId}' />" 
                                   class="btn btn-info btn-sm">View</a>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <a href="<c:url value='/students/edit/${student.studentId}' />" 
                                       class="btn btn-warning btn-sm">Edit</a>
                                    <form method="post" action="<c:url value='/students/delete/${student.studentId}' />" 
                                          style="display: inline;" 
                                          onsubmit="return confirm('Are you sure you want to delete this student?')">
                                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                    </form>
                                </sec:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty students}">
                        <tr>
                            <td colspan="6" class="text-center">No students registered yet.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
        
        <!-- Summary -->
        <div class="mt-3">
            <p class="text-muted">Total Students: ${students.size()}</p>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>