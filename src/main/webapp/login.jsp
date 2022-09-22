<%-- 
    Document   : login
    Created on : 2022-02-01 
    Author     : SANGWA
--%>
 
<%@include file="header_footer/directives.jsp" %>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" href="web_styles/commons.css"   type="text/css"   />
        <link rel="stylesheet" href="web_styles/my_styles.css" type="text/css"   />
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.structure.css" rel="stylesheet" type="text/css"/>
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.theme.css" rel="stylesheet" type="text/css"/>
        <link href="${root}/web_scripts/ui_scripts/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body class="login_page ">
        <%@include file="header_footer/sessionless_header.jsp" %> 
        <form action="get_login" method="post">

            <div class="login row col_c1 relate ">
                <div class="top_right close_btn vcenter hcenter hand_cursor">X</div>
                <c:if test="${user_login!=null}">
                     <div class="title">
                         <span class="danger">Login ${user_login} </span>
                         ${err}
                     </div>
                </c:if>
                <c:if test="${user_login==null}">
                    <div class="title">Login    </div>
                </c:if>
                <div class="row ">
                    <div class="username label col_lg_3 col_md_3 col_sm_12 vcenter">   Username   </div>
                    <div class="username text col_lg_9 col_md_9 col_sm_12">   <input type="text" class="textbox pad" required id="txt_username" name="username" autocomplete="off" value=""    />   </div>
                </div>

                <div class="row">
                    <div class="username label col_lg_3 col_md_3 col_sm_12 vcenter">   Password   </div>
                    <div class="username text col_lg_9 col_md_9 col_sm_12">   <input type="password" class="textbox pad" required id="txt_password" name="password"  value="1234"  />   </div>
                </div>
                <div class="row login_row">
                    <a href="index.jsp">Home</a>
                    
                    <button type="submit" data-bind="exclude" class="pad btn_save login_btn hand_cursor">Login</button>
                </div>
            </div>
        </form>
           <script src="web_scripts/jquery-2.1.3.min.js"   type="text/javascript"></script>
        <script src="web_scripts/ui_scripts/jquery-ui.js"   type="text/javascript"></script>
        <script src="web_scripts/ui_scripts/jquery-ui.min.js"  type="text/javascript"></script>
        <script src="web_scripts/db.js" type="text/javascript"></script>
        <script src="web_scripts/commons.js"  type="text/javascript"></script>

    </body>
</html>

