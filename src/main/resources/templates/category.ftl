<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Список категорій продукції</h2>

    <#import "templ/pager.ftl" as c>


    <@c.pager url page/>

    <div class="row row-cols-2 row-cols-md-2 g-4">


<#--        <#if categories??>-->
<#--        <#list categories as category>-->
        <#if page.content??>
        <#list page.content as category>
        <div class="col">
            <div class="card">
                <a href="/category/${category.id}">
                <img src="${category.image}" class="card-img-top" alt="user">
                <div class="card-body text-center">
                    <h5 class="card-title">${category.name}</h5>
                    <p class="card-text">${category.description}</p></div>
                </a>
            </div>
        </div>
        </#list>
        </#if>
    </div>

    <@c.pager url page/>


</@p.page>