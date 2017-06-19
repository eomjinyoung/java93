<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class='header'>
  <div id='logo'>비트캠프</div>
<c:if test="${loginMember != null}">
  <div id='login'>
    ${loginMember.name}(${loginMember.email})
    <a href='${pageContext.request.contextPath}/auth/logout.do'>로그아웃</a>
  </div>
</c:if>
</div>