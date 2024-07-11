<%@ page contentType="text/html;charset=UTF-8" %>
<div id="edit_card" hidden="hidden">
    <div class="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity" aria-hidden="true"></div>
    <div class="flex items-center fixed inset-0 z-0 justify-center align-center">
        <div class="border-2 rounded-lg border-white border-dashed px-6 py-3 mb-8 bg-gray-900 shadow-md dark:bg-gray-800">
            <h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">
                编辑商品
            </h4>

            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品ID</span>
                <input id="edit_card_productid" name="productId"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>

            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品名称</span>
                <input id="edit_card_productname" name="productName"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>

            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品图片</span>
                <input id="edit_card_productimg" name="productImg"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>

            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品价格</span>
                <input id="edit_card_productprice" name="productPrice"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>
            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品类型</span>
                <input id="edit_card_producttype" name="productType"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>
            <label class="block text-xs">
                <span class="text-gray-700 dark:text-gray-400">产品描述</span>
                <input id="edit_card_productdescription" name="productDescription"
                       class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                       placeholder=""/>
            </label>
            <div class="mt-4 text-sm">
                    <span class="text-gray-700 dark:text-gray-400">
                        产品标签
                    </span>
                <div class="mt-2">
                    <label class="inline-flex items-center text-gray-600 dark:text-gray-400">
                        <input id="edit_card_producttags0"
                               class="text-purple-600 form-radio focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                               name="productTags" type="radio" value="0"/>
                        <span class="ml-2">很辣</span>
                    </label>
                    <label class="inline-flex items-center ml-6 text-gray-600 dark:text-gray-400">
                        <input id="edit_card_producttags1"
                               class="text-purple-600 form-radio focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                               name="productTags" type="radio" value="1"/>
                        <span class="ml-2">微辣</span>
                    </label>
                    <label class="inline-flex items-center ml-6 text-gray-600 dark:text-gray-400">
                        <input id="edit_card_producttags2"
                               class="text-purple-600 form-radio focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                               name="productTags" type="radio" value="2"/>
                        <span class="ml-2">不辣</span>
                    </label>
                </div>
            </div>
            <div class="flex justify-end mt-2 ">
                <button id="edit_card_cancel_button" onclick="hideEditCard()"
                        class="px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 border border-transparent rounded-lg bg-stone-600 active:bg-stone-600 hover:bg-stone-700 focus:outline-none focus:shadow-outline-purple">
                    取消
                </button>
                <button id="edit_card_ok_button" onclick="updateProduct(this)"
                        class="px-4 py-2 ml-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    function hideEditCard() {
        $("#edit_card").fadeOut();
    }
</script>