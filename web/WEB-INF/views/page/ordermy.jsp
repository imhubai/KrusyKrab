<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN" class="overflow-hidden">
<head>
    <title>蟹堡王点餐系统</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../order/order-include.jsp" %>
</head>
<body class="select-none overflow-hidden">
<%@include file="../order/order-my.jsp" %>
<%@include file="../order/order-footer.jsp" %>
</body>
<script>
    $(function () {
        $("#btn_myinfo").addClass("font-bold");
    });
    function logout(){
        $.ajax({
            type: "POST",
            url: "${pageContext.servletContext.contextPath}/order/logout",
            success: function (data) {
                window.location.href = "../order";
            }
        })
    }
</script>
</html>
