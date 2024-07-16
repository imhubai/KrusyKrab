<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN" class="overflow-x-hidden">
<head>
    <title>蟹堡王点餐系统</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../order/order-include.jsp" %>
</head>
<body class="select-none overflow-x-hidden">
<%@include file="../order/order-history.jsp" %>
<%@include file="../order/order-footer.jsp" %>
</body>
<script>
    function getDetail(orderId) {
        window.location.href = "${pageContext.servletContext.contextPath}/order/orderDetail?orderId=" + orderId;
    }
    $(function () {
        $("#btn_history").addClass("font-bold");
    });
</script>
</html>
