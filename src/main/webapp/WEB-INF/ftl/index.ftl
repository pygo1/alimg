<#include "include/web/head.ftl">
<body>
<#include "include/web/header.ftl">

<div class="layui-container" style="margin-top: 10px;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel">
                <div class="fly-panel-title fly-filter">
                    <a>置顶</a>
                </div>
                <ul class="fly-list">
                <#list articleTopList as article>
                    <#include "include/web/articleItem.ftl">
                </#list>
                </ul>
            </div>

            <div class="fly-panel">

                <div class="fly-panel-title fly-filter">
                    <a href="/column/all/" class="layui-this">综合</a>
                    <#--<span class="fly-mid"></span>-->
                    <#--<a href="/column/all/unsolved/">未结</a>-->
                </div>
                <ul class="fly-list flow-default" id="list-content" style="overflow-y: scroll;height:550px;">
                <#--<#list articleList as article>-->
                    <#--<#include "include/web/articleItem.ftl">-->
                <#--</#list>-->
                </ul>
                <#--<div style="text-align: center">-->
                    <#--<div class="laypage-main">-->
                        <#--<a class="laypage-next">更多</a>-->
                    <#--</div>-->
                <#--</div>-->
            </div>

        </div>
        <div class="layui-col-md4">

            <#include "include/web/notice.ftl">

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

    layui.use(['element','layer','flow'], function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        var layer = layui.layer; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){
            console.log(elem)
            layer.msg(elem.text());
        });
        var flow = layui.flow;

        flow.load({
            elem: '#list-content' //流加载容器
            ,scrollElem: '#list-content'
            ,done: function(page, next){ //执行下一页的回调
                getdataAjax({
                    methods:"POST",
                    url:"/page/article/" + (page) + "?item=0&search=",
                    context:this,
                    success:function(param,res) {
                        var data = res.data;
                        common.prettyTime(data,["createTime"])
                        common.getTmp({
                            html:"article.html",
                            data:{
                                msg:data
                            },
                            callback:function(err,res){
                                next(res, page < Math.ceil(${articleCount}/8));
                            }
                        });
                    }
                })
            }
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