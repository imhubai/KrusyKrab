<%@ page contentType="text/html;charset=UTF-8" %>
<div class="flex justify-end px-6 py-24 lg:px-8">
    <div class="mt-10 sm:w-full sm:max-w-xs max-w-full w-screen px-4 bg-stone-50 rounded-sm bg-opacity-75 shadow-xl backdrop-blur-sm">
        <img src="${pageContext.servletContext.contextPath}/res/img/logo.png" alt="KKlogo" class="m-auto">
        <h2 class="text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">蟹堡王通行证</h2>
        <form class="space-y-2 mt-2" action="#" method="POST">
            <div>
                <label for="account" class="block text-sm font-medium leading-6 text-gray-900">账号</label>
                <div class="mt-2">
                    <input id="account" name="account" type="text" autocomplete="account" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                </div>
            </div>

            <div>
                <div class="flex items-center justify-between">
                    <label for="password" class="block text-sm font-medium leading-6 text-gray-900">密码</label>
                    <div class="text-sm">
                        <a href="#" class="font-semibold text-blue-500 hover:text-blue-600">忘记密码?</a>
                    </div>
                </div>
                <div class="mt-2">
                    <input id="password" name="password" type="password" autocomplete="current-password" required
                           class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600 sm:text-sm sm:leading-6">
                </div>
            </div>

            <div class="mt-2">
                <button type="submit" class="flex w-full justify-center rounded-md bg-gradient-to-r from-blue-600 to-red-500 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-lg hover:to-red-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-blue-600">登录</button>
            </div>
        </form>

        <p class="mt-20 text-center text-sm text-gray-700">还没有账号?<a href="#" class="font-semibold leading-6 text-blue-500 hover:text-blue-600">立即注册，享受X折优惠!</a>
        </p>
    </div>
</div>