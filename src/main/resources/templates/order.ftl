<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Сторінка замовлення товарів </h2>

<#--    <h4> ${user} </h4>-->

    <#if client.firstName??>
        <p> Ім'я клієнта: <b> ${client.firstName}</b></p>
        <p> Прізвище клієнта:<b>  ${client.lastName}</b></p>
        <p> Телефон :<b>  ${client.phone} </b></p>
        <p> Email :<b>  ${client.email} </b></p>
    </#if>

    <#if cart??>

        <table class="table table-striped">
        <thead>
        <tr>
            <th>image</th>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            <th>value</th>
        </tr>

        </thead>
        <tbody>

        <#list cart as item>
            <tr>
                <th><img src="${item.product.image}" height="25px" alt="${item.product.name}"></th>
                <td>${item.product.id}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.quantity * item.product.price}</td>
            </tr>
        </#list>
    </#if>

    </tbody>
    </table>
    <h5><b><i> Вартість купівлі продукції: ${total} </i></b></h5>

    <form action="/buy" method="post">
        <hr>
        <h4> Оплати </h4>
        <select name="payment">
            <option value="1"> Готівка</option>
            <option value="2"> Безготівковий розрахунок</option>
        </select>

        <hr>
        <h4> Доставка </h4>
        <select name="delivery">
            <option value="1"> Нова пошта</option>
            <option value="2"> Самовивіз</option>
            <option value="3"> Укрпошта</option>
        </select>

        <hr>
        <button class="btn btn-success" type="submit">Підтвердити замовлення</button>
    </form>

</@p.page>