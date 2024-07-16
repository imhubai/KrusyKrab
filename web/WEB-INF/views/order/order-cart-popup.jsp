<%@ page contentType="text/html;charset=UTF-8" %>
<div id="cart_modal" hidden>
    <div onclick="hideCartModal()" class="fixed inset-0 transition-opacity bg-black bg-opacity-75"></div>

    <div class="box-border fixed z-50 w-11/12 p-0 m-auto ease-in-out rounded-md left-5 top-1/4 bg-slate-200">
        <div onclick="hideCartModal()" class="absolute flex items-center justify-end right-1 top-4">
            <svg t="1720959498497" class="icon" viewBox="0 0 1024 1024" version="1.1"
                 xmlns="http://www.w3.org/2000/svg" p-id="4249" width="16" height="16">
                <path d="M1003.401416 20.47758a69.809932 69.809932 0 0 1 4.840155 93.405688l-4.793615 5.305555L610.604201 511.939498l392.797215 392.797215a69.809932 69.809932 0 0 1-93.452228 103.504858l-5.305555-4.793615L511.939498 610.604201l-392.797215 392.797215a69.809932 69.809932 0 0 1-93.405688 4.793615L20.47758 1003.401416a69.809932 69.809932 0 0 1-4.793615-93.452228l4.793615-5.305555L413.274795 511.939498 20.43104 119.142283A69.809932 69.809932 0 0 1 113.883268 15.683965L119.142283 20.47758 511.939498 413.274795l392.797215-392.797215a69.809932 69.809932 0 0 1 98.664703 0z"
                      fill="#000000" p-id="4250"></path>
            </svg>
        </div>
        <!--detail-->
        <div id="cart_popup_detail" class="mt-10 flex flex-col m-2 pr-6 relative block w-full h-full isolate overflow-y-auto overflow-x-hidden">

        </div>
        <script>
            function hideCartModal() {
                $("#cart_modal").hide();
            }
        </script>
    </div>
</div>