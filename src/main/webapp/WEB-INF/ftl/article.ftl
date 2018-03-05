<#include "include/web/head.ftl">
<body>
<#include "include/web/header.ftl">
<div class="layui-container" style="margin-top: 10px;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box">
                <h1>${article.title}</h1>
                <div class="fly-detail-info">
                    <#list article.item as item>
                        <a class="layui-badge layui-bg-gray fly-detail-column" href="/i/${item.name}">
                        ${item.name}
                        </a>
                    </#list>

                    <#list article.tag as tag>
                        <a class="layui-badge layui-bg-green fly-detail-column" href="/t/${tag.name}">
                        ${tag.name}
                        </a>
                    </#list>
                    <div class="fly-admin-box" data-id="22389"> </div>
                    <span class="fly-list-nums">
                        <i class="iconfont" title="阅览"></i>${article.click}
                    </span>
                </div>
                <div class="detail-about">
                    <a class="fly-avatar" href="/u/${article.authorId}">
                        <img src="${article.user.img}" alt="${article.user.name}">
                    </a>
                    <div class="fly-detail-user">
                        <a href="/u/${article.authorId}" class="fly-link">
                            <cite>${article.user.name}</cite>
                            <i class="iconfont icon-renzheng" title="认证信息：${article.user.info}"></i>
                        </a>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="22389">
                        <span style="padding-right: 10px; color: #FF7200">发布时间:</span>
                        <span><@timeline_dt datetime= article.createTime/></span>
                    </div>
                </div>
                <div class="detail-body layui-text photos">${article.content}</div>
                <hr class="layui-bg-black">


                <div class="fly-panel">
                    <div class="fly-panel-title fly-filter">
                        <a>相关&推荐</a>
                    </div>
                    <ul class="fly-list">
                    <#list articleTopList as article>
                        <#include "include/web/articleItem.ftl">
                    </#list>
                    </ul>
                </div>


            </div>
        </div>
        <div class="layui-col-md4">
            <div class="fly-panel">
                <h3 class="fly-panel-title">温馨通道</h3>
                <ul class="fly-panel-main fly-list-static">
                    <li>
                        <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云) 仓库，欢迎Star</a>
                    </li>
                    <li>
                        <a href="http://fly.layui.com/jie/5366/" target="_blank"> layui 常见问题的处理和实用干货集锦 </a>
                    </li>
                </ul>
            </div>
            <#include "include/web/itemCloud.ftl">
        </div>
    </div>
</div>

<div class="fly-footer">
    <p><a href="http://fly.layui.com/">Alimg</a> 2018 © <a href="http://www.alimg.com/">alimg.com</a></p>
    <p class="fly-union"> <span>Power by</span> <a href="http://www.layui.com/" target="_blank"><img src="/static/img/logo.png" width="66px"></a>  </p>
</div>

<script src="/static/layui/layui.js" charset="utf-8"></script>
<script src="/static/js/ajax.js"></script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
    $(function () {
        $(".tanuki-logo path").hover(function () {
            $(this).css("opacity","0.1")
        },function () {
            $(this).css("opacity","1")
        })
    })
</script>

</body>
</html>