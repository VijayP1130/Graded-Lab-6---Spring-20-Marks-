<%@ include file="../common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row justify-content-center">
    <div class="col-md-6">
        <h2>${student.studentId == null ? 'Register New Student' : 'Edit Student'}</h2>
        
        <form:form method="post" action="${pageContext.request.contextPath}/students/save" 
                   modelAttribute="student" cssClass="needs-validation" novalidate="true">
            
            <form:hidden path="studentId"/>
            
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name *</label>
                <form:input path="firstName" cssClass="form-control" id="firstName" required="true"/>
                <form:errors path="firstName" cssClass="text-danger"/>
            </div>
            
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name *</label>
                <form:input path="lastName" cssClass="form-control" id="lastName" required="true"/>
                <form:errors path="lastName" cssClass="text-danger"/>
            </div>
            
            <div class="mb-3">
                <label for="course" class="form-label">Course *</label>
                <form:select path="course" cssClass="form-select" id="course" required="true">
                    <form:option value="">Select Course</form:option>
                    <form:option value="B.Tech">B.Tech</form:option>
                    <form:option value="B.Arch">B.Arch</form:option>
                    <form:option value="B.Com">B.Com</form:option>
                    <form:option value="BBA">BBA</form:option>
                    <form:option value="MBA">MBA</form:option>
                    <form:option value="M.Tech">M.Tech</form:option>
                </form:select>
                <form:errors path="course" cssClass="text-danger"/>
            </div>
            
            <div class="mb-3">
                <label for="country" class="form-label">Country *</label>
                <form:select path="country" cssClass="form-select" id="country" required="true">
                    <form:option value="">Select Country</form:option>
                    <form:option value="India">India</form:option>
                    <form:option value="USA">USA</form:option>
                    <form:option value="Canada">Canada</form:option>
                    <form:option value="UK">UK</form:option>
                    <form:option value="Australia">Australia</form:option>
                    <form:option value="New Zealand">New Zealand</form:option>
                    <form:option value="Germany">Germany</form:option>
                    <form:option value="France">France</form:option>
                </form:select>
                <form:errors path="country" cssClass="text-danger"/>
            </div>
            
            <div class="mb-3">
                <button type="submit" class="btn btn-success">
                    ${student.studentId == null ? 'Register Student' : 'Update Student'}
                </button>
                <a href="<c:url value='/students/list' />" class="btn btn-secondary">Cancel</a>
            </div>
        </form:form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>