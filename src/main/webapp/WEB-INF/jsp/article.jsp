<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="static/css/global.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="logo" href="/">
            <svg width="36" height="36" class="tanuki-logo">
                <path class="tanuki-shape tanuki-left-ear" fill="#e24329" d="M2 14l9.38 9v-9l-4-12.28c-.205-.632-1.176-.632-1.38 0z"></path>
                <path class="tanuki-shape tanuki-right-ear" fill="#e24329" d="M34 14l-9.38 9v-9l4-12.28c.205-.632 1.176-.632 1.38 0z"></path>
                <path class="tanuki-shape tanuki-nose" fill="#e24329" d="M18,34.38 3,14 33,14 Z"></path>
                <path class="tanuki-shape tanuki-left-eye" fill="#fc6d26" d="M18,34.38 11.38,14 2,14 6,25Z"></path>
                <path class="tanuki-shape tanuki-right-eye" fill="#fc6d26" d="M18,34.38 24.62,14 34,14 30,25Z"></path>
                <path class="tanuki-shape tanuki-left-cheek" fill="#fca326" d="M2 14L.1 20.16c-.18.565 0 1.2.5 1.56l17.42 12.66z"></path>
                <path class="tanuki-shape tanuki-right-cheek" fill="#fca326" d="M34 14l1.9 6.16c.18.565 0 1.2-.5 1.56L18 34.38z"></path>
            </svg>
        </a>
        <ul class="layui-nav doob-nav">
            <li class="layui-nav-item layui-hide-xs layui-this"><a href="">ITEM1</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">ITEM2</a></li>
            <li class="layui-nav-item layui-hide-xs">
                <a href="javascript:;">ITEM3</a>
                <dl class="layui-nav-child">
                    <dd><a href="">移动模块</a></dd>
                    <dd><a href="">后台模版</a></dd>
                    <dd class="layui-this"><a href="">选中项</a></dd>
                    <dd><a href="">电商平台</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="">个人中心<span class="layui-badge-dot"></span></a>
            </li>
        </ul>
    </div>
</div>
<div class="layui-container" style="margin-top: 10px;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box">
                <h1>layui 2.2.5 发布，常规更新</h1>
                <div class="fly-detail-info">
                    <span class="layui-badge layui-bg-green fly-detail-column"> 动态 </span>
                    <span class="layui-badge" style="background-color: #999;">未结</span>
                    <span class="layui-badge layui-bg-black">置顶</span>
                    <div class="fly-admin-box" data-id="22389"> </div>
                    <span class="fly-list-nums">
                        <a href="#comment">
                            <i class="iconfont" title="回答"></i> 102
                        </a>
                        <i class="iconfont" title="人气"></i> 6147
                    </span>
                </div>
                <div class="detail-about">
                    <a class="fly-avatar" href="/u/168/">
                        <img src="./static/img/336.jpg" alt="贤心">
                    </a>
                    <div class="fly-detail-user">
                        <a href="/u/168/" class="fly-link">
                            <cite>贤心</cite> <i class="iconfont icon-renzheng" title="认证信息：layui作者"></i>
                        </a>
                        <span>6天前</span>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="22389">
                        <span style="padding-right: 10px; color: #FF7200">悬赏：20飞吻</span>
                        <span class="layui-btn layui-btn-xs jie-admin " type="collect" data-type="add">收藏</span>
                    </div>
                </div>
                <div class="detail-body layui-text photos"> 首页下载：
                    <a href="http://www.layui.com/" target="_blank">http://www.layui.com/</a>
                    <br><br>
                    <a href="http://www.layui.com/doc/base/changelog.html" target="_blank">更新日志</a>
                    <br>
                    <div class="layui-elem-quote">
                        # v2.2.5<br> * 新增 table 的 templet 方法支持，即现在自定义模板可以采用方法的形式替代内容<br> * 新增 table 的 text 参数，用于自定义各种默认提示文本，以便回收利用<br> * 新增 layui.factory(modName) 方法，用于获取模块对应的工厂<br> * 新增 layui.sessionData(table, settings) 方法，用于存储本地会话性数据<br> * 新增用于定义按钮容器的 class 选择器：layui-btn-container<br> * 新增用于定义流体按钮的 class 选择器：layui-btn-fluid<br> <br> * 优化 table 的分页栏，如果无数据则不显示<br> * 优化 layer 的 prompt 层，初始赋值 value 时的光标会出现在最后（之前版本会在最前）<br> * 优化 layui.event() 和 layui.onevent() 方法，处理自定义事件更加灵活<br> * 优化 layui.router() 方法，新增返回拼接后的 href<br> <br> * 修复 table 的异步数据在 code 为非0时，未执行 done 回调的问题<br> * 修复 element.tabChange() 方法的 this 指向问题</div>
                </div>
                <div class="layui-btn-group layui-btn-group-100">
                    <button class="layui-btn layui-btn-primary layui-btn-8"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-8"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-8"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-8"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-34"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-34"><i class="layui-icon"></i></button>
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
        </div>
    </div>
</div>

<div class="fly-footer">
    <p><a href="http://fly.layui.com/">Alimg</a> 2018 © <a href="http://www.alimg.com/">alimg.com</a></p>
    <p class="fly-union"> <span>Power by</span> <a href="http://www.layui.com/" target="_blank"><img src="./static/img/logo.png" width="66px"></a>  </p>
</div>

<script src="static/layui/layui.js" charset="utf-8"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
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