<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="box-border block w-full h-full">
    <div class="block w-full h-full">
        <%@ include file="order-title.jsp" %>
        <div class="relative block">
            <div class="box-border block w-full h-full text-gray-600">
                <div class="box-border block w-full h-full p-2">
                    <div class="box-border block pb-20 bg-white">
                        <div class="box-border relative block overflow-y-auto shadow-md">
                            <c:if test="${obj.orderState == '已出餐'}">
                                <div id="dynamic_area" class="flex items-center justify-center flex-auto p-1">
                                    <div class="p-1 pl-2 text-2xl font-bold text-black ">
                                        待取餐
                                    </div>
                                    <div class="p-2 pr-2 text-2xl font-bold text-lime-800">
                                            ${obj.number}
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${obj.orderState == '待出餐'}">
                                <div id="dynamic_area" class="flex items-center justify-center flex-auto p-1">
                                    <div class="p-1 pl-2 text-2xl font-bold text-black ">
                                        待出餐
                                    </div>
                                    <div class="p-2 pr-2 text-2xl font-bold text-lime-800">
                                        预计10分钟
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${obj.orderState == '待支付'}">
                                <div id="dynamic_area" class="flex items-center justify-center flex-auto p-1">
                                    <div class="p-1 pl-2 text-2xl font-bold text-black ">
                                        待支付订单
                                    </div>
                                    <div class="p-2 pr-2 text-2xl font-bold text-lime-800">
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${obj.orderState != '待支付' && obj.orderState != '已出餐' && obj.orderState != '待出餐'}">
                                <div id="dynamic_area" class="flex items-center justify-center flex-auto p-1">
                                    <div class="p-1 pl-2 text-2xl font-bold text-black ">
                                        ${obj.orderState}
                                    </div>
                                    <div class="p-2 pr-2 text-2xl font-bold text-lime-800">
                                        ${obj.number}
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <div class="box-border relative block overflow-y-auto shadow-md">
                            <!-- 地址位置开始 -->
                            <div
                                    class="box-border relative flex items-center w-full overflow-hidden border-b-2 border-b-black">
                                <div
                                        class="box-border relative flex items-center w-full pt-2 pb-2 pl-2 pr-2 overflow-hidden text-base text-gray-500 bg-white">
                                    <div class="box-border flex items-center w-full">
                                        <div class="box-border flex flex-col w-3/5">
                                            <div
                                                    class="block w-full mb-2 overflow-hidden text-base font-bold text-gray-900 text-ellipsis whitespace-nowrap">
                                                ${shopName}
                                            </div>
                                            <div
                                                    class="flex flex-row items-center justify-start w-full overflow-hidden">
                                                <div
                                                        class="relative flex-shrink-0 inline-block overflow-hidden size-7">
                                                    <svg t="1721011348610" class="icon" viewBox="0 0 1024 1024"
                                                         version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5172"
                                                         width="20" height="20">
                                                        <path
                                                                d="M811.084 578.703l-279.442 417.501c-5.482 8.227-14.684 13.148-24.557 13.148l-0.002 0c-9.818 0-19.041-4.927-24.557-13.127l-279.307-416.421c-34.029-54.436-51.751-116.094-51.751-179.049 0-189.898 159.406-344.416 355.359-344.416 195.927 0 355.359 154.508 355.359 344.416 0 62.864-17.669 124.398-51.088 177.949l0 0zM506.829 115.917c-163.293 0-296.128 127.782-296.128 284.842 0 51.751 14.606 102.412 42.17 146.556l254.208 378.977 254.4-380.022c26.976-43.239 41.484-93.845 41.484-145.498 0-157.055-132.853-284.842-296.117-284.842l0 0zM506.829 563.263c-92.846 0-168.368-73.486-168.368-163.827 0-90.292 75.523-163.791 168.368-163.791 92.846 0 168.359 73.474 168.359 163.791 0 90.315-75.506 163.827-168.359 163.827l0 0zM506.829 295.219c-60.212 0-109.156 46.774-109.156 104.239 0 57.471 48.953 104.239 109.156 104.239 60.195 0 109.143-46.766 109.143-104.239 0-57.461-48.953-104.239-109.143-104.239l0 0z"
                                                                fill="#272636" p-id="5173"></path>
                                                    </svg>
                                                </div>
                                                <div
                                                        class="box-border block overflow-hidden text-sm text-gray-800 text-ellipsis whitespace-nowrap">
                                                    ${shopAddress}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="flex items-center justify-end w-2/5">
                                            <div data-id="${shopAddress}" class="relative flex items-center justify-center overflow-hidden size-14">
                                                <svg t="1721011582708" class="" viewBox="0 0 1024 1024"
                                                     version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6719"
                                                     width="22" height="22">
                                                    <path
                                                            d="M123.92 555.9a32 32 0 0 1-14.82-60.38l719.19-374.9a32 32 0 0 1 29.59 56.76l-719.2 374.89a31.87 31.87 0 0 1-14.76 3.63z"
                                                            fill="#333333" p-id="6720"></path>
                                                    <path
                                                            d="M608.6 957.7a32 32 0 0 1-30.6-41.27l234.64-776.34a32 32 0 0 1 61.26 18.52L639.22 935a32 32 0 0 1-30.62 22.7zM505.92 580.44c-0.68 0-1.36 0-2.05-0.07l-381.46-24.12a32 32 0 1 1 4-63.88l381.5 24.13a32 32 0 0 1-2 63.94z"
                                                            fill="#333333" p-id="6721"></path>
                                                    <path
                                                            d="M608.14 957.32a32 32 0 0 1-30.87-23.63L475 556.82a32 32 0 1 1 61.77-16.76L639 916.93a32 32 0 0 1-22.51 39.26 31.61 31.61 0 0 1-8.35 1.13z"
                                                            fill="#333333" p-id="6722"></path>
                                                </svg>
                                            </div>
                                            <div data-id="${shopPhone}" class="relative flex items-center justify-center overflow-hidden size-14">
                                                <svg t="1721011905159" class="" viewBox="0 0 1024 1024"
                                                     version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7775"
                                                     width="22" height="22">
                                                    <path d="M217.856 94.677333c-36.608 14.762667-60.928 38.485333-96.597333 83.2-88.618667 111.232-9.386667 332.8 194.730666 535.210667l10.581334 10.368c192 184.576 434.986667 264.533333 527.701333 184.064l3.029333-2.816-1.450666 1.194667a249.301333 249.301333 0 0 0 64.042666-77.994667c33.152-64 24.149333-130.858667-41.173333-182.954667-94.037333-75.008-157.184-77.568-219.434667-20.48l-6.997333 6.570667-18.005333 17.834667c-7.808-1.621333-19.882667-7.338667-34.730667-16.896-29.610667-19.114667-66.517333-50.901333-108.586667-92.586667-41.941333-41.642667-74.069333-78.208-93.312-107.605333l-3.882666-6.101334a120.448 120.448 0 0 1-12.245334-24.832l-0.938666-3.413333 18.133333-17.92 6.613333-6.954667c57.472-61.738667 54.912-124.373333-20.650666-217.642666-51.328-63.36-109.653333-83.328-166.826667-60.245334z m99.925333 113.493334l11.221334 14.08c37.546667 48.682667 37.888 64.853333 16.384 89.258666l-8.32 8.874667-21.12 20.821333c-45.482667 45.056-25.258667 102.314667 41.856 181.205334l14.08 16.085333 15.232 16.682667 8.106666 8.533333 16.981334 17.621333 18.176 18.261334 9.258666 9.130666 18.090667 17.450667 17.408 16.298667c5.717333 5.205333 11.306667 10.24 16.810667 15.104l16.213333 13.909333c79.616 66.56 137.216 86.570667 182.698667 41.685333l21.034666-20.992 5.546667-5.248c24.277333-22.186667 39.296-25.301333 80.725333 3.968l12.586667 9.258667 14.250667 11.093333c31.232 24.917333 34.261333 47.573333 18.602666 77.781334a165.845333 165.845333 0 0 1-26.88 36.608l-7.253333 7.338666-5.546667 5.12-5.333333 4.650667c-14.421333 14.293333-69.888 15.658667-141.184-7.722667-90.709333-29.781333-189.994667-92.074667-280.746667-182.101333-177.109333-175.658667-241.408-355.413333-188.16-422.272 26.453333-33.194667 43.648-49.92 61.653334-57.173333 19.285333-7.808 38.570667-1.194667 67.626666 34.688z"
                                                            fill="#000000" p-id="7776"></path>
                                                </svg>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 地址位置结束 -->
                            <div
                                    class="box-border relative flex items-center w-full pt-3 pb-3 pl-1 pr-1 overflow-x-hidden overflow-y-auto text-base text-gray-500 bg-white border-b-2 border-black">
                                <div class="box-border relative flex flex-col w-full">
                                    <!-- 单个商品信息开始 -->
                                    <c:forEach items="${cartList}" var="v">
                                        <div class="box-border flex items-center w-full mb-1">
                                            <div class="box-border flex flex-col w-3/5 overflow-hidden">
                                                <div class="box-border block mb-1 overflow-hidden text-sm font-bold text-gray-900 text-ellipsis whitespace-nowrap">
                                                        ${v.productName}
                                                </div>
                                                <div class="box-border block overflow-hidden text-xs text-gray-800 text-ellipsis whitespace-nowrap">
                                                        ${v.productTags}
                                                </div>
                                            </div>
                                            <div class="box-border flex items-center justify-between w-2/5">
                                                <div class="box-border block text-base text-gray-700">
                                                    ×${v.productCount}
                                                </div>
                                                <div class="box-border block text-base font-bold text-gray-700">
                                                    ¥${v.productPrice}
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <!-- 单个商品信息结束 -->
                                </div>
                            </div>
                        </div>

                        <div
                                class="box-border relative flex items-center w-full pt-3 pb-3 pl-1 pr-1 overflow-hidden text-base text-gray-700 bg-white">
                            <div class="box-border flex flex-col w-full">
                                <div class="box-border flex items-center justify-between w-full mb-1 text-sm text-gray-700">
                                    <div class="box-border block">合计</div>
                                    <div class="box-border block font-bold">${obj.orderPrice}</div>
                                </div>
                                <div class="box-border flex items-center justify-between w-full mb-1 text-gray-700 text-sn">
                                    <div class="box-border block">取餐方式</div>
                                    <div class="box-border block font-bold">${obj.action}</div>
                                </div>
                                <div class="box-border flex items-center justify-between w-full mb-1 text-sm text-gray-700">
                                    <div class="box-border block">下单时间</div>
                                    <div class="box-border block font-bold">${obj.orderTime}</div>
                                </div>
                                <div class="box-border flex items-center justify-between w-full mb-1 text-sm text-gray-700">
                                    <div class="box-border block">支付方式</div>
                                    <div class="box-border block font-bold">${obj.payment}</div>
                                </div>
                                <div class="box-border flex items-center justify-between w-full mb-1 text-sm text-gray-700">
                                    <div class="box-border block">出餐时间</div>
                                    <div class="box-border block font-bold">${obj.orderOkTime}</div>
                                </div>
                            </div>
                        </div>
                        <div class="flex items-center justify-end w-full text-base">
                            <a data-id="${obj.oid}" onclick="question()"
                               class="flex items-center justify-between mr-1 text-sm font-medium leading-4 text-black transition-colors duration-150 border border-transparent active:bg-lime-600 hover:bg-lime-700 focus:outline-none focus:shadow-outline-lime">
                                订单遇到问题?
                            </a>
                            <a href="${pageContext.servletContext.contextPath}/order"
                                    class="flex items-center justify-between px-4 py-2 mr-1 text-sm font-medium leading-5 text-white transition-colors duration-150 border border-transparent rounded-lg bg-lime-600 active:bg-lime-600 hover:bg-lime-700 focus:outline-none focus:shadow-outline-lime">
                                <span>再来一单</span>
                            </a>
                            <!--test-->
                            <c:if test="${obj.orderState == '待支付'}">
                            <button onclick="back_pay('${obj.oid}')"
                                    class="flex items-center justify-between px-4 py-2 mr-1 text-sm font-medium leading-5 text-white transition-colors duration-150 border border-transparent rounded-lg bg-lime-600 active:bg-lime-600 hover:bg-lime-700 focus:outline-none focus:shadow-outline-lime">
                                <span>返回支付</span>
                            </button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>