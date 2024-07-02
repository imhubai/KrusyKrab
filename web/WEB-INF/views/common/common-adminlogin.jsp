<%@ page contentType="text/html;charset=UTF-8" %>

<div class="min-h-screen flex items-center justify-center">
    <div class="bg-teal-900 shadow-md rounded-lg px-8 py-6 max-w-md">
        <h1 class="text-2xl font-bold text-center mb-4 dark:text-gray-200">登录到蟹堡王后台</h1>
        <form action="./admin" method="post">
            <div class="mb-4">
                <label for="account"
                       class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">账号</label>
                <input type="text" id="account" name="adminid"
                       class="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                       placeholder="" required>
            </div>
            <div class="mb-4">
                <label for="password"
                       class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">密码</label>
                <input type="password" id="password" name="adminpassword"
                       class="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                       placeholder="" required>
                <a href="#"
                   class="text-xs text-indigo-50 hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">忘记密码</a>
            </div>
            <div class="flex items-center justify-between mb-4">
                <div class="flex items-center">
                    <input type="checkbox" id="remember"
                           class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 focus:outline-none"
                           checked>
                    <label for="remember" class="ml-2 block text-sm text-gray-700 dark:text-gray-300">记住账号</label>
                </div>
            </div>
            <button type="submit"
                    class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">登录</button>
            <p>${errorMessage}</p>
        </form>
    </div>
</div>