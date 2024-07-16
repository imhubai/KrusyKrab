<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box-border relative block w-full h-full ">
    <%@include file="../order/order-title.jsp" %>
    <div class="box-border block w-full h-full bg-stone-200">
        <div class="box-border flex flex-col w-full pt-4 pb-0 pl-4 pr-4">
            <c:forEach items="${orderList}" var="list">
            <div class="box-border block mb-4" onclick="getDetail('${list.oid}')">
                <div class="box-border relative items-center w-full pt-2 pb-2 pl-4 pr-4 overflow-hidden text-sm text-gray-900 bg-white">
                    <div class="box-border flex items-center w-full border-b-2 border-b-black">
                        <div class="box-border flex flex-col flex-1 ">
                            <div class="box-border block mb-2 text-sm text-black font-bold">${list.action}</div>
                            <div class="box-border block text-xs text-black ">订单号:${list.oid}</div>
                            <div></div>
                        </div>
                        <div class="box-border block text-sm text-green-400">${list.orderState}</div>
                    </div>
                </div>
                <div class="box-border relative flex items-center w-full pt-2 pb-4 pl-4 pr-4 overflow-hidden text-sm text-black bg-white">
                    <div class="box-border flex flex-col w-full">
                        <div class="box-border block w-full mb-2 overflow-hidden text-sm text-black whitespace-nowrap">
                            </div>
                        <div class="box-border flex items-center justify-between mb-2">
                            <div class="box-border block text-sm text-black">${list.orderTime}</div>
                            <div class="box-border flex font-bold">
                                <div class="box-border block mr-1 text-base">${list.payment},实付</div>
                                <div class="box-border block text-base">¥${list.orderPrice}</div>
                                <div class="box-border block mr-2 text-base">元</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>