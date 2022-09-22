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
        <title>chat</title>
    </head>
    <body>
        <%@include file="../header_footer/header.jsp" %>
          <!--Start forms-->
       <div class="container">          <div class="row justify-content-center mt-2 ">
            <div class="col-md-6 border border-primary bg-light p-3 rounded">
                <form action="/action_page.php"  >                             
                                    <input type="hidden" id="txt_chat_id"  name="txt_chat_id"    value="<c:out value="${chat.chat_id}"/>"  placeholder="Datetime "   />                                    
                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">subject</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_subject"   name="txt_subject"        autocomplete="off"   placeholder="Subject"  value="<c:out value="${subject.subject}"/>" />
                            </div>
                        </div>
                    

                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">message</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_message"   name="txt_message"        autocomplete="off"   placeholder="Message"  value="<c:out value="${message.message}"/>" />
                            </div>
                        </div>
                    

                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">account</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_account"   name="txt_account"        autocomplete="off"   placeholder="Account"  value="<c:out value="${account.account}"/>" />
                            </div>
                        </div>
                    

                        <div class="form-group row ">
                            <label class="col-md-3" for="txt_onegroup">account_fro</label> 
                            <div class="col-md-9 form-input  ">     
                                <input type="text" class="form-control textbox" id="txt_account_fro"   name="txt_account_fro"        autocomplete="off"   placeholder="Account_fro"  value="<c:out value="${account_fro.account_fro}"/>" />
                            </div>
                        </div>
                    
                                                                    
                            
                            <div class="form-group row ">
                                <c:if test="${chat.chat_id!=0  &&  chat.chat_id!=null }">
                                    <a class="btn btn-danger" href="${root}/chat?action=Frm_chat">Cancel update</a>
                                </c:if>
                            </div>
                         <button type="submit" class="btn btn-primary float-lg-right">Submit</button>
                </form>
            </div>
        </div>      </div>    </div>
       
        <div class="container">
            <table class="table table-bordered table-stripped">
                <thead>
                <td>subject</td>
                <td>message</td>
                <td>account</td>
                <td>account_fro</td>
                <td>Option</td>
                <td>Option</td>
                </thead>
                <c:forEach items="${chats}" var="chat">
                    <tr class="brd">
                        <td>${chat.subject}</td>
                        <td>${chat.message}</td>
                        <td>${chat.account}</td>
                        <td>${chat.account_fro}</td>
                        <td class="opt_td">  <a class="btn_delete relate" data-table="chat" data-bind="${chat.chat_id}" href="#" title="delete">  </a> </td>
                        <td class="opt_td">  <a class="btn_update relate" data-table="chat" data-bind="${chat.chat_id}"title="Update" href="chat?action=edit&chat_id=<c:out value="${chat.chat_id}"/>"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>        
        <%@include file="../header_footer/footer.jsp" %>

        <script src="${root}/web_scripts/db.js" type="text/javascript"></script>

    </body>
</html>

