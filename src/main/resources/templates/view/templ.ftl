<#macro pages>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<h1> Manager Page </h1>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <p> Shop 2024 </p>
            <#include "navbar.ftl"/>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-12 col-sm-4">
            <#include "leftmenu.ftl"/>
        </div>

        <div class="col-12 col-sm-8">
            <#nested/>
        </div>
    </div>

    <div class="row">
        <#include "footer.ftl"/>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
</#macro>