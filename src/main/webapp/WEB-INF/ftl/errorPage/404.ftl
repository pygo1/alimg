<#include "include/web/head.ftl">
<body>
<#include "include/web/header.ftl">

<div style="padding: 50px 0; height: 600px; text-align: center;">
    <h1>
        <i class="layui-icon" style="line-height: 500px; font-size: 500px; color: #393D50;"></i>
    </h1>
    <p style="font-size: 20px; font-weight: 300; color: #999;">好干净的页面啊，什么都没有的样子</p>
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