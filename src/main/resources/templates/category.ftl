<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Список категорій продукції</h2>


    <div class="row row-cols-2 row-cols-md-2 g-4">

        <#if categories??>
        <#list categories as category>
        <div class="col">
            <div class="card">
                <a href="/category/${category.id}">
                <img src="${category.image}" class="card-img-top" alt="user">
                <div class="card-body">
                    <h5 class="card-title">${category.name}</h5>
                    <p class="card-text">${category.description}</p></div>
                </a>
            </div>
        </div>
        </#list>
        </#if>
    </div>


</@p.page>