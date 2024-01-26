<#macro pager url page>

<nav aria-label="Page navigation example">
    <ul class="pagination">

        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous" tabindex="-1">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <#list 1..page.getTotalPages() as p>
        <#if (p-1)==page.getNumber()>
        <li class="page-item">
            <a class="page-link" href="#" tabindex="-1">${p}</a></li>
        <#else>
        <li class="page-item">
            <a class="page-link" href="${url}?page=${p-1}" tabindex="-1" aria-label="Next">
                <span aria-hidden="true">${p}</span>
            </a>
        </li>
        </#if>
        </#list>
    </ul>
</nav>

</#macro>