(function(global) {
    nunjucks.configure('../static/temp', {
        web:{
            async:true
        }
    });
    moment.locale('en', {
        relativeTime : {
            future: "%s后",
            past:   "%s前",
            s:  "秒",
            m:  "一分钟",
            mm: "%d分钟",
            h:  "一小时",
            hh: "%d小时",
            d:  "一天",
            dd: "%d天",
            M:  "一个月",
            MM: "%d月",
            y:  "一年",
            yy: "%d年"
        }
    });

    function getTmp(opts){
        var self=this;
        var tmp = $.extend({}, opts);

        nunjucks.render(tmp.html,tmp.data,function(err, res){opts.callback.apply(opts.context || self, [err,res])});

    }

    function trackMouse(opts){
        opts.elem.hover(function(){
            $.trackMouse(opts.html);
        },function(){
            $.trackMouse().reset();
        });
    }

    function getQueryString(key) {

        var reg = new RegExp("(^|&)"+ key +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);

        if(r!=null)return  decodeURI(r[2]); return null;
    }

    function stringFormat() {

        if (arguments.length === 0) {

            return null;
        }

        var str = arguments[0];
        for (var i = 1, length = arguments.length; i < length; i++) {

            var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
            str = str.replace(re, arguments[i]);
        }
        return str;
    }
    function loading(el,top){
        var width=$(el).width();
        $(el).html("<img style='width:16px;height:16px;position:relative;left:"+(width/2-8)+"px;top:"+top+"px;' src='./images/loading.gif'>");
    }
    function delHtmlTag(str) {
        return  str.replace(/<[^>]+>/g,"").replace(/&nbsp;/g,"").replace(/&lt;/g,"").replace(/&lt;/g,"");//鍘绘帀鎵€鏈夌殑html鏍囪
    }
    function prettyTime(data,item) {
        for(var n = 0; n<data.length;n++){
            for(var i = 0;i < item.length;i++){
                data[n][item[i]] = moment(data[n][item[i]]).fromNow();
            }
        }
    }
    global.common = {
        getQueryString: getQueryString,
        stringFormat: stringFormat,
        getTmp:getTmp,
        trackMouse:trackMouse,
        loading:loading,
        delHtmlTag:delHtmlTag,
        prettyTime:prettyTime
    };

})(this)