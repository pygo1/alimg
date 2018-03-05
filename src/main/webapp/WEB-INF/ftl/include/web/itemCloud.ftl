<link rel="stylesheet" type="text/css" href="/static/jqcloud/jqcloud.css" />
<script type="text/javascript" src="/static/jqcloud/jqcloud-1.0.4.js"></script>

<div class="fly-panel">
    <h3 class="fly-panel-title">标签云</h3>
    <div id="example">

    </div>
</div>

<script>

    $(function() {
        var word_array = [
            <#list tagsCloud as tag>
                {text: "${tag.name}", weight: ${tag.count},link:"/t/${tag.name}"},
            </#list>
        ];
        // When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
        $("#example").jQCloud(word_array, {
            width: 300,
            height: 200
        });
    });
</script>