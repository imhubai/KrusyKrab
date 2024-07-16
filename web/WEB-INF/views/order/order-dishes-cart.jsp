<%@ page contentType="text/html;charset=UTF-8" %>
<!-- cart -->
<div class="absolute z-40 flex items-center justify-between bg-white shadow-xl bottom-16 left-4 right-4 h-9 rounded-2xl ring-1 ring-gray-800"  id="order-dishes-cart">
    <div class="box-border relative block pl-4 mr-3">
        <!-- img-->
        <div onclick="cartPopup()" class="relative inline-block m-0 -mt-4 overflow-hidden">
            <svg t="1720948213801" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7110" width="48" height="48"><path d="M186.1632 122.88h651.6736C884.08064 122.88 921.6 159.5392 921.6 204.8c0 2.8672-0.16384 5.7344-0.45056 8.58112l-54.31296 504.38144C855.6544 822.00576 765.7472 901.12 658.55488 901.12H365.44512c-107.17184 0-197.05856-79.13472-208.2816-183.35744L102.87104 213.38112c-4.85376-44.99456 28.52864-85.31968 74.5472-90.05056 2.90816-0.3072 5.8368-0.45056 8.76544-0.45056zM667.648 819.2a131.072 131.072 0 0 0 131.072-131.072 32.768 32.768 0 1 0-65.536 0 65.536 65.536 0 0 1-65.536 65.536 32.768 32.768 0 1 0 0 65.536zM327.68 245.76a184.32 184.32 0 0 0 368.64 0 40.96 40.96 0 1 0-81.92 0 102.4 102.4 0 0 1-204.8 0 40.96 40.96 0 1 0-81.92 0z" p-id="7111" fill="#18912b"></path></svg>
        </div>
        <!-- tag-->
        <div id="cart_count" class="invisible absolute flex items-center justify-center w-4 h-4 p-1 text-xs bg-yellow-500 rounded-full -right-1 -top-4 opacity-90">
            0</div>
    </div>
    <!-- price-->
    <div id="cart_price" class="flex-1 text-gray-900">总价: 0 元</div>
    <!-- pay-->
    <div onclick="cartComplete()" class="flex items-center h-full pl-3 pr-3 text-sm text-white rounded-r-2xl bg-lime-600">去结算</div>
</div>