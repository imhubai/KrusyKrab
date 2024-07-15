<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--interface-->
<div class="container relative w-full h-screen overflow-hidden">
    <main class="relative flex flex-col w-full h-full">
        <%@include file="../order/order-title.jsp" %>
        <div class="flex flex-col flex-shrink-0 h-auto">
            <div class="flex items-center justify-between w-full h-auto p-3 bg-white">
                <div class="flex flex-col flex-1" onclick="switchShop()">
                    <div class="flex items-center justify-start mb-1">
                        <span>${shop.shopName}</span>
                    </div>
                    <div class="flex items-center justify-start text-xs text-gray-600">
                        <span>${shop.shopAddress}</span>
                    </div>
                </div>
                <div id="btn_top_group" class="flex items-center bg-gray-100 rounded-2xl ring-1 ring-gray-800 pr-2">
                    <div class="text-sm">
                        <button id="btn_ts" onclick="switchAction('1')" class="pt-1 pb-1 pl-2 pr-2 rounded-2xl bg-lime-400 mr-2">堂食</button>
                    </div>
                    <div class="text-sm">
                        <button id="btn_ws" onclick="switchAction('2')">外送</button>
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
        <!--left bar-->
        <div class="flex flex-1 w-full mb-16 overflow-hidden">
            <div class="w-fit h-full overflow-hidden bg-slate-50">
                <div class="w-full h-full overflow-x-hidden overflow-y-auto scroll-smooth pb-16">
                    <c:forEach items="${productTypes}" var="productTypes">
                        <div id="productType-${productTypes.typeId}"
                             class="relative flex items-center justify-start pt-4 pb-4 pl-3 pr-3 text-xs"
                             onclick="chooseType('${productTypes}')">
                            <span>${productTypes.typeName}</span>
                            <div class="absolute w-4 text-center bg-red-500 rounded-full text-white top-2 right-1">
                                <span id="productType-count-${productTypes.typeId}"></span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="flex-1 h-full pl-2 pr-2 overflow-hidden bg-white pb-10">
                <div class="w-full h-full overflow-x-hidden overflow-y-auto scroll-smooth">
                    <div class="relative block w-full overflow-hidden translate-x-0 max-h-24 isolate">
                        <img alt="" src="https://img.picui.cn/free/2024/07/05/66874648daf32.png">
                        <div class="absolute bottom-0 left-0 right-0 t-0"></div>
                    </div>
                    <div class="w-full h-full flex flex-col justify-start p-2">
                        <c:forEach items="${productTypes}" var="productTypes">
                            <div class="flex items-center pt-3 pb-3 text-gray-900">
                                <div><span>${productTypes.typeName}</span></div>
                                <div><span></span></div>
                            </div>
                            <c:forEach items="${productTypes.products}" var="products">
                                <div class="flex items-center mb-2">
                                    <div>
                                        <img alt="${products.productName}" class="w-16 h-16 mr-2 rounded-sm"
                                             src="${products.productImg}">
                                    </div>
                                    <div class="flex flex-col items-start justify-between flex-1 h-20 pr-1 overflow-hidden">
                                        <div class="mb-0 text-sm">
                                            <span>${products.productName}</span>
                                        </div>
                                        <div class="w-full h-5 overflow-hidden text-xs text-gray-700 text-ellipsis text-nowrap">
                                            <span>${products.productDescription}</span>
                                        </div>
                                        <div class="flex items-center justify-between w-full">
                                            <div class="font-bold">
                                                <span>¥${products.productPrice}</span>
                                            </div>
                                            <div class="relative flex items-center justify-between">
                                                <div data-id="${products.productId}" onclick="reduceItem(this)"
                                                     class="ring-1 ring-black btn_reduce flex items-center justify-center w-5 h-5 rounded-full invisible">
                                                    <a>-</a>
                                                </div>
                                                <div data-id="${products.productId}" class="pl-1 pr-1 count invisible">
                                                    <span>0</span>
                                                </div>
                                                <div data-id="${products.productId}" onclick="addItem(this)"
                                                     class="ring-1 ring-black btn_increase flex items-center justify-center w-5 h-5 rounded-full bg-lime-500">
                                                    <a>+</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../order/order-dishes-modal.jsp" %>
        <%@include file="../order/order-dishes-cart.jsp" %>
        <%@include file="../order/order-cart-popup.jsp" %>
    </main>
</div>