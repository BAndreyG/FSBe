$(function() {
    let catName='';
    $.each($('.catName'),function () {
        catName+=this.innerText+"; ";
    });
  catName=catName.substr(0,catName.length-1);
    $('#category').val(catName);
    let url=$(location).attr('href')+'/';
    $('.foto').click(function () {

    });
    $('input[type=file]').change(function(){
        files = this.files;
        linkImg="/resources/images/petr.jpg";
        $('img').attr('src',files[0].name);
        alert("test file");
    });

    $('#save').click(function () {
        let profileObj=new Object();
        let list=$('.list-group-item');
        $.each(list,function () {
            profileObj[this.id]=this.value;
        })
        post(url,profileObj);
    });

    $('#delete').click(function () {
        let data=$('#userid')[0].value;
        del(url,data,null,null);
    });

    let post=function (url,data) {
        return $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: url,
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json"
        });
    };

    let del = function(url, data, callback, type){ //
        if ( $.isFunction(data) ){
            type = type || callback,
                callback = data,
                data = {}
        }
        return $.ajax({
            url: url+data,
            method: "DELETE",
            success: function(data) {
                console.log('data');
            }
        });
    };

});