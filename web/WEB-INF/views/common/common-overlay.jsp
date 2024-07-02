<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    .overlay {
        background-color: #000;
        width: 100%;
        height: 100%;
        overflow: hidden;
        position: fixed;
        display: flex;
        justify-content: center;
        align-items: center;
        left: 0;
        top: 0;
        z-index: 999
    }

    .overlay > #loadinglogo {
        animation-name: fadeinout;
        animation-duration: 2s;
        animation-iteration-count: infinite;
        transition-timing-function: ease-in-out;

    }

    @keyframes fadeinout {
        0% {
            transform: scale(1);
        }

        25% {
            transform: scale(1.08);
        }

        50% {
            transform: scale(1);
        }

        75% {
            transform: scale(1.08);
        }
    }
</style>
<body>
<div class="overlay">
    <img id="loadinglogo" src="${pageContext.servletContext.contextPath}/res/img/logo.png" alt="logo">
</div>
<script>
    // console.log("%c ", "background: url(http://g.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3e770bd00d868ba61ea9d345f2.jpg) no-repeat center;padding-left:80px;padding-bottom: 80px;border-radius:50%;");
    console.log("visit hugongzi.top for further information ~");

    window.onload = function () {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    };
    $(function () {
        setTimeout(function () {
            $(".overlay").fadeOut();
        }, 1000);
    })
    $(window).load(function () {
        $(".overlay").fadeOut();
    });
</script>
</body>