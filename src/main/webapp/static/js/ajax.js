(function(global){

    var getdataAjax = function (opts){

        var opts= $.extend({}, opts);

        $.ajax({

            type: opts.methods || 'GET',

            url: opts.url,

            data: opts.params,

            traditional: true,

            success: function(response) {

                var data = response;

                opts.success.apply(opts.context || this, [opts,data]);

            },
            error: function(response) {

                opts.error.apply(opts.context || this, [opts,response]);

            },
            done: function(response) {
                opts.done.apply(opts.context || this, [opts,response]);

            }
        });
    }

    global.getdataAjax = getdataAjax;

})(this)