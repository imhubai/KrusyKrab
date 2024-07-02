<%@ page contentType="text/html;charset=UTF-8" %>
<div id="toast" hidden="hidden">
    <div class="m-auto absolute bottom-0 right-0 flex px-5 py-5 z-30">
        <div class="p-3 bg-white border border-gray-300 rounded-lg shadow-lg">
            <div class="flex flex-row">
                <div class="px-2">
                    <svg width="24" height="24" viewBox="0 0 1792 1792" fill="#44C997"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M1299 813l-422 422q-19 19-45 19t-45-19l-294-294q-19-19-19-45t19-45l102-102q19-19 45-19t45 19l147 147 275-275q19-19 45-19t45 19l102 102q19 19 19 45t-19 45zm141 83q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"></path>
                    </svg>
                </div>
                <div class="ml-2 mr-6">
                    <span id="toast-title" class="font-semibold">T</span>
                    <span id="toast-content" class="block text-gray-500">T</span>
                </div>
            </div>
        </div>
    </div>
</div>