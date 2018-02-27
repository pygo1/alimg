(function(global) {
    nunjucks.configure('../static/temp', {
        web:{
            async:true
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
    global.common = {
        getQueryString: getQueryString,
        stringFormat: stringFormat,
        getTmp:getTmp,
        trackMouse:trackMouse,
        loading:loading,
        delHtmlTag:delHtmlTag
    };

})(this)