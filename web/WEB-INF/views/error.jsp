<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>蟹堡王</title>
    <%@include file="common/common-include.jsp" %>
</head>
<body>
<%@include file="common/common-nav.jsp" %>
<div class="grid min-h-full grid-cols-1 grid-rows-[1fr,auto,1fr] bg-white lg:grid-cols-[max(50%,36rem),1fr]">
    <main class="mx-auto w-full max-w-7xl px-6 py-24 sm:py-32 lg:col-span-2 lg:col-start-1 lg:row-start-2 lg:px-8">
        <div class="max-w-lg">
            <p class="text-base font-semibold leading-8 text-cyan-600">404</p>
            <h1 class="mt-4 text-3xl font-bold tracking-tight text-gray-900 sm:text-5xl">组件不存在</h1>
            <p class="mt-6 text-base leading-7 text-gray-600">抱歉，该界面可能去追水母了。</p>
            <div class="mt-10">
                <a href="index" class="text-sm font-semibold leading-7 text-teal-600"><span aria-hidden="true">&larr;</span>
                    返回主页</a>
            </div>
        </div>
    </main>
    <footer class="self-end lg:col-span-2 lg:col-start-1 lg:row-start-3">
        <div class="border-t border-gray-100 bg-gray-50 py-10">
            <nav class="mx-auto flex w-full max-w-7xl items-center gap-x-4 px-6 text-sm leading-7 text-gray-600 lg:px-8">
                <a href="#">Damn</a>
                <svg viewBox="0 0 2 2" aria-hidden="true" class="h-0.5 w-0.5 fill-gray-300">
                    <circle cx="1" cy="1" r="1"></circle>
                </svg>
                <a href="#">F**k</a>
            </nav>
        </div>
    </footer>
    <div class="hidden lg:relative lg:col-start-2 lg:row-start-1 lg:row-end-4 lg:block">
        <img src="https://images.newscientist.com/wp-content/uploads/2020/02/25113425/fnb1ej_web.jpg" alt=""
             class="absolute inset-0 h-full w-full object-cover">
    </div>
</div>
<%@include file="common/common-footer.jsp" %>
</body>
</html>