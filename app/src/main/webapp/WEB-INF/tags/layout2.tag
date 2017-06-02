<%@tag import="java.text.SimpleDateFormat"%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
--%>
<%@attribute name="contentheader" fragment="true" %>
<%@attribute name="content" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<%@attribute name="css" fragment="true" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <%--        <sec:csrfMetaTags/>
                <sec:authentication var="user" property="principal" />--%>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Scalda AO</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/t/bs-3.3.6/jq-2.2.0,dt-1.10.11,r-2.0.2,se-1.1.2/datatables.min.css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css">
        <!-- Theme style -->
        <link rel="stylesheet"  href="<c:url value="/resources/plugins/AdminLTE/css/AdminLTE.min.css"/>"/>
        <link rel="stylesheet"  href="<c:url value="/resources/css/style.css"/>"/>
        <link rel="stylesheet"  href="<c:url value="/resources/css/parsley.css"/>"/>
        <link rel="stylesheet"  href="<c:url value="/resources/css/content.css"/>"/>
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect.
        -->
        <link rel="stylesheet"  href="<c:url value="/resources/plugins/AdminLTE/css/skins/skin-blue.min.css"/>"/>
        <jsp:invoke fragment="css"/>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <!--
    BODY TAG OPTIONS:
    =================
    Apply one or more of the following classes to get the
    desired effect
    |---------------------------------------------------------|
    | SKINS         | skin-blue                               |
    |               | skin-black                              |
    |               | skin-purple                             |
    |               | skin-yellow                             |
    |               | skin-red                                |
    |               | skin-green                              |
    |---------------------------------------------------------|
    |LAYOUT OPTIONS | fixed                                   |
    |               | layout-boxed                            |
    |               | layout-top-nav                          |
    |               | sidebar-collapse                        |
    |               | sidebar-mini                            |
    |---------------------------------------------------------|
    -->
    <body class="hold-transition skin-blue sidebar-mini">
        <div id="main-wrapper" class="wrapper">
            <!-- Main Header -->
            <header class="main-header">
                <!-- Logo -->
                <a href="/Pasimo" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini">AO</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Pa</b>simo<img style="height: 50px;filter: brightness(0) invert(1);" src="<c:url value="/resources/images/dolphin-min.png"></c:url>"/></span>
                    </a>
                    <!-- Header Navbar -->
                    <nav class="navbar navbar-static-top" role="navigation">
                        <!-- Sidebar toggle button-->
                    <%--<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">--%>
                    <%--<span class="sr-only">Toggle navigation</span>--%>
                    <%--</a>--%>
                    <%--<div class="navbar-custom-menu">--%>
                    <%--<ul class="nav navbar-nav">--%>
                    <%--<!-- User Account: style can be found in dropdown.less -->--%>
                    <%--<li class="dropdown user user-menu">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">--%>
                    <%--<img src="/project/images/${user.abbreviation}.jpeg" class="account-image" alt="User Image">--%>
                    <%--<span class="hidden-xs">${user.makeFullName()}</span>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<!-- User image -->--%>
                    <%--<li class="user-header">--%>
                    <%--<img src="/project/images/${user.abbreviation}.jpeg" class="account-image-l" alt="User Image">--%>
                    <%--<p>--%>
                    <%--${user.abbreviation}--%>
                    <%--<small>${user.function}</small>--%>
                    <%--</p>--%>
                    <%--</li>--%>
                    <%--<!-- Menu Footer-->--%>
                    <%--<li class="user-footer">--%>
                    <%--<div class="pull-left">--%>
                    <%--<a href="<c:url value="/profile" />" class="btn btn-default btn-flat">Profile</a>--%>
                    <%--</div>--%>
                    <%--<div class="pull-right">--%>
                    <%--<form action="<c:url value="/logout" />" id="logout" method="post">--%>
                    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                    <%--<button id="signOut" type="submit" class="btn btn-default btn-flat" value="Sign out"/>Sign out--%>
                    <%--</form>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</div>--%>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu">
                        <li class="header">ADMIN</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li class="treeview">
                            <a href="lessongroup"><i class="fa fa-users"></i> <span>Lesgroepen</span> <i class="fa fa-angle-left pull-right"></i></a>
                            <ul class="treeview-menu">
                                <%--<li><a href="<c:url value="student"><c:param name="action" value="all"/></c:url>">Overview</a></li>--%>
                            </ul>
                        </li>
                        <%--<li class="treeview">
                            <a href="#"><i class="fa fa-user"></i> <span>Students</span> <i class="fa fa-angle-left pull-right"></i></a>
                            <ul class="treeview-menu">
                                &lt;%&ndash;<li><a href="<c:url value="student"><c:param name="action" value="all"/></c:url>">Overview</a></li>&ndash;%&gt;
                                </ul>
                            </li>--%>
                        <li class="treeview">
                            <a href="teacherOverview"><i class="fa fa-users"></i> <span>Leraren</span> <i class="fa fa-angle-left pull-right"></i></a>
                            <ul class="treeview-menu">
                                &lt;%&ndash;   <li><a href="<c:url value="teacher"><c:param name="action" value="all"/></c:url>">Overview</a></li>
                                    &ndash;%&gt;</ul>
                            </li>
                            <li class="treeview">
                                <a href="coachGroups"><i class="fa fa-users"></i> <span>Coachgroepen</span> <i class="fa fa-angle-left pull-right"></i></a>
                                <ul class="treeview-menu">
                                    &lt;%&ndash;   <li><a href="<c:url value="coachGroups"><c:param name="action" value="all"/></c:url>">Overview</a></li>
                                    &ndash;%&gt;</ul>
                            </li>
                            <li class="treeview">
                                <a href="view/employeemanagement/educationteam/"><i class="fa fa-users"></i> <span>EducatieTeams</span> <i class="fa fa-angle-left pull-right"></i></a>
                            </li>
                            <li class="treeview">
                                <a href="noteOverview"><i class="fa fa-sticky-note"></i> <span>Notities</span> <i class="fa fa-angle-left pull-right"></i></a>
                     
