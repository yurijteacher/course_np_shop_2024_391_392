<#import "view/templ.ftl" as page>

<@page.pages>
    <h1> Categories admin </h1>
    <hr>

    <h2> List Category </h2>
    <ul>
        <#if categories??>
            <#list categories as category>
                <li>${category.name + " " + category.description + " " + category.image }</li>
            </#list>
        </#if>
    </ul>

    <hr>

    <h2> Save New Category </h2>
    <form method="post" action="/saveNewCategory">

        <input type="text" name="name" placeholder="name"><br>
        <input type="text" name="description" placeholder="description"><br>
        <input type="text" name="image" placeholder="image"><br>

        <input type="submit" value="add">
    </form>

    <hr>

    <h2> Update / Delete </h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>images</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <#if categories??>
            <#list categories as category>
                <tr>
                    <form method="post" action="/updateCategory">
                        <td><input type="number" name="id" value="${category.id}"></td>
                        <td><input type="text" name="name" value="${category.name}"></td>
                        <td><input type="text" name="description" value="${category.description}"></td>
                        <td><input type="text" name="linkCategory" value="${category.image}"></td>
                        <td>
                            <input type="submit" value="update">
                        </td>
                    </form>
                    <td>
                        <form method="post" action="/deleteCategory">
                            <input type="hidden" name="id" value="${category.id}">
                            <input type="submit" value="delete">
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>
    <hr>

</@page.pages>