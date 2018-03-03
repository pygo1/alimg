
<#include "./include/admin/head.ftl">
<style>
    #page .layui-laypage input {
        display: inline-block;
        width: 40px;
        margin: 0 10px;
        padding: 0 3px;
        text-align: center;
    }
</style>

<body data-type="index">


    <header class="am-topbar am-topbar-inverse admin-header">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-left admin-header-list tpl-header-list">
            <li style="padding: 0 5px;">
                <a style="color:#000;float: left;" href="/admin/postArticle"><span class="am-icon-bell-o"></span>发布文章</a>
                <a style="color:#000;float: left;" href="/admin/article"><span class="am-icon-bell-o"></span>文章列表</a>
            </li>
        </ul>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">${user.name}</span><span class="tpl-header-list-user-ico"> <img src="${user.img}"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="#" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>
    <div class="tpl-page-container tpl-page-header-fixed">

        <div class="tpl-content-wrapper">
            <div class="row">
                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 列表
                        </div>
                    </div>
                    <div class="tpl-block">
                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-form-group">
                                    <select id="itemList" data-am-selected="{btnSize: 'sm'}">
                                        <option value="0">所有类别</option>
                                        <#list itemList as list>
                                            <option value="${list.id}">${list.name}</option>
                                            <#if list.children >
                                                <#list list.children as child>
                                                    <option value="${child.id}">${child.name}</option>
                                                </#list>
                                            </#if>
                                            </li>
                                        </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-input-group am-input-group-sm">
                                    <input id="search_input" type="text" class="am-form-field">
                                    <span class="am-input-group-btn">
                                        <button id="search_button" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="am-g">
                            <div class="am-u-sm-12">
                                <form class="am-form">
                                    <table class="am-table am-table-striped am-table-hover table-main">
                                        <thead>
                                        <tr>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">标题</th>
                                            <th class="table-type">类别</th>
                                            <th class="table-author am-hide-sm-only">作者</th>
                                            <th class="table-date am-hide-sm-only">修改日期</th>
                                            <th class="table-set">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody id="article-tr">
                                        <#list articleList as article>
                                            <tr>
                                                <td>${article.id}</td>
                                                <td><a href="/a/${article.id}">${article.title}</a></td>
                                                <td>
                                                    <#list article.item as item>
                                                        ${item.name} &nbsp;
                                                    </#list>
                                                </td>
                                                <td class="am-hide-sm-only">${article.user.name}</td>
                                                <td class="am-hide-sm-only">${article.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>
                                                <td>
                                                    <div class="am-btn-toolbar">
                                                        <div article_id="${article.id}" class="am-btn-group am-btn-group-xs">
                                                            <button type="button" class="am-btn am-btn-default am-btn-xs editor-article"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                                            <button type="button" class="am-btn am-btn-default am-btn-xs delete-article"><span class="am-icon-trash-o"></span> 删除</button>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                    <div class="am-cf">
                                        <div id="page"></div>
                                    </div>
                                    <hr>

                                </form>
                            </div>

                        </div>
                    </div>
                    <div class="tpl-alert"></div>
                </div>
            </div>
        </div>
    <script src="/static/layui/layui.js" charset="utf-8"></script>
    <script src="/static/assets/js/amazeui.min.js"></script>
    <script src="/static/dp/WdatePicker.js"></script>
    <script src="/static/js/ajax.js"></script>
     <script>
         layui.use(['laypage', 'layer'], function(){
             var laypage = layui.laypage
                     ,layer = layui.layer;

             //调用分页
             paging(${articleCount});
             function paging(count) {
                 laypage.render({
                     elem: 'page'
                     ,count:count
                     //,layout: ['count', 'prev', 'next', 'skip']
                     ,limit:8
                     ,jump: function(obj,first){
                         if(!first){
                             getdataAjax({
                                 methods:"POST",
                                 url:"/admin/page/article/" + obj.curr + "?item="+$("#itemList").val()+"&search=",
                                 context:this,
                                 success:function(param,res) {
                                     var data = res.data;
                                     common.getTmp({
                                         html:"article1.html",
                                         data:{
                                             msg:data
                                         },
                                         callback:function(err,res){
                                             $("#article-tr").html(res);
                                         }
                                     });
                                 }
                             })
                         }
                     }
                 });
             }

             $("#itemList").on("change",function () {
                 var item = $(this).val();
                 getdataAjax({
                     methods:"POST",
                     url:"/admin/page/article/1?item="+item+"&search=",
                     context:this,
                     success:function(param,res) {
                         var data = res.data;
                         common.getTmp({
                             html:"article1.html",
                             data:{
                                 msg:data
                             },
                             callback:function(err,res){
                                 $("#article-tr").html(res);
                             }
                         });
                     }
                 })
                 getdataAjax({
                     methods:"POST",
                     url:"/admin/page/article/count/"+item,
                     context:this,
                     success:function(param,res) {
                         var data = res.data;
                         paging(data);
                     }
                 })
             })

             $("#search_button").click(function(){
                 var item = $("#itemList").val();
                 var search = $("#search_input").val();
                 getdataAjax({
                     methods:"POST",
                     url:"/admin/page/article/1?item="+item+"&search="+search,
                     context:this,
                     success:function(param,res) {
                         var data = res.data;
                         common.getTmp({
                             html:"article1.html",
                             data:{
                                 msg:data
                             },
                             callback:function(err,res){
                                 $("#article-tr").html(res);
                             }
                         });
                     }
                 })
                 getdataAjax({
                     methods:"POST",
                     url:"/admin/page/article/count/"+item+"?search="+search,
                     context:this,
                     success:function(param,res) {
                         var data = res.data;
                         paging(data);
                     }
                 })
             });
             $("body").on("click",".editor-article",function(){
                 var id = $(this).parent().attr("article_id");
                 window.location.href = "/admin/article/modify/" + id;
             })
             $("body").on("click",".copy-article",function(){

             })
             $("body").on("click",".delete-article",function(){
                 _self = $(this)
                 var id = $(this).parent().attr("article_id");
                 layer.confirm('确定删除该条新闻？', {
                     btn: ['取消','删除'] //按钮
                 }, function(){
                     layer.closeAll();
                 }, function(){
                     var load = layer.load(1, {
                         shade: [0.1,'#fff'] //0.1透明度的白色背景
                     });
                     getdataAjax({
                         methods:"POST",
                         url:"/admin/article/delete/"+id,
                         context:this,
                         success:function(param,res) {
                             layer.close(load);
                             if(res.success == true){
                                 _self.parents("tr").remove();
                             }else{
                                 //处理登录错误
                             }
                         }
                     })
                 });
             })

         });

    </script>
</body>

</html>