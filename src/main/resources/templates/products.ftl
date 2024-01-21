<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Список продукції</h2>


    <div class="row row-cols-2 row-cols-md-3 g-4">

        <#if productByCategory??>
            <#list productByCategory as product>

                <form action="/addItemToCart" method="post">
                <div class="col">
                    <div class="card">
                        <input type="hidden" name="id" value="${product.id}">
                            <img src="${product.image}" class="card-img-top" alt="user">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-text">${product.description}</p>
                                <p class="card-text">${product.price}</p>
                                <p class="card-text">
                                    <input type="number" name="quantity" value="1" min="0" size="1">
                                </p>
                            </div>
                        <button type="submit">Add to Cart</button>
                        </a>
                    </div>
                </div>
                </form>


            </#list>
        </#if>
    </div>


</@p.page>