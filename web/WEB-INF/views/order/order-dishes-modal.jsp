<%@ page contentType="text/html;charset=UTF-8" %>
<div id="modal">
    <div class="fixed inset-0 transition-opacity bg-black bg-opacity-75"></div>

    <div class="box-border fixed z-50 w-11/12 p-0 m-auto ease-in-out rounded-md left-5 top-1/4 bg-slate-200">
        <!--cover-->
        <div class="relative flex items-center justify-center pt-4 pb-4 h-44">
            <img src="https://img.picui.cn/free/2024/07/05/66874648daf32.png" alt=""
                 class="relative inline-block overflow-hidden size-36" id="modal_dish_img">
            <!-- btn -->
            <div class="absolute flex items-center justify-around right-1 top-4" id="modal_btn_exit">
                <img src="https://img.picui.cn/free/2024/07/05/66874648daf32.png" alt=""
                     class="relative inline-block overflow-hidden size-11">
            </div>
        </div>
        <!--detail-->
        <div class="relative block w-full h-full isolate">
            <div class="overflow-hidden">
                <!--basic-->
                <div class="flex flex-col pb-4 pl-3 pr-3">
                    <span class="mb-1 text-sm text-gray-800" id="modal_dish_name">草莓蛋糕</span>
                    <span class="text-xs text-gray-800" id="modal_dish_description">描述</span>
                </div>
                <!--prop-->
                <div class="flex flex-col w-full pt-1 pl-4 pr-4 border-t-2">
                    <!--p1-->
                    <div class="flex flex-col w-full mb-4">
                        <div class="flex items-center justify-start w-full mb-2">
                            <span class="mr-3 text-sm">配料</span>
                        </div>
                        <div class="flex flex-wrap w-full">
                            <div class="pt-1 pb-1 pl-4 pr-4 mb-2 mr-2 text-sm bg-white rounded-md ring-2 ring-lime-500">
                                正常
                            </div>
                            <div class="pt-1 pb-1 pl-4 pr-4 mb-2 mr-2 text-sm bg-white rounded-md">多冰</div>
                        </div>
                    </div>
                </div>
                <!--action-->
                <div class="flex items-center justify-between h-16 pl-3 pr-3 rounded-md bg-slate-50">
                    <!--left-->
                    <div class="flex flex-col justify-center flex-1 mr-3 overflow-hidden">
                        <span class="text-base" id="modal_dish_price">$28</span>
                        <span class="w-full overflow-hidden text-sm text-nowrap text-ellipsis" id="modal_dish_name_long">
                                    标准汉堡
                                </span>
                    </div>
                    <!--btn-->
                    <div class="flex items-center justify-between">
                        <div class="flex items-center justify-center p-0 text-base rounded-lg bg-lime-600" id="modal_dish_add_cart">
                            <span class="p-2 text-white">加入购物车</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function hideModal() {
            $(".modal").hide();
        }
    </script>
</div>