<%@ page contentType="text/html;charset=UTF-8" %>
<div class="bg-gray-100" id="dialog-cookies">
    <div class="fixed bottom-0 left-0 w-full bg-white border-t border-gray-200 shadow">
        <div class="container mx-auto px-4 py-2 flex justify-between items-center">
            <p class="text-sm text-gray-700">该网站使用Cookies技术为您提供更好的服务。
                <a href="#" class="text-blue-500">查看详情</a></p>
            <div class="flex space-x-4">
                <button onclick="close_dialog_cookies()"
                        class="px-4 py-1.5 bg-blue-500 text-white rounded hover:bg-blue-600 transition duration-300 ease-in-out">
                    同意
                </button>
                <button onclick="close_dialog_cookies()"
                        class="px-4 py-1.5 bg-gray-300 text-gray-700 rounded hover:bg-gray-400 transition duration-300 ease-in-out">
                    拒绝
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    function close_dialog_cookies() {
        $('#dialog-cookies').fadeOut();
        setTimeout(function () {
            $("#dialog-cookies").remove();
        }, 2000);
    }
</script>