<%@ page contentType="text/html;charset=UTF-8" %>
<div class="w-full h-full overflow-x-hidden bg-white">
  <%@ include file="order-title.jsp"%>
    <div class="relative block">
        <div class="box-border block w-full h-auto bg-white">
            <div class="box-border block w-full">
                <div class="box-border relative block">
                    <div class="box-border relative inline-block w-full overflow-hidden">
                        <div class="w-full bg-cover bg-np-repeat">
                            <img src="https://img.picui.cn/free/2024/07/11/668f459bac2cc.png">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 开头 -->
    <div class="box-border relative flex flex-col mb-4 bg-white rounded -mt-14 ">
        <div class="box-border flex items-center ">
            <div
                    class="box-border relative flex items-center justify-center w-20 h-20 ml-4 mr-4 -mt-4 bg-white rounded-full">
                <div class="box-border relative inline-block w-16 h-16 overflow-hidden rounded-full">
                    <div class="w-full h-full bg-no-repeat bg-cover">
                        <img class="absolute block w-full h-full"
                             src="https://img.picui.cn/free/2024/07/05/66874648daf32.png">
                    </div>
                </div>
            </div>
            <div class="box-border flex flex-col flex-auto mt-2 overflow-hidden">
                <div class="box-border block text-sm font-bold">
                    ${user.nickname}
                </div>
                <div class="box-border block text-xs text-gray-400">
                    当前成长值0/0
                </div>
                <div class="box-border block w-full">
                    <div class="flex items-center">
                        <div class="flex-1 h-1 bg-slate-50">
                            <div class="w-0 h-full bg-lime-500"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="box-border flex items-center justify-center w-full">
            <div class="box-border flex flex-col items-center justify-center w-1/4 p-4">
                <div class="box-border block mb-2 text-xl text-nowrap font-bold text-gray-600">
                    ${user.userId}
                </div>
                <div class="box-border block text-xs text-gray-600">
                    UID
                </div>
            </div>
            <div class="box-border flex flex-col items-center justify-center w-1/4 p-4">
                <div class="box-border block mb-2 text-xl text-nowrap font-bold text-gray-600">
                    ${user.sex}
                </div>
                <div class="box-border block text-xs text-nowrap text-gray-600">
                    性别
                </div>
            </div>
            <div class="box-border flex flex-col items-center justify-center w-1/4 p-4">
                <div class="box-border block mb-2 text-xl text-nowrap font-bold text-gray-600">
                    ${user.birthday}
                </div>
                <div class="box-border block text-xs text-gray-600">
                    生日
                </div>
            </div>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="grid min-h-3.5 place-content-center">
        <button id="btn_logout" onclick="logout()"
                class="relative inline-flex items-center justify-center p-0.5 mb-2 overflow-hidden text-sm font-medium text-gray-900 rounded-lg group bg-gradient-to-br from-teal-300 to-lime-300 active:from-lime-300 active:to-teal-300 group-hover:from-teal-300 group-hover:to-lime-300 hover:text-white dark:text-white focus:outline-none focus:ring-0 focus:ring-lime-800 mx-auto">
            <span
                    class="relative px-5 py-2.5 transition-all ease-in duration-75 bg-gradient-to-br from-lime-400 to-teal-500 rounded-md group-hover:bg-opacity-0">
                退出登录
            </span>
        </button>
    </div>
</div>