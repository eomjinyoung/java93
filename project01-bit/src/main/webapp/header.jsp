<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class='header'>
  <div id='logo'>비트캠프</div>
  <div id='login'>
    ${loginMember.name}(${loginMember.email})
    <a href='%s/auth/logout'>로그아웃</a>
  </div>
</div>