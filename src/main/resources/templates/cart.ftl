<#import "templ/templ.ftl" as p>
<@p.page>

    <h2> Кошик товарів</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>image</th>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            <th>value</th>
            <th>update</th>
            <th>delete</th>
        </tr>

        </thead>
        <tbody>

        <#if cart??>
            <#list cart as item>
                <tr>
                    <th><img src="${item.product.image}" height="25px" alt="${item.product.name}"></th>
                    <td>${item.product.id}</td>
                    <td>${item.product.name}</td>
                    <td>${item.product.price}</td>
                    <form action="/updateProductFromCart" method="post">
                        <input type="hidden" name="id" value="${item.product.id}">
                        <td><input type="number" name="quantity" value="${item.quantity}"></td>
                        <td>${item.quantity * item.product.price}</td>
                        <td>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </td>
                    </form>

                    <td>
                        <form action="/deleteProductFromCart" method="post">
                        <input type="hidden" name="id" value="${item.product.id}">
                        <button type="submit" class="btn btn-success">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <h5><b><i> Вартість купівлі продукції: [ ${total} ] </i></b></h5>
    <h5><b><i> Кількість позицій у кошику: [ ${sum} ] </i></b></h5>

    <h6> Очистити кошик </h6>

    <h6> <a href="/category"> Повернутись до каталогу </a></h6>

    <h6> Оформлення замовлення </h6>


</@p.page>