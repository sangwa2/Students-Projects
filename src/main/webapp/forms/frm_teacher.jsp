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
        <title>teacher</title>
    </head>
    <body>
        <%@include file="../header_footer/header.jsp" %>
          <!--Start forms-->
       <div class="container">          <div class="row justify-content-center mt-2 ">
            <div class="col-md-6 border border-primary bg-light p-3 rounded">
                <form action="/action_page.php"  >                             
                                    <input type="hidden" id="txt_teacher_id"  name="txt_teacher_id"    value="<c:out value="${teacher.teacher_id}"/>"  placeholder="Datetime "   />                                    
                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">edu_level</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_edu_level"   name="txt_edu_level"        autocomplete="off"   placeholder="Edu_level"  value="<c:out value="${edu_level.edu_level}"/>" />
                            </div>
                        </div>
                    

                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">specification</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_specification"   name="txt_specification"        autocomplete="off"   placeholder="Specification"  value="<c:out value="${specification.specification}"/>" />
                            </div>
                        </div>
                    

                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">account</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_account"   name="txt_account"        autocomplete="off"   placeholder="Account"  value="<c:out value="${account.account}"/>" />
                            </div>
                        </div>
                    
                                                                    
                            
                            <div class="form-group row ">
                                <c:if test="${teacher.teacher_id!=0  &&  teacher.teacher_id!=null }">
                                    <a class="btn btn-danger" href="${root}/teacher?action=Frm_teacher">Cancel update</a>
                                </c:if>
                            </div>
                         <button type="submit" class="btn btn-primary float-lg-right">Submit</button>
                </form>
            </div>
        </div>      </div>    </div>
       
        <div class="container">
            <table class="table table-bordered table-stripped">
                <thead>
                <td>edu_level</td>
                <td>specification</td>
                <td>account</td>
                <td>Option</td>
                <td>Option</td>
                </thead>
                <c:forEach items="${teachers}" var="teacher">
                    <tr class="brd">
                        <td>${teacher.edu_level}</td>
                        <td>${teacher.specification}</td>
                        <td>${teacher.account}</td>
                        <td class="opt_td">  <a class="btn_delete relate" data-table="teacher" data-bind="${teacher.teacher_id}" href="#" title="delete">  </a> </td>
                        <td class="opt_td">  <a class="btn_update relate" data-table="teacher" data-bind="${teacher.teacher_id}"title="Update" href="teacher?action=edit&teacher_id=<c:out value="${teacher.teacher_id}"/>"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>        
        <%@include file="../header_footer/footer.jsp" %>

        <script src="${root}/web_scripts/db.js" type="text/javascript"></script>

    </body>
</html>

