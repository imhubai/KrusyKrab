<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN" class="overflow-x-hidden">
<head>
    <title>蟹堡王点餐系统</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../order/order-include.jsp" %>
</head>
<body class="select-none overflow-x-hidden">
<%@include file="../order/order-result.jsp" %>
<%@include file="../order/order-footer.jsp" %>
</body>
<script>
    $(function () {
        $("#btn_history").addClass("font-bold");
    });

    function order_pay() {
        //test confirm
        let r = confirm("请选择支付是否成功?");
        if (r == true) {
            order_submit('true');
        } else {
            order_submit('false');
        }
    }

    function order_submit(result) {
        let json =${cartJson};
        $.ajax({
            url: "${pageContext.servletContext.contextPath}/order/orderResult",
            type: "post",
            data: {
                cart: JSON.stringify(json),
                payReturn: result
            },
            success: function (data) {
                window.location.href = '${pageContext.servletContext.contextPath}/order/orderDetail?orderId='+data;
            }
        })
    }
</script>
</html>
