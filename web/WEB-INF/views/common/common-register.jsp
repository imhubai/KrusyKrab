<%@ page contentType="text/html;charset=UTF-8" %>
<div class="flex justify-center px-6 py-24 lg:px-8">
    <div
            class="w-screen max-w-full px-4 mt-10 bg-opacity-75 rounded-sm shadow-xl sm:w-full sm:max-w-xs bg-stone-50 backdrop-blur-sm">
        <img src="${pageContext.servletContext.contextPath}/res/img/logo.png" alt="KKlogo" class="m-auto">
        <h2 class="text-2xl font-bold leading-9 tracking-tight text-center text-gray-900">蟹堡王通行证</h2>
        <form class="mt-2 space-y-2" action="${pageContext.servletContext.contextPath}/registerUser" method="POST">
            <div class="flex">
                <div class="mr-1">
                    <label for="account" class="block text-sm font-medium leading-6 text-gray-900">账号:</label>
                    <div class="mt-2">
                        <input  name="userId" type="text" autocomplete="account" required
                                class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                    </div>
                </div>
                <div class="mr-1">
                    <div class="flex items-center justify-between">
                        <label for="password" class="block text-sm font-medium leading-6 text-gray-900">密码:</label>
                    </div>
                    <div class="mt-2">
                        <input id="password" name="password" type="password" autocomplete="current-password"
                               required
                               class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                    </div>
                </div>
            </div>
            <div class="flex">
                <div class="mr-1">
                    <label for="account" class="block text-sm font-medium leading-6 text-gray-900">昵称:</label>
                    <div class="mt-2">
                        <input  name="nickname" type="text" autocomplete="account" required
                                class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                    </div>
                </div>
                <div class="w-1/2 mr-1">
                    <div class="flex items-center justify-between">
                        <label for="account" class="block text-sm font-medium leading-6 text-gray-900">电话:</label>
                    </div>
                    <div class="mt-2">
                        <input name="phone" type="text" autocomplete="account" required
                               class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                    </div>
                </div>
            </div>
            <div class="flex">
                <div class="w-1/2 mr-1">
                    <label for="account" class="block text-sm font-medium leading-6 text-gray-900">性别:</label>
                    <div class="mt-2">
                        <select id="sex" name="sex">
                            <option value="男" selected>男</option>
                            <option value="女">女</option>
                            <option value="沃尔玛购物袋">沃尔玛购物袋</option>
                            <option value="阿帕奇武装直升机">阿帕奇武装直升机</option>
                        </select>
                    </div>
                </div>
                <div class="w-1/2 ml-1 mr-1">
                    <label for="account" class="block text-sm font-medium leading-6 text-gray-900">出生日期:</label>
                    <div class="mt-2">
                        <input id="date_info" type="date" name="birthday" required
                               class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                    </div>
                </div>
            </div>
            <div class="mr-1">
                <div class="flex items-center justify-between">
                    <label for="account" class="block text-sm font-medium leading-6 text-gray-900">电子邮件:</label>
                </div>
                <div class="mt-2">
                    <input id="account" name="email" type="text" autocomplete="account" required
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                </div>
            </div>
            <div class="mt-2">
                <button type="submit"
                        class="flex w-full justify-center rounded-md bg-gradient-to-r from-blue-600 to-red-500 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-lg hover:to-red-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-blue-600">
                    注册
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        var time = new Date();
        var day = ("0" + time.getDate()).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        var today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#date_info').val(today);
    })
</script>