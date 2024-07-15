<%@ page contentType="text/html;charset=UTF-8" %>
<div id="modal" class="hidden">
    <div class="fixed inset-0 transition-opacity bg-black bg-opacity-75"></div>

    <div class="box-border fixed z-50 w-11/12 p-0 m-auto ease-in-out rounded-md left-5 top-1/4 bg-slate-200">
        <!--cover-->
        <div class="relative flex items-center justify-center pt-4 pb-4 h-44">
            <img src="https://img.picui.cn/free/2024/07/05/66874648daf32.png" alt=""
                 class="relative inline-block overflow-hidden size-36" id="modal_dish_img">
            <!-- btn -->
            <div onclick="hideModal()" class="absolute flex items-center justify-around right-1 top-4"
                 id="modal_btn_exit">
                <svg t="1720959498497" class="icon" viewBox="0 0 1024 1024" version="1.1"
                     xmlns="http://www.w3.org/2000/svg" p-id="4249" width="16" height="16">
                    <path d="M1003.401416 20.47758a69.809932 69.809932 0 0 1 4.840155 93.405688l-4.793615 5.305555L610.604201 511.939498l392.797215 392.797215a69.809932 69.809932 0 0 1-93.452228 103.504858l-5.305555-4.793615L511.939498 610.604201l-392.797215 392.797215a69.809932 69.809932 0 0 1-93.405688 4.793615L20.47758 1003.401416a69.809932 69.809932 0 0 1-4.793615-93.452228l4.793615-5.305555L413.274795 511.939498 20.43104 119.142283A69.809932 69.809932 0 0 1 113.883268 15.683965L119.142283 20.47758 511.939498 413.274795l392.797215-392.797215a69.809932 69.809932 0 0 1 98.664703 0z"
                          fill="#000000" p-id="4250"></path>
                </svg>
            </div>
        </div>
        <!--detail-->
        <div class="relative block w-full h-full isolate">
            <div class="overflow-hidden">
                <!--basic-->
                <div class="flex flex-col pb-4 pl-3 pr-3">
                    <span class="mb-1 text-base font-bold text-gray-800" id="modal_dish_name"></span>
                    <span class="text-xs text-gray-800" id="modal_dish_description"></span>
                </div>
                <!--prop-->
                <div class="flex flex-col w-full pt-1 pl-4 pr-4 border-t-2">
                    <!--p1-->
                    <div class="flex flex-col w-full mb-4">
                        <div class="flex items-center justify-start w-full mb-2">
                            <span class="mr-3 text-sm">配料</span>
                        </div>
                        <div id="modal_dish_props" class="flex flex-wrap w-full">
                        </div>
                    </div>
                </div>
                <!--action-->
                <div class="flex items-center justify-between h-16 pl-3 pr-3 rounded-md bg-slate-50">
                    <!--left-->
                    <div class="flex flex-col justify-center flex-1 mr-3 overflow-hidden">
                        <span class="text-base" id="modal_dish_price"></span>
                        <span class="w-full overflow-hidden text-sm text-nowrap text-ellipsis"
                              id="modal_dish_name_long">
                                    标准
                                </span>
                    </div>
                    <!--btn-->
                    <div class="flex items-center justify-between">
                        <div onclick="cartConfirm(this)"
                             class="flex items-center justify-center p-0 text-base rounded-lg hover:ring-2 ring-lime-700 bg-lime-600"
                             id="modal_dish_add_cart">
                            <span class="p-2 text-white">加入购物车</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function hideModal() {
            $("#modal").hide();
            $('#selectedItem').attr("id", "");
        }
    </script>
</div>