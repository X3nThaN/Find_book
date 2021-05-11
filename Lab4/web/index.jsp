<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 06.05.2021
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="book.js"></script>
  <link rel="stylesheet" type="text/css" href="index.css">
  <title>Книжная полка</title>
</head>
<body style="background: antiquewhite">

<nav class="navbar navbar-expand-md navbar-light" style="background: gray">
  <a class="navbar-brand" href="index.jsp">Dorogo.ru</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Список книг</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">
  <div class="row mt-4">
    <div id="BookListBlock" class="col book_list_block">
      <div class="row text-center book_list_line">
        <div class="col book_list_line_item">
          <span style="font-weight: bold">Название</span>
        </div>
        <div class="col book_list_line_item">
          <span style="font-weight: bold">URL изображения</span>
        </div>
        <div class="col book_list_line_item">
          <span style="font-weight: bold">Описание</span>
        </div>
        <div class="col book_list_line_item">
          <span style="font-weight: bold">Страна</span>
        </div>
        <div class="col book_list_line_item">
          <span style="font-weight: bold">Год издания</span>
        </div>
      </div>
    </div>

    <div id="EditBook" class="col" style="display: none">
      <button onclick="back()" class="create_user_button">Назад</button>
      <div class="row mt-4 form-group">
        <div style="display: none" class="col">
          <label for="EditId"></label>
          <input type="text" name="FirstName" class="form-control book_form_control" id="EditId">
        </div>
        <div class="col">
          <label for="Edit_book_name">Название книги</label>
          <input type="text" id="Edit_book_name" placeholder="до 50 символов" maxlength="50" class="form-control book_form_control">
        </div>
        <div class="col">
          <label for="Edit_img_address">Ссылка на изображение</label>
          <input type="text" id="Edit_img_address" placeholder="http://...." class="form-control book_form_control">
        </div>
        <div class="col">
          <label for="Edit_book_description">Описание</label>
          <textarea
                  class="form-control book_form_control"
                  id="Edit_book_description"
                  placeholder="Описание до 500 символов"
                  maxlength="500"
                  required
          ></textarea>
        </div>
        <div class="col">
          <label for="Edit_book_country">Страна</label>
          <input type="text" id="Edit_book_country" maxlength="60" placeholder="до 60 символов" class="form-control book_form_control">
        </div>
        <div class="col">
          <label for="Edit_book_date">Дата публикации</label>
          <input type="text" id="Edit_book_date" maxlength="4" minlength="4" pattern="[1-2][0-9]{3}"  placeholder="год выпуска" class="form-control book_form_control">
        </div>
        <div class="col">
          <button onclick="updateBook(this);" class="create_user_button">Обновить</button>
        </div>
      </div>
    </div>


  </div>



  <div id="head" class="row mt-4 form-group">
    <div class="col">
      <label for="book_name">Название книги</label>
      <input type="text" id="book_name" placeholder="до 50 символов" maxlength="50">
    </div>
    <div class="col">
      <label for="img_address">Ссылка на изображение</label>
      <input type="text" id="img_address" placeholder="http://....">
    </div>
    <div class="col">
      <label for="book_description">Описание</label>
      <textarea
              id="book_description"
              class="form-control"
              placeholder="Описание до 500 символов"
              maxlength="500"
              required
      ></textarea>
    </div>
    <div class="col">
      <label for="book_country">Страна</label>
      <input type="text" id="book_country" maxlength="60" placeholder="до 60 символов">
    </div>
    <div class="col">
      <label for="book_date">Дата публикации</label>
      <input type="text" id="book_date" maxlength="4" minlength="4" pattern="[1-2][0-9]{3}"  placeholder="год выпуска">
    </div>

    <button onclick="createBook(this);" type="submit" class="create_book_button">Добавить</button>
  </div>
  <div id="CreateBookSuccess" class="create_book_success">Книга добавлена успешно</div>
  <div id="CreateBookFault" class="create_book_fault">Книга не добавлена</div>
</div>

</body>
</html>
