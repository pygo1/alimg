<div class="fly-panel">
    <h3 class="fly-panel-title">公告</h3>
    <ul class="fly-panel-main fly-list-static">
        <#list notice as item>
            <li>
                <a href="/a/${item.id}" target="_blank">${item.title}</a>
            </li>
        </#list>
    </ul>
</div>