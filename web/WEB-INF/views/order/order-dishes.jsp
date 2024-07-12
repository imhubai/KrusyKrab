<%@ page contentType="text/html;charset=UTF-8" %>
<!--界面-->
<div class="container relative w-full h-screen overflow-hidden">
    <%@include file="../order/order-title.jsp" %>
    <main class="relative flex flex-col w-full h-full">
        <div class="flex flex-col flex-shrink-0 h-auto">
            <div class="flex items-center justify-between w-full h-auto p-3 bg-white">
                <div class="flex flex-col flex-1">
                    <div class="flex items-center justify-start mb-1">
                        <span>${shop.shopName}</span>
                    </div>
                    <div class="flex items-center justify-start text-xs text-gray-600">
                        <span>${shop.shopAddress}</span>
                    </div>
                </div>
                <div class="flex items-center pr-2 bg-gray-100 rounded-2xl">
                    <div>
                        <button class="pt-1 pb-1 pl-4 pr-4 text-sm rounded-2xl bg-lime-400">自取</button>
                    </div>
                    <div class="pt-1 pb-1 pl-2 pr-2">
                        <button class="text-sm">外卖</button>
                    </div>
                </div>
            </div>
            <div class="flex items-center flex-1 w-full pl-2 pr-2 overflow-hidden text-xs shadow-inner bg-lime-100">
                <h4 class="flex-1 m-2 overflow-hidden whitespace-nowrap text-ellipsis text-lime-800"
                    id="order-title-tip">新品上线!
                    无敌龙鳞屠龙刀点击就送！</h4>
                <!-- 图标 -->
            </div>
        </div>
        <!-- 主菜单-->
        <div class="flex flex-1 w-full overflow-hidden">
            <div class="w-24 h-full overflow-hidden bg-slate-50">
                <div class="w-full h-screen overflow-x-hidden overflow-y-auto scroll-smooth">
                    <div>
                        <div class="relative flex items-center justify-start pt-4 pb-4 pl-3 pr-3 text-xs">
                            <span>超级早餐</span>
                            <div class="absolute w-4 text-center bg-red-500 rounded-full text-white top-2 right-1">
                                2
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="flex-1 h-full pl-2 pr-2 overflow-hidden bg-white">
                <div class="w-full h-full overflow-x-hidden overflow-y-auto">
                    <div class="w-full h-full p-2">
                        <div class="relative block w-full overflow-hidden translate-x-0 max-h-24 isolate">
                            <img alt="" src="https://img.picui.cn/free/2024/07/05/66874648daf32.png">
                            <div class="absolute bottom-0 left-0 right-0 t-0"></div>
                        </div>
                        <div class="w-full pb-16 text-sm">
                            <div class="w-full">
                                <div class="flex items-center pt-3 pb-3 text-gray-500">
                                    <div>
                                        <span>早餐</span>
                                    </div>
                                    <div>
                                        <span>*</span>
                                    </div>
                                </div>
                                <div class="flex flex-col">
                                    <!-- 1 -->
                                    <div class="flex items-center mb-3">
                                        <div>
                                            <img alt="" class="w-16 h-16 mr-2 rounded-sm"
                                                 src="https://img.picui.cn/free/2024/07/05/66874648daf32.png">
                                        </div>
                                        <div
                                                class="flex flex-col items-start justify-between flex-1 h-20 pr-1 overflow-hidden">
                                            <div class="mb-0 text-sm">
                                                <span>瑞克五代</span>
                                            </div>
                                            <div
                                                    class="w-full h-5 overflow-hidden text-xs text-gray-700 text-ellipsis text-nowrap">
                                                <span>缤纷口味，助力你夏天清爽1111111111111</span>
                                            </div>
                                            <div class="flex items-center justify-between w-full">
                                                <div class="font-bold">
                                                    <span>$55.5</span>
                                                </div>
                                                <div class="relative flex items-center justify-between">
                                                    <div
                                                            class="flex items-center justify-center w-5 h-5 border rounded-full">
                                                        <a>-</a>
                                                    </div>
                                                    <div class="pl-1 pr-1">
                                                        <span>1</span>
                                                    </div>
                                                    <div
                                                            class="flex items-center justify-center w-5 h-5 border rounded-full bg-lime-500">
                                                        <a>+</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- 2 -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../order/order-dishes-modal.jsp" %>
    </main>
</div>