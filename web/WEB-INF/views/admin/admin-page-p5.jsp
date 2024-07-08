<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="h-full pb-16 overflow-y-auto">
    <div class="container grid px-6 mx-auto">
        <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
            商品管理
        </h2>
        <div class="w-full overflow-hidden rounded-lg shadow-xs">
            <div class="w-full overflow-x-auto">
                <table class="w-full whitespace-no-wrap">
                    <thead>
                    <tr
                            class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                        <th class="px-4 py-3">产品编号</th>
                        <th class="px-4 py-3">产品ID</th>
                        <th class="px-4 py-3">产品名称</th>
                        <th class="px-4 py-3">产品图片</th>
                        <th class="px-4 py-3">产品价格</th>
                        <th class="px-4 py-3">产品描述</th>
                        <th class="px-4 py-3">产品类型</th>
                        <th class="px-4 py-3">产品标签</th>
                        <th class="px-4 py-3"></th>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
                    <c:forEach items="${list}" var="product">
                        <tr id="trlist-${product.pid}" class="text-gray-700 dark:text-gray-400">
                            <td class="px-4 py-1 text-sm">${product.pid}</td>
                            <td class="px-4 py-1 text-sm">${product.productId}</td>
                            <td class="px-4 py-1 text-sm">${product.productName}</td>
                            <td class="px-4 py-1 text-sm">${product.productImg}</td>
                            <td class="px-4 py-1 text-sm">${product.productPrice}</td>
                            <td class="px-4 py-1 text-sm">${product.productDescription}</td>
                            <td class="px-4 py-1 text-sm">${product.productType}</td>
                            <td class="px-4 py-1 text-xs">
                                <span class="px-2 py-1 font-semibold leading-tight text-green-700 rounded-full dark:
                                <c:if test="${product.productTags=='很辣'}">bg-red-700</c:if>
                                <c:if test="${product.productTags=='微辣'}">bg-green-700</c:if>
                                <c:if test="${product.productTags=='不辣'}">bg-teal-700</c:if> dark:text-green-100
                                <c:if test="${product.productTags=='很辣'}">bg-red-100</c:if>
                                <c:if test="${product.productTags=='微辣'}">bg-green-100</c:if>
                                <c:if test="${product.productTags=='不辣'}">bg-teal-700</c:if>">
                                    <c:if test="${product.productTags=='很辣'}">
                                        很辣
                                    </c:if>
                                    <c:if test="${product.productTags=='微辣'}">
                                        微辣
                                    </c:if>
                                    <c:if test="${product.productTags=='不辣'}">
                                        不辣
                                    </c:if>
                                </span>
                            </td>
                            <td class="px-4 py-1">
                                <div class="flex items-center space-x-4 text-sm">
                                    <button class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                            aria-label="编辑" data-id="${product.pid}" onclick="editProduct(this)">
                                        <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20">
                                            <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z"></path>
                                        </svg>
                                    </button>
                                    <button class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                            aria-label="删除" data-id="${product.pid}" onclick="deleteProduct(this)">
                                        <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20">
                                            <path fill-rule="evenodd"
                                                  d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                                  clip-rule="evenodd"></path>
                                        </svg>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div
                    class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800">
                <span class="flex items-center col-span-3">
                    共 ${total} 页, ${count} 条数据
                </span>
                <span class="col-span-2"></span>
                <!-- Pagination -->
                <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
                    <div id="pagination" class="pagination"></div>
                </span>
            </div>
        </div>
    </div>
    <%@include file="admin-page-p5-editcard.jsp" %>
    <script>
        /*
       * 分页组件 https://pagination.js.org/
       * 每次初始化界面时刷新分页组件，其中callback属性调用admin.jsp中的changepage()替换当前界面
       * triggerPagingOnInit表示在初始化时触发回调函数，请勿改为true
       * changepage(jspPage, pageId, curpage)
        */
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
                    changepage("p5", "#lip5", jq.pageNumber);
                }
            });
        });

        /*
        * 编辑产品
        * obj: 编辑按钮(admin-page-p5.jsp)
         */
        function editProduct(obj) {
            let pid = $(obj).attr("data-id");
            $.ajax({
                url: "admin/getProduct",
                type: "post",
                data: {
                    "pid": pid
                },
                success: function (data) {
                    $("#edit_card").fadeIn();
                    let obj = jQuery.parseJSON(data);
                    $("#edit_card_productid").val(obj.productId);
                    $("#edit_card_productname").val(obj.productName);
                    $("#edit_card_productimg").val(obj.productImg);
                    $("#edit_card_productprice").val(obj.productPrice);
                    $("#edit_card_productdescription").val(obj.productDescription);
                    $("#edit_card_producttype").val(obj.productType);
                    $("#edit_card_ok_button").attr("data-pid", pid);
                    switch (obj.productTags) {
                        case 0:
                            $("#edit_card_producttags0").prop("checked", true);
                            break;
                        case 1:
                            $("#edit_card_producttags1").prop("checked", true);
                            break;
                        case 2:
                            $("#edit_card_producttags2").prop("checked", true);
                            break;
                    }
                }
            });
        }

        /*
       * 提交修改产品
       * thisobj: 提交按钮(admin-page-p5-editcard.jsp)
        */
        function updateProduct(thisobj) {
            let pid = $(thisobj).attr("data-pid");
            $.ajax({
                url: "admin/editProduct",
                type: "post",
                data: {
                    "pid": pid,
                    "productid": $("#edit_card_productid").val(),
                    "productname": $("#edit_card_productname").val(),
                    "productimg": $("#edit_card_productimg").val(),
                    "productprice": $("#edit_card_productprice").val(),
                    "productdescription": $("#edit_card_productdescription").val(),
                    "producttype": $("#edit_card_producttype").val(),
                    "producttags": $("input[name='productTags']:checked").val()
                },
                success: function (data) {
                    if (data == 200) {
                        $("#toast-title").text("修改成功");
                        $("#toast-content").text(data);
                        $("#toast").fadeIn();
                        setTimeout(function () {
                            $("#toast").fadeOut();
                        }, 2000);
                        $("#edit_card").fadeOut();
                        changepage("p5", "#lip5", ${curpage});
                    } else {
                        $("#toast-title").text("修改失败");
                        $("#toast-content").text(data);
                        $("#toast").fadeIn();
                        setTimeout(function () {
                            $("#toast").fadeOut();
                        }, 2000);
                    }
                }
            });
        }

        /*
        * 删除产品
        * obj: 删除按钮(admin-page-p5.jsp)
         */
        function deleteProduct(obj) {
            let pid = $(obj).attr("data-id");
            $("#modal-dialog").fadeIn();
            $("#modal-title").text("删除产品");
            $("#modal-content").text("确定删除该产品吗？");
            $("#modal-ok").click(function () {
                $("#modal-dialog").hide();
                $.ajax({
                    url: "admin/deleteProduct",
                    type: "post",
                    data: {
                        "pid": pid
                    },
                    success: function (data) {
                        if (data == 200) {
                            $("#toast-title").text("删除成功");
                            $("#toast-content").text(data);
                            $("#toast").fadeIn();
                            setTimeout(function () {
                                $("#toast").fadeOut();
                            }, 2000);
                            changepage("p5", "#lip5", ${curpage});
                        } else {
                            $("#toast-title").text("删除失败");
                            $("#toast-content").text(data);
                            $("#toast").fadeIn();
                            setTimeout(function () {
                                $("#toast").fadeOut();
                            }, 2000);
                        }
                    }
                });
            });
            $("#modal-cancel").click(function () {
                $("#modal-dialog").fadeOut();
            });
        }
    </script>
</main>