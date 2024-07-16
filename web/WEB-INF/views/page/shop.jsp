<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <title>蟹堡王点餐商家</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../shop/shop-include.jsp" %>
</head>
<body class="bg-blue-50">
<div id="shopContent">
    <%@include file="../shop/shop-page-1-editcard.jsp" %>
    <%@include file="../shop/shop-page-1.jsp" %>
</div>

<script>
    function editUser_order(oid) {
        $("#edit_card").show();
        $("#edit_card_ok_button").attr("data-id", oid);
        $.ajax({
            url: "shop/getDetail",
            type: "post",
            data: {
                "orderId": oid
            }, success: function (data) {
                $("#Userordercart").empty();
                var obj = $.parseJSON(data);
                $.each(obj.items, function (index, item) {
                    let str = item.productName + " " + item.productTags + " " + item.productCount;
                    $("#Userordercart").append("<p>" + str + "</p></br>")
                });
            }
        })
        $.ajax({
            url: "shop/getUserorder",
            type: "post",
            data: {
                "oid": oid
            }, success: function (data) {
                switch (data) {
                    case '已出餐':
                        $("#edit_card_userordertype0").prop("checked", true);
                        break;
                    case '待出餐':
                        $("#edit_card_userordertype1").prop("checked", true);
                        break;
                    default:
                        $("#edit_card_userordertype2").prop("checked", true);
                        break;
                }
            }
        })
    }

    function updateUserorder(obj) {
        let oid = $(obj).attr("data-id");
        $.ajax({
            url: "shop/changeState",
            type: "post",
            data: {
                "oid": oid,
                "state": $("input[name='orderStateRadio']:checked").val()
            },
            success: function (data) {
                window.location.reload();
            }
        })
    }

    $(function () {
        $('#pagination').pagination({
            dataSource: function (done) {
                const result = [];
                for (let i = 1; i <= ${count}; i++) {
                    result.push(i);
                }
                done(result);
            },
            totalNumber: ${total},
            pageSize: ${recnum},
            pageRange: 3,
            pageNumber: ${curpage},
            triggerPagingOnInit: false,
            hideOnlyOnePage: true,
            callback: function (page, jq) {
                changepage(jq.pageNumber);
            }
        });
    });
</script>
</body>
</html>
