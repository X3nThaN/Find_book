function getBooks(){
    $.ajax({
        type: 'GET',
        url: 'action',
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            $("#BookListBlock").empty().append("<div class=\"row text-center book_list_line\">\n" +
                "              <div class=\"col book_list_line_item\" style='display: none'>\n" +
                "                <span style=\"font-weight: bold\">Id</span>\n" +
                "              </div>\n" +
                "              <div class=\"col book_list_line_item\">\n" +
                "                <span style=\"font-weight: bold\">Название</span>\n" +
                "              </div>\n" +
                "              <div class=\"col book_list_line_item\">\n" +
                "                <span style=\"font-weight: bold\">URL-картинки</span>\n" +
                "              </div>\n" +
                "              <div class=\"col book_list_line_item\">\n" +
                "                <span style=\"font-weight: bold\">Описание</span>\n" +
                "              </div>\n" +
                "              <div class=\"col book_list_line_item\">\n" +
                "                <span style=\"font-weight: bold\">Страна</span>\n" +
                "              </div>\n" +
                "              <div class=\"col book_list_line_item\">\n" +
                "                <span style=\"font-weight: bold\">Год издания</span>\n" +
                "            </div>\n" +
                "               <div class='col book_list_line_item'></div>" +
                "          </div>");
            $.each(data, function (key, value) {
                let buff ="";
                $.each(value, function (k,v){
                    buff =buff + v + ",";
                })

                let values = buff.split(",");
                $("#BookListBlock").append("<div class=\"row text-center user_list_line\">\n" +
                    "              <div class=\"col book_list_line_item\" style='display: none'>\n" +
                    "                <span style=\"font-weight: bold\">" + values[0] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                <span style=\"font-weight: bold\">" + values[1] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                <span style=\"font-weight: bold\">" + values[2] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                <span style=\"font-weight: bold\">" + values[3] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                <span style=\"font-weight: bold\">" + values[4] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                <span style=\"font-weight: bold\">" + values[5] + "</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"col book_list_line_item\">\n" +
                    "                 <a href=\"#\" onclick =\"deleteBook(this);\" class=\"\">Удалить</a>\n" +
                    "                 <a href=\"#\" type='submit' onclick =\"editBook(this);\" class=\"\">Ред.</a>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "          </div>");
            });
        },
        error: function (er) {
            console.log(er);
        }
    });
}

function createBook(btn) {
        let id = $("#EditId").val();
        let book_name = $("#book_name").val();
        let img_address = $("#img_address").val();
        let book_description = $("#book_description").val();
        let book_country = $("#book_country").val();
        let book_date = $("#book_date").val();
        let urL = 'action';

        if(validateFields()) {
            $.ajax({
                method: "POST",
                url: urL,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                data:  JSON.stringify({
                    "id" : id,
                    "book_name" : book_name,
                    "img_address" : img_address,
                    "book_description" : book_description,
                    "book_country" : book_country,
                    "book_date" : book_date
                }),
                dataType: 'json',

                success: function(data) {
                    $('#CreateBookSuccess').show(100);
                    setTimeout(hideMessage, 3000);
                    getBooks();
                },
                error: function(er) {
                    console.log(er);
                    $('#CreateBookFault').show(100);
                    setTimeout(hideMessage, 3000);
                }
            });
        }

        else {
            $('#CreateBookFault').show(100);
            setTimeout(hideMessage, 3000);
        }
}
function validateFields() {
        if($("#book_name").val() === "") return false;
        if($("#img_address").val() === "") return false;
        if($("#book_description").val() === "") return false;
        if($("#book_country").val() === "") return false;
        if($("#book_date").val() === "") return false;

        return true;
}function validateFieldsEdit() {
    if($("#Edit_book_name").val() === "") return false;
    if($("#Edit_img_address").val() === "") return false;
    if($("#Edit_book_description").val() === "") return false;
    if($("#Edit_book_country").val() === "") return false;
    if($("#Edit_book_date").val() === "") return false;

    return true;
}

function hideMessage() {
        $("#CreateBookSuccess").hide();
        $("#CreateBookFault").hide();
}

function updateBook(btn){
    let id = $("#EditId").val();
    let book_name = $("#Edit_book_name").val();
    let img_address = $("#Edit_img_address").val();
    let book_description = $("#Edit_book_description").val();
    let book_country = $("#Edit_book_country").val();
    let book_date = $("#Edit_book_date").val();
    if(validateFieldsEdit()){
        $.ajax({
            method: "POST",
            url: "edit",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data:  JSON.stringify({"id" : id,
                "book_name" : book_name,
                "img_address" : img_address,
                "book_description" : book_description,
                "book_country" : book_country,
                "book_date" : book_date
            }),
            dataType: 'json',

            success: function(data) {
                $('#CreateBookSuccess').show(100);
                setTimeout(hideMessage, 3000);
                getBooks();
                back();
            },
            error: function(er) {
                console.log(er);
                $('#CreateBookFault').show(100);
                setTimeout(hideMessage, 3000);
            }
        });
    }else{
        $('#CreateBookFault').show(100);
        setTimeout(hideMessage, 3000);
    }

}
function deleteBook(btn){
    let id = $(btn).parent().parent().find(':first-child').find('span').text();
    $.ajax({
        method: "POST",
        url: "delete",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({"id" : id}),
        dataType: 'json',

        success: function(data) {
            getBooks();
        },
        error: function(er) {
            console.log(er);
        }
    });

}
function editBook(btn){
    let a = $(btn).parent().parent();
    let id = a.children(".book_list_line_item:eq(0)").find("span").text();
    let book_name = a.children(".book_list_line_item:eq(1)").find("span").text();
    let img_address = a.children(".book_list_line_item:eq(2)").find("span").text();
    let book_description = a.children(".book_list_line_item:eq(3)").find("span").text();
    let book_country = a.children(".book_list_line_item:eq(4)").find("span").text();
    let book_date = a.children(".book_list_line_item:eq(5)").find("span").text();


    $("#EditId").val(id);
    $("#Edit_book_name").val(book_name);
    $("#Edit_img_address").val(img_address);
    $("#Edit_book_description").val(book_description);
    $("#Edit_book_country").val(book_country);
    $("#Edit_book_date").val(book_date);

    $("#BookListBlock").hide();
    $("#head").hide();
    $("#EditBook").show();

}
function back(){
    $("#BookListBlock").show();
    $("#head").show();
    $("#EditBook").hide();
}

getBooks();

