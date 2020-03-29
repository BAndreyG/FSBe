$(function () {
    let catName = '';
    files=null;
    $.each($('.catName'), function () {
        catName += this.innerText + "; ";
    });
    catName = catName.substr(0, catName.length - 1);
    $('#category').val(catName);

    let url = $(location).attr('href') + '/';

    document.getElementById("foto").src ="data:image/jpg;base64," +$('#fotoData')[0].value;

        $('input[type=file]').change(function () {
        // files = this.files[0];
        linkImg = "/resources/images/petr.jpg";
        // $('img').attr('src',files[0].name);
        // $('#foto').value()=files[0].name;
    });

    function readFile() {
        if (this.files && this.files[0]) {
            var FR = new FileReader()
            FR.addEventListener("load", function (e) {
                document.getElementById("foto").src = e.target.result;
                files = e.target.result;
                // $('#fotoData').value()=e.target.result;
            });
            FR.readAsDataURL(this.files[0]);
        }
    };
    document.getElementById("inp").addEventListener("change", readFile);

    $('#save').click(function () {
        if (invalidetForm()===true){
            let profileObj = new Object();
            let list = $('.list-group-item');
            $.each(list, function () {
                profileObj[this.id] = this.value;
            });
            profileObj['foto'] = files;
            post(url, profileObj);
        }
    });

    $('#delete').click(function () {
        let data = $('#userid')[0].value;
        del(url, data, null, null);
    });

    let post = function (url, data) {
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

    let del = function (url, data, callback, type) { //
        if ($.isFunction(data)) {
            type = type || callback,
                callback = data,
                data = {}
        }
        return $.ajax({
            url: url + data,
            method: "DELETE",
            success: function (data) {
                console.log('data');
            }
        });
    };

    let invalidetForm =function(){
        let formParam=$('.list-group');
        let alertFio="Нужнно ввести не менее 2-х символов в этом поле";
        // alert($('#gender')[0].value.toLowerCase().indexOf("м")!=0&&$('#gender')[0].value.toLowerCase().indexOf("ж")!=0);
        if ($('#surname')[0].value.length<2){
            $('#surname').focus();
            alert(alertFio);
            return false;
        } else if ($('#name')[0].value.length<2){
            $('#name').focus();
            alert(alertFio);
            return false;
        }else if ($('#patronymic')[0].value.length<2){
            $('#patronymic').focus();
            alert(alertFio);
            return false;
        }else if ($('#password')[0].value.length<3){
            $('#password').focus();
            alert("Пароль должен быть не менне 3 символов");
            return false;
        }else if ($('#gender')[0].value.toLowerCase().indexOf("м")!=0&&$('#gender')[0].value.toLowerCase().indexOf("ж")!=0){
            $('#gender').focus();
            alert("Если Вы мужского пола введите \"м\" ,если женского, то \"ж\" (без кавычек).");
            return false;
        }
        // alert("Ошибка заполнения");
        return true;
    }
});