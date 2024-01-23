<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Реєстрація користувача в системі </h2>


    <@spring.bind "users"/>

    <form method="post" action="/registration">

        <label>Логін</label><br>
        <@spring.formInput "users.username"/>
        <@spring.showErrors "<br>"/><br>

        <label>Пароль</label><br>
        <@spring.formInput "users.password"/>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "clients"/>

        <label>Ім'я</label><br>
        <@spring.formInput "clients.firstName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Прізвище</label><br>
        <@spring.formInput "clients.lastName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Телефон</label><br>
        <@spring.formInput "clients.phone"/>
        <@spring.showErrors "<br>"/><br>

        <label>Вік</label><br>
        <@spring.formInput "clients.age"/>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label><br>
        <@spring.formInput "clients.email"/>
        <@spring.showErrors "<br>"/><br>

        <button type="submit">Add</button>
    </form>


</@p.page>