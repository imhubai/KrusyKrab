<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN" class="overflow-hidden">
<head>
    <title>蟹堡王点餐系统</title>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <%@include file="../order/order-include.jsp" %>
</head>

<body class="select-none overflow-hidden">
<%@include file="../order/order-dishes.jsp" %>
<%@include file="../order/order-footer.jsp" %>
</body>
<script>
    function switchAction(action) {
        let ts = $("#btn_ts");
        let ws = $("#btn_ws");
        if (action === "2") {
            ts.removeClass();
            ws.removeClass();
            ts.addClass("pl-2 pr-2");
            $("#btn_top_group").removeClass("pr-2");
            ws.addClass("pt-1 pb-1 pl-2 pr-2 rounded-2xl bg-lime-400");
            cart.action = "外送";
        } else {
            ws.removeClass();
            ts.removeClass();
            $("#btn_top_group").addClass("pr-2");
            ts.addClass("pt-1 pb-1 pl-2 pr-2 rounded-2xl bg-lime-400 mr-2");
            cart.action = "堂食";
        }
    }

    function Item(productId, productName, productImg, productPrice, productType, productDescription, productTags, productCount) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productTags = productTags;
        this.productCount = productCount || 0;
    }

    function Cart() {
        this.items = {};
        this.count = 0;
        this.price = 0;
        this.action = "堂食";
    }

    Cart.prototype.addItem = function (item, quantity) {
        if (!this.items[item.productId]) this.items[item.productId] = Object.assign({}, item);
        if (this.items[item.productId].productTags !== item.productTags) this.items[item.productId].productTags += "+" + item.productTags;
        this.items[item.productId].productCount += quantity;
        this.count += quantity;
        this.price = math.format(
            math.chain(math.bignumber(this.price))
                .add(math.bignumber(this.items[item.productId].productPrice * quantity))
                .done()
        )
    };

    Cart.prototype.removeItem = function (itemId, quantity) {
        if (this.items[itemId]) {
            this.items[itemId].productCount -= quantity;
            this.count -= quantity;
            this.price = math.format(
                math.chain(math.bignumber(this.price))
                    .subtract(math.bignumber(this.items[itemId].productPrice * quantity))
                    .done()
            )
            if (this.items[itemId].productCount <= 0) delete this.items[itemId];
        }
    };

    Cart.prototype.listItems = function () {
        for (const itemId in this.items) {
            if (this.items.hasOwnProperty(itemId)) {
                const item = this.items[itemId];
                console.log('物品ID: ' + item.productId + ', 名称: ' + item.productName + ', 数量: ' + this.count);
            }
        }
    };

    const cart = new Cart();

    function switchShop() {
        $.ajax({
            url: "${pageContext.servletContext.contextPath}/order/switchShop",
            type: "post",
            success: function (data) {
                if (data == 200) {
                    window.location.href = "${pageContext.servletContext.contextPath}/order";
                }
            }
        });
    }

    function addItem(obj) {
        const productId = $(obj).data('id');
        $(obj).attr("id", "selectedItem");
        $.ajax({
            url: "getProduct",
            type: "post",
            data: {
                productId: productId
            },
            success: function (data) {
                let product = JSON.parse(data);
                $("#modal_dish_name").text(product.productName);
                $("#modal_dish_price").text(product.productPrice + " 元");
                $("#modal_dish_img").attr("src", product.productImg);
                $("#modal_dish_description").text(product.productDescription);
                let props = product.productTags.split(" ");
                let propsdiv = $("#modal_dish_props");
                propsdiv.empty();
                $.each(props, function (index, value) {
                    if (index === 0) {
                        $("#modal_dish_add_cart").attr("data-prop", props[0]);
                        propsdiv.append("<div onclick='updateProps(this)' class='pp pt-1 pb-1 pl-4 pr-4 mb-2 mr-2 text-sm bg-white rounded-md ring-2 ring-lime-500'>" + value + "</div>");
                    } else {
                        propsdiv.append("<div onclick='updateProps(this)' class='pp pt-1 pb-1 pl-4 pr-4 mb-2 mr-2 text-sm bg-white rounded-md ring-lime-500'>" + value + "</div>");
                    }
                })
                $.ajax({
                    url: "getProductTypeName",
                    type: "post",
                    data: {
                        productId: productId
                    },
                    success: function (data) {
                        $("#modal_dish_name_long").text(data);
                    }
                })
                $("#modal").show();
                $("#modal_dish_add_cart").attr("data-obj", JSON.stringify(product));
            }
        })
    }

    function updateProps(obj) {
        $(".pp").each(
            function () {
                $(this).removeClass("ring-2");
            }
        );
        $(obj).addClass("ring-2");
        $("#modal_dish_add_cart").attr("data-prop", $(obj).text());
    }

    function cartConfirm(obj) {
        const productData = $(obj).attr('data-obj');
        const product = JSON.parse(productData);
        product.productTags = $("#modal_dish_add_cart").attr("data-prop");
        const item1 = new Item(product.productId, product.productName, product.productImg, product.productPrice, product.productType, product.productDescription, product.productTags);
        cart.addItem(item1, 1);
        updateDisplay($('#selectedItem'));
        hideModal();
    }

    function reduceItem(obj) {
        const productId = $(obj).data('id');
        if (cart.items[productId].productCount > 0) {
            cart.removeItem(productId, 1);
            updateDisplay(obj);
        }
    }

    function updateDisplay(obj) {
        const productId = $(obj).data('id');
        const quantityElement = $(obj).siblings('.count').find('span');
        let quantity = 0;
        if (typeof (cart.items[productId]) == "undefined") {
            quantityElement.text(0);
        } else {
            quantityElement.text(cart.items[productId].productCount);
            quantity = parseInt(quantityElement.text(), 10);
        }
        if (quantity <= 0) {
            $("#cart_count").addClass('invisible');
            $(obj).addClass('invisible');
            $(obj).siblings('.count').addClass('invisible');
        } else {
            $("#cart_count").text(cart.count);
            $("#cart_count").removeClass('invisible');
            $(obj).siblings('.btn_reduce').removeClass('invisible');
            $(obj).siblings('.count').removeClass('invisible');
        }
        $("#cart_price").text("总价: " + cart.price + " 元");
    }

    function cartComplete() {
        if (cart.count <= 0) {
            alert("啊？不选东西就结算吗");
        } else {
            $.ajax({
                url: "${pageContext.servletContext.contextPath}/order/addOrder",
                type: "post",
                data: {
                    cart: JSON.stringify(cart)
                },
                success: function (data) {
                    $("body").html(data);
                }
            })
        }
    }

    function cartPopup() {
        $("#cart_popup_detail").empty();
        let str = "";
        for (const itemId in cart.items) {
            if (cart.items.hasOwnProperty(itemId)) {
                const item = cart.items[itemId];
                let p = math.format(
                    math.chain(math.bignumber(item.productPrice))
                        .multiply(math.bignumber(item.productCount))
                        .done()
                );
                str += '<div class="flex flex-row justify-between items-center">';
                str += '<span>' + item.productName + ' ' + item.productTags + ' * ' + item.productCount + '</span>';
                str += '<span>¥ ' + p + '</span></div>';
            }
        }
        $("#cart_popup_detail").append(str);
        $("#cart_modal").show();
    }

    $(function () {
        $("#btn_order").addClass("font-bold");
    });
</script>
</html>
