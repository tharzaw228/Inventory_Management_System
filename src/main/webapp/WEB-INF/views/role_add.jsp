<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0"/>
    <meta name="description" content="Inventory Management System"/>
    <meta name="keywords"
          content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern,  html5, responsive"/>
    <meta name="author" content="ACE Java Web Team"/>

    <title>Inventory Management System</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />

    <link rel="shortcut icon" type="image/x-icon"
          href="<c:url value="/resources/assets/img/inventory.png" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/css/bootstrap.min.css" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/css/animate.css" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/css/dataTables.bootstrap4.min.css" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/plugins/fontawesome/css/fontawesome.min.css" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/plugins/fontawesome/css/all.min.css" />"/>

    <link rel="stylesheet"
          href="<c:url value="/resources/assets/css/style.css" />"/>

</head>
<body>

<div id="global-loader">
    <div class="whirly-loader"></div>
</div>

<div class="main-wrapper">
    <div class="header">
        <div class="header-left active">
            <a href="<c:url value="index.jsp"/> " class="logo">
                <img src="<c:url value="/resources/assets/img/logo.png"/> " alt=""/>
            </a>
            <a href="<c:url value="index.jsp"/> " class="logo-small">
                <img src="<c:url value="/resources/assets/img/logo-small.png"/> " alt=""/>
            </a>
            <a id="toggle_btn" href="javascript:void(0);"> </a>
        </div>

        <a id="mobile_btn" class="mobile_btn" href="#sidebar">
          <span class="bar-icon">
            <span></span>
            <span></span>
            <span></span>
          </span>
        </a>

        <ul class="nav user-menu">
            <li class="nav-item">
                <div class="top-nav-search">
                    <a href="javascript:void(0);" class="responsive-search">
                        <i class="fa fa-search"></i>
                    </a>
                    <form action="#">
                        <div class="searchinputs">
                            <input type="text" placeholder="Search Here ..."/>
                            <div class="search-addon">
                    <span
                    ><img src="<c:url value="/resources/assets/img/icons/closes.svg"/> " alt="img"
                    /></span>
                            </div>
                        </div>
                        <a class="btn" id="searchdiv"
                        ><img src="<c:url value="/resources/assets/img/icons/search.svg"/> " alt="img"
                        /></a>
                    </form>
                </div>
            </li>

            <li class="nav-item dropdown has-arrow flag-nav">
                <a
                        class="nav-link dropdown-toggle"
                        data-bs-toggle="dropdown"
                        href="javascript:void(0);"
                        role="button"
                >
                    <img src="<c:url value="/resources/assets/img/flags/us1.png"/> " alt="" height="20"/>
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="<c:url value="/resources/assets/img/flags/us.png"/> " alt="" height="16"/> English
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="<c:url value="/resources/assets/img/flags/fr.png"/> " alt="" height="16"/> French
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="<c:url value="/resources/assets/img/flags/es.png"/> " alt="" height="16"/> Spanish
                    </a>
                    <a href="javascript:void(0);" class="dropdown-item">
                        <img src="<c:url value="/resources/assets/img/flags/de.png"/> " alt="" height="16"/> German
                    </a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a
                        href="javascript:void(0);"
                        class="dropdown-toggle nav-link"
                        data-bs-toggle="dropdown"
                >
                    <img src="<c:url value="/resources/assets/img/icons/notification-bing.svg"/> " alt="img"/>
                    <span class="badge rounded-pill">4</span>
                </a>
                <div class="dropdown-menu notifications">
                    <div class="topnav-dropdown-header">
                        <span class="notification-title">Notifications</span>
                        <a href="javascript:void(0)" class="clear-noti"> Clear All </a>
                    </div>
                    <div class="noti-content">
                        <ul class="notification-list">
                            <li class="notification-message">
                                <a href="<c:url value="#"/> ">
                                    <div class="media d-flex">
                        <span class="avatar flex-shrink-0">
                          <img alt="" src="<c:url value="/resources/assets/img/profiles/avatar-02.jpg"/> "/>
                        </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details">
                                                <span class="noti-title">John Doe</span> added new
                                                task
                                                <span class="noti-title"
                                                >Patient appointment booking</span
                                                >
                                            </p>
                                            <p class="noti-time">
                                                <span class="notification-time">4 mins ago</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="<c:url value="#"/> ">
                                    <div class="media d-flex">
                        <span class="avatar flex-shrink-0">
                          <img alt="" src="<c:url value="/resources/assets/img/profiles/avatar-03.jpg"/> "/>
                        </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details">
                                                <span class="noti-title">Tarah Shropshire</span>
                                                changed the task name
                                                <span class="noti-title"
                                                >Appointment booking with payment gateway</span
                                                >
                                            </p>
                                            <p class="noti-time">
                                                <span class="notification-time">6 mins ago</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="<c:url value="#"/> ">
                                    <div class="media d-flex">
                        <span class="avatar flex-shrink-0">
                          <img alt="" src="<c:url value="/resources/assets/img/profiles/avatar-06.jpg"/> "/>
                        </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details">
                                                <span class="noti-title">Misty Tison</span> added
                                                <span class="noti-title">Domenic Houston</span> and
                                                <span class="noti-title">Claire Mapes</span> to
                                                project
                                                <span class="noti-title"
                                                >Doctor available module</span
                                                >
                                            </p>
                                            <p class="noti-time">
                                                <span class="notification-time">8 mins ago</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="<c:url value="#"/> ">
                                    <div class="media d-flex">
                        <span class="avatar flex-shrink-0">
                          <img alt="" src="<c:url value="/resources/assets/img/profiles/avatar-17.jpg"/> "/>
                        </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details">
                                                <span class="noti-title">Rolland Webber</span>
                                                completed task
                                                <span class="noti-title"
                                                >Patient and Doctor video conferencing</span
                                                >
                                            </p>
                                            <p class="noti-time">
                                                <span class="notification-time">12 mins ago</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="<c:url value="#"/> ">
                                    <div class="media d-flex">
                        <span class="avatar flex-shrink-0">
                          <img alt="" src="<c:url value="/resources/assets/img/profiles/avatar-13.jpg"/> "/>
                        </span>
                                        <div class="media-body flex-grow-1">
                                            <p class="noti-details">
                                                <span class="noti-title">Bernardo Galaviz</span>
                                                added new task
                                                <span class="noti-title">Private chat module</span>
                                            </p>
                                            <p class="noti-time">
                                                <span class="notification-time">2 days ago</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="topnav-dropdown-footer">
                        <a href="<c:url value="#"/> ">View all Notifications</a>
                    </div>
                </div>
            </li>

            <li class="nav-item dropdown has-arrow main-drop">
                <a
                        href="javascript:void(0);"
                        class="dropdown-toggle nav-link userset"
                        data-bs-toggle="dropdown"
                >
              <span class="user-img"
              ><img src="<c:url value="/resources/assets/img/profiles/user.png"/> " alt=""/>
                <span class="status online"></span
                ></span>
                </a>
                <div class="dropdown-menu menu-drop-user">
                    <div class="profilename">
                        <div class="profileset">
                  <span class="user-img"
                  ><img src="<c:url value="/resources/assets/img/profiles/user.png"/> " alt=""/>
                    <span class="status online"></span
                    ></span>
                            <div class="profilesets">
                                <h6>John Doe</h6>
                                <h5>Admin</h5>
                            </div>
                        </div>
                        <hr class="m-0"/>
                        <a class="dropdown-item" href="<c:url value="#"/> ">
                            <i class="me-2" data-feather="user"></i> My Profile</a
                        >
                        <a class="dropdown-item" href="<c:url value="#"/> "
                        ><i class="me-2" data-feather="settings"></i>Settings</a
                        >
                        <hr class="m-0"/>
                        <a class="dropdown-item logout pb-0" href="<c:url value="#"/> "
                        ><img
                                src="<c:url value="/resources/assets/img/icons/log-out.svg"/> "
                                class="me-2"
                                alt="img"
                        />Logout</a
                        >
                    </div>
                </div>
            </li>
        </ul>

        <div class="dropdown mobile-user-menu">
            <a
                    href="javascript:void(0);"
                    class="nav-link dropdown-toggle"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
            ><i class="fa fa-ellipsis-v"></i
            ></a>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="<c:url value="#"/> ">My Profile</a>
                <a class="dropdown-item" href="<c:url value="#"/>">Settings</a>
                <a class="dropdown-item" href="<c:url value="#"/>">Logout</a>
            </div>
        </div>
    </div>

    <div class="sidebar" id="sidebar">
        <div class="sidebar-inner slimscroll">
            <div id="sidebar-menu" class="sidebar-menu">
                <ul>
                    <li>
                        <a href="<c:url value="/dashboard"/>"
                        ><img src="<c:url value="/resources/assets/img/icons/dashboard.svg"/> " alt="img"/><span>
                    Dashboard</span
                        >
                        </a>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/users1.svg"/> " alt="img"/><span>
                    User</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/user/add_user"/>">Add User </a></li>
                            <li><a href="<c:url value="/user/showusers"/>">User List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/users1.svg"/> " alt="img"/><span>
                    Role</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/role/add_role"/>" class="active">Add Role </a></li>
                            <li><a href="<c:url value="/role/showroles"/>">Role List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/product.svg"/> " alt="img"/><span>
                    Product</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/product/add_product"/>">Add Product</a></li>
                            <li><a href="<c:url value="/product/showproducts"/>">Product List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/product.svg"/> " alt="img"/><span>
                    Category</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/category/add_category"/>">Add Category</a></li>
                            <li><a href="<c:url value="/category/showcategories"/>">Category List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/users1.svg"/> " alt="img"/><span>
                    Order</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="#"/>">Add Order </a></li>
                            <li><a href="<c:url value="#"/>">Order List</a></li>
                            <li><a href="<c:url value="#"/>">Add Order Detail </a></li>
                            <li><a href="<c:url value="#"/>">Order Detail List</a></li>
                            <li><a href="<c:url value="#"/>">Invoice </a></li>
                            <li><a href="<c:url value="#"/>">Invoice List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/users1.svg"/> " alt="img"/><span>
                    Lot</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/lot/add_lot"/>">Add Lot </a></li>
                            <li><a href="<c:url value="/lot/showlots"/>">Lot List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img
                                src="<c:url value="/resources/assets/img/icons/svg-gobbler.svg"/> "
                                alt="img"/><span> Location</span>
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="/location/add_location"/>">Add Location </a></li>
                            <li><a href="<c:url value="/location/showlocations"/>">Location List</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"
                        ><img src="<c:url value="/resources/assets/img/icons/settings.svg"/> " alt="img"/><span>
                    Settings</span
                        >
                            <span class="menu-arrow"></span
                            ></a>
                        <ul>
                            <li><a href="<c:url value="#"/>">General Settings</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="page-wrapper">
        <div class="content">
            <div class="page-header">
                <div class="page-title">
                    <h4>Role Management</h4>
                    <h6>Add/Update Role</h6>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <form:form modelAttribute="role" method="post" action="do_role">
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <form:label for="roleName" path="roleName">Role</form:label>
                                    <form:input type="text" path="roleName"/>
                                    <form:errors path="roleName" cssClass="error"/><br>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <input type="submit" href="javascript:void(0);" class="btn btn-submit me-2" value="Add"
                                />
                                <a href="<c:url value="#"/>" class="btn btn-cancel">Cancel</a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script
        src="<c:url value="/resources/assets/js/jquery-3.6.0.min.js" />"></script>

<script src="<c:url value="/resources/assets/js/feather.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/js/jquery.slimscroll.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/js/jquery.dataTables.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/js/dataTables.bootstrap4.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/js/bootstrap.bundle.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/plugins/apexchart/apexcharts.min.js" />"></script>

<script
        src="<c:url value="/resources/assets/plugins/apexchart/chart-data.js" />"></script>

<script src="<c:url value="/resources/assets/js/script.js" />"></script>

</body>
</html>