<#import "view/templ.ftl" as page>
<@page.pages>
    <h1> Products admin </h1>

    <hr>

    <h2> List Products </h2>
    <ul>
        <#if products??>
            <#list products as product>
                <li>
                    ${product.id + "; " + product.name + "; " + product.description +"; " + product.price + " грн. ; " + product.categories}
                </li>
            </#list>
        </#if>
    </ul>

    <hr>
    <h2> Save New Product To DB</h2>

    <form action="/saveProductToDb" method="post">

        <input type="text" name="name" placeholder="name"> <br>
        <input type="text" name="description" placeholder="description"> <br>
        <input type="number" name="price" placeholder="price"> <br>
        <input type="text" name="image" placeholder="image"> <br>
        <#--        <input type="text" name="categoryId" placeholder="name"> <br>-->

        <select name="categoryId">
            <#if categories??>
                <#list categories as category>
                    <option value="${category.id}">${category.name}</option>
                </#list>
            </#if>
        </select>

        <input type="submit" value="add">
    </form>

    <hr>

    <h2> Update / Delete Product </h2>

    <table class="table">
        <thead>
        <tr>
<#--            <th>id</th>-->
            <th>name</th>
            <th>description</th>
            <th>price</th>
            <th>category</th>
            <th>image</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <#if products??>
            <#list products as product>
                <tr>
                    <form action="/updateProduct" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <td><input type="text" name="name" value="${product.name}"></td>
                    <td><input type="text" name="description" value="${product.description}"></td>
                    <td><input type="number" name="price" value="${product.price?c}"></td>

                        <td>
                            <select name="categoryId">
                            <#if categories??>
                                <#list categories as category>
                                    <#if category.id==product.categories.id>
                                        <option value="${category.id}" selected>${category.name}</option>
                                    <#else>
                                        <option value="${category.id}">${category.name}</option>
                                    </#if>
                                </#list>
                            </#if>

                            </select>
                        </td>

                    <td><input type="text" name="image" value="${product.image}"></td>
                    <td>
                        <input type="submit" value="update">
                    </td>
                    </form>
                    <td>
                    <form method="post" action="/deleteProduct">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="submit" value="delete">
                    </form>
                    </td>
                </tr>
            </#list>
        </#if>

        </tbody>

    </table>




</@page.pages>