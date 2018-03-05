<#include "./include/admin/head.ftl">
<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

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
                            <span class="am-icon-code"></span> 发布文章
                        </div>
                        <div class="caption font-green bold" style="float: right;padding:0;">
                            <button id="publish" type="button" class="am-btn am-btn-primary">发布</button>
                        </div>
                    </div>
                    <div class="tpl-block ">

                        <div class="am-g tpl-amazeui-form">


                            <div class="am-u-sm-12 am-u-md-9">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">标题 / Name</label>
                                        <div class="am-u-sm-9">
                                            <input value="${article.id}" type="hidden" id="article-id">
                                            <input value="${article.title}" type="text" id="article-title" placeholder="标题 / Name">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-email" class="am-u-sm-3 am-form-label">栏目 / Item</label>
                                        <div class="am-u-sm-9">
                                            <select multiple data-am-selected="{btnSize: 'sm',btnWidth:'100%'}" id="article-item">
                                                <#list itemList as list>
                                                    <option value="${list.id}">${list.name}</option>
                                                    <#if list.children >
                                                        <#list list.children as child>
                                                            <option value="${child.id}">${child.name}</option>
                                                        </#list>
                                                    </#if>
                                                </#list>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">标签 / Tag</label>
                                        <div class="am-u-sm-9">
                                            <input value="<#list article.tag as tag><#if tag_index == 0>${tag.name}<#else >,${tag.name}</#if></#list>" type="text" id="article-tag" placeholder="标签 / Tag[Tag1,Tag2,Tag3]">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-QQ" class="am-u-sm-3 am-form-label">发布时间</label>
                                        <div class="am-u-sm-9">
                                            <input value="${article.createTime?string('yyyy-MM-dd hh:mm:ss')}" type="text"id ="article-publishTime" onClick="WdatePicker({position:{left:0,top:-70},el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="发布时间">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-weibo" class="am-u-sm-3 am-form-label">等级 / Level</label>
                                        <div class="am-u-sm-9">
                                            <input value="${article.level}" type="text" id="article-level" placeholder="等级 / Level[0,1,2,3... 高~低]">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div style="width:100%; margin:auto">
                        <textarea style="width:100%;height:500px;" id="editor">${article.content}</textarea>
                    </div>
                </div>
                <#--<script id="editor" type="text/plain" style="width:100%;"/>-->
            </div>
        </div>
        <script src="/static/layui/layui.js" charset="utf-8"></script>
        <script src="/static/assets/js/amazeui.min.js"></script>
        <script src="/static/dp/WdatePicker.js"></script>
        <script src="/static/js/ajax.js"></script>
     <script>
         var item = [];
         <#list article.item as article_item>
            item.push(JSON.parse('{"id":"${article_item.id}","name":"${article_item.name}"}'));
         </#list>
         for(var i = 0;i<item.length;i++){
             $("#article-item option[value="+item[i]["id"]+"]").prop("selected","selected");
         }
         //实例化编辑器
         //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
         var ue = UE.getEditor('editor');
         $(function () {
             $("#publish").click(function () {
                 getdataAjax({
                     methods:"POST",
                     url:"/admin/article/modify/" + $("#article-id").val(),
                     params:{
                         data:JSON.stringify({
                             title: $("#article-title").val(),
                             item: $("#article-item").val(),
                             tag: $("#article-tag").val(),
                             createTime: $("#article-publishTime").val(),
                             level: $("#article-level").val(),
                             content: ue.getContent()
                         })
                     },
                     context:this,
                     success:function(param,res) {
                         if(res.success == true){
                             window.location.href ="/admin/article"
                         }else{
                             //处理登录错误
                         }
                     }
                 })
             })
         })
    </script>
</body>

</html>