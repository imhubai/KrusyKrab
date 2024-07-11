<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="h-full pb-16 overflow-y-auto">
    <div class="container grid px-6 mx-auto">
        <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
            用户管理
        </h2>
        <div class="w-full overflow-hidden rounded-lg shadow-xs">
            <div class="w-full overflow-x-auto">
                <table class="w-full whitespace-no-wrap">
                    <thead>
                    <tr
                            class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                        <th class="px-4 py-3">用户ID</th>
                        <th class="px-4 py-3">用户账号</th>
                        <th class="px-4 py-3">用户密码</th>
                        <th class="px-4 py-3">用户昵称</th>
                        <th class="px-4 py-3">邮件</th>
                        <th class="px-4 py-3">性别</th>
                        <th class="px-4 py-3">电话</th>
                        <th class="px-4 py-3">出生日期</th>
                        <th class="px-4 py-3">创建时间</th>
                        <th class="px-4 py-3">头像</th>
                        <th class="px-4 py-3">用户类型</th>
                        <th class="px-4 py-3"></th>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
                    <c:forEach items="${list}" var="user">
                        <tr id="trlist-${user.uid}" class="text-gray-700 dark:text-gray-400">
                            <td class="px-4 py-1 text-sm">${user.uid}</td>
                            <td class="px-4 py-1 text-sm">${user.userId}</td>
                            <td class="px-4 py-1 text-sm">${user.password}</td>
                            <td class="px-4 py-1 text-sm">${user.nickname}</td>
                            <td class="px-4 py-1 text-sm">${user.email}</td>
                            <td class="px-4 py-1 text-sm">${user.sex}</td>
                            <td class="px-4 py-1 text-sm">${user.phone}</td>
                            <td class="px-4 py-1 text-sm">${user.birthday}</td>
                            <td class="px-4 py-1 text-sm">${user.createtime}</td>
                            <td class="px-4 py-1 text-sm">${user.avatar}</td>
                            <td class="px-4 py-1 text-xs">
                                <span class="px-2 py-1 font-semibold leading-tight text-green-700 rounded-full dark:<c:if test="${user.usertype == 0}">bg-red-700</c:if><c:if test="${user.usertype == 1}">bg-green-700</c:if> dark:text-green-100 <c:if test="${user.usertype == 0}">bg-red-100</c:if><c:if test="${user.usertype == 1}">bg-green-100</c:if>">
                                    <c:if test="${user.usertype == 0}">
                                        VIP用户
                                    </c:if>
                                    <c:if test="${user.usertype == 1}">
                                        普通用户
                                    </c:if>
                                </span>
                            </td>
                            <td class="px-4 py-1">
                                <div class="flex items-center space-x-4 text-sm">
                                    <button class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                            aria-label="编辑" data-id="${user.uid}" onclick="editUser(this)">
                                        <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20">
                                            <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z"></path>
                                        </svg>
                                    </button>
                                    <button class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                            aria-label="删除" data-id="${user.uid}" onclick="deleteUser(this)">
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
    <%@include file="./editcards/admin-page-p4-editcard.jsp"%>
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
                    changepage("p4", "#lip4", jq.pageNumber);
                }
            });
        });
        /*
        * 编辑用户
        * obj: 编辑按钮(admin-page-p4.jsp)
         */
        function editUser(obj) {
            let uid = $(obj).attr("data-id");
            $.ajax({
                url: "admin/getUser",
                type: "post",
                data: {
                    "uid": uid
                },
                success: function (data) {
                    $("#edit_card").fadeIn();
                    let obj = jQuery.parseJSON(data);
                    $("#edit_card_userid").val(obj.userId);
                    $("#edit_card_password").val(obj.password);
                    $("#edit_card_nickname").val(obj.nickname);
                    $("#edit_card_email").val(obj.email);
                    $("#edit_card_sex").val(obj.sex);
                    $("#edit_card_phone").val(obj.phone);
                    $("#edit_card_avatar").val(obj.avatar);
                    $("#edit_card_ok_button").attr("data-uid", uid);
                    switch (obj.usertype) {
                        case 0:
                            $("#edit_card_usertype0").prop("checked", true);
                            break;
                        case 1:
                            $("#edit_card_usertype1").prop("checked", true);
                            break;
                    }
                    console.log(formatDateTime(obj.birthday));
                    $("#edit_card_birthday").val(formatDateTime(obj.birthday));
                }
            });
        }

        /*
       * 提交修改用户
       * thisobj: 提交按钮(admin-page-p4-editcard.jsp)
        */
        function updateUser(thisobj) {
            let uid = $(thisobj).attr("data-uid");
            $.ajax({
                url: "admin/editUser",
                type: "post",
                data: {
                    "uid": uid,
                    "userid": $("#edit_card_userid").val(),
                    "password": $("#edit_card_password").val(),
                    "nickname": $("#edit_card_nickname").val(),
                    "email": $("#edit_card_email").val(),
                    "sex": $("#edit_card_sex").val(),
                    "phone": $("#edit_card_phone").val(),
                    "birthday": $("#edit_card_birthday").val(),
                    "avatar": $("#edit_card_avatar").val(),
                    "usertype": $("input[name='usertype']:checked").val()
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
                        changepage("p4", "#lip4", ${curpage});
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
        * 删除用户
        * obj: 删除按钮(admin-page-p4.jsp)
         */
        function deleteUser(obj) {
            let uid = $(obj).attr("data-id");
            $("#modal-dialog").fadeIn();
            $("#modal-title").text("删除用户");
            $("#modal-content").text("确定删除该用户吗？");
            $("#modal-ok").click(function () {
                $("#modal-dialog").hide();
                $.ajax({
                    url: "admin/deleteUser",
                    type: "post",
                    data: {
                        "uid": uid
                    },
                    success: function (data) {
                        if (data == 200) {
                            $("#toast-title").text("删除成功");
                            $("#toast-content").text(data);
                            $("#toast").fadeIn();
                            setTimeout(function () {
                                $("#toast").fadeOut();
                            }, 2000);
                            changepage("p4", "#lip4", ${curpage});
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
<%@include file="admin-footer-include.jsp"%>