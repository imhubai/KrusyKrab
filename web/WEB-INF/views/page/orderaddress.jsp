<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN">
<head>
    <title>蟹堡王点餐系统</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../order/order-include.jsp" %>
</head>
<body class="select-none">
<%@include file="../order/order-address.jsp" %>
<%@include file="../order/order-footer.jsp" %>
</body>
<script>
    function chooseShop(shopId) {
        $("#shoplist").removeClass("ring-2");
        $(".list-"+shopId).addClass("ring-2");
        $.ajax({
            type: "POST",
            url: "address",
            data: {
                shopId: shopId
            },
            success: function (data) {
                $("body").html(data);
                let s = $(location).attr("href");
                s=s.substring(0,s.lastIndexOf('/'));
                window.history.pushState(null, null, s);
            }
        })
    }
</script>
</html>
