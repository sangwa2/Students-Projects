<%@include file="../header_footer/login_check.jsp" %>
<%@include file="../header_footer/directives.jsp" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/navbars/">

        <!-- Bootstrap core CSS -->
        <link href="${root}/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
            .navbar a{
                color: #0e2c39;font-weight: 400;
            }
        </style>
        <title>course</title>
    </head>
    <body>
        <%@include file="../header_footer/header.jsp" %>
          <!--Start forms-->
       <div class="container">          <div class="row justify-content-center mt-2 ">
            <div class="col-md-6 border border-primary bg-light p-3 rounded">
                <form action="/action_page.php"  >                             
                                    <input type="hidden" id="txt_course_id"  name="txt_course_id"    value="<c:out value="${course.course_id}"/>"  placeholder="Datetime "   />                                    
                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">course_title</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_course_title"   name="txt_course_title"        autocomplete="off"   placeholder="Course_title"  value="<c:out value="${course_title.course_title}"/>" />
                            </div>
                        </div>
                    
                                                                    
                            
                            <div class="form-group row ">
                                <c:if test="${course.course_id!=0  &&  course.course_id!=null }">
                                    <a class="btn btn-danger" href="${root}/course?action=Frm_course">Cancel update</a>
                                </c:if>
                            </div>
                         <button type="submit" class="btn btn-primary float-lg-right">Submit</button>
                </form>
            </div>
        </div>      </div>    </div>
       
        <div class="container">
            <table class="table table-bordered table-stripped">
                <thead>
                <td>course_title</td>
                <td>Option</td>
                <td>Option</td>
                </thead>
                <c:forEach items="${courses}" var="course">
                    <tr class="brd">
                        <td>${course.course_title}</td>
                        <td class="opt_td">  <a class="btn_delete relate" data-table="course" data-bind="${course.course_id}" href="#" title="delete">  </a> </td>
                        <td class="opt_td">  <a class="btn_update relate" data-table="course" data-bind="${course.course_id}"title="Update" href="course?action=edit&course_id=<c:out value="${course.course_id}"/>"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>        
        <%@include file="../header_footer/footer.jsp" %>

        <script src="${root}/web_scripts/db.js" type="text/javascript"></script>

    </body>
</html>

