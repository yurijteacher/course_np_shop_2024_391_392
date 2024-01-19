<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Аутентифікація користувача в системі </h2>

    <form method="post" action="/login">

        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="login"><br>
        <br>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="pass">

<#--        <input type="submit" value="Add">-->
        <button type="submit">Add</button>
    </form>
    <hr>
    <br>
    <a href="/registration">registration</a>

</@p.page>