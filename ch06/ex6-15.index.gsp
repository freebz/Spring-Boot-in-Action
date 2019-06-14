<!-- 코드 6-15 그레일즈 레이아웃을 포함한 GSP 템플릿(grails-app/views/readingList/index.gsp) -->

<!DOCTYPE html>
<html
<head>
  <meta name="layout" content="main"/> <!-- 메인 레이아웃 사용 -->
  <title>Reading List</title>
  <link rel="stylesheet" href="/assets/main.css?compile=false" />
  <link rel="stylesheet" href="/assets/mobile.css?compile=false" />
  <link rel="stylesheet" href="/assets/application.css?compile=false" />
</head>
<body>
  <h2>Your REading List</h2>
  <g:if test="${bookList && !bookList.isEmpty()}"> <!-- 책 목록 -->
    <g:each in="${bookList}" var="book">
      <dl>
	<dt class="bookHeadline">
	  ${book.title}</span> by ${book.author}
	  (ISBN: ${book.isbn})
	</dt>
	<dd class="bookDescription">
	  <g:if test="${book.description}">
	    ${book.description}
	  </g:if>
	  <g:else>
	    No description available
	  </g:else>
	</dd>
      </dl>
    </g:each>
  </g:if>
  <g:else>
    <p>You have no books in your book list</p>
  </g:else>

  <hr/>

  <h3>Add a book</h3>
  <g:form action="save"> <!-- 책 등록 폼 -->
    <fieldset class="form">
      <label for="title">Title:</label>
      <g:field type="text" name="title" value="${book?.title}"/><br />
      <label for="author">Author:</label>
      <g:field type="text" name="author" value="${book?.author}"/><br />
      <label for="isbn">ISBN:</label>
      <g:field type="text" name="isbn" value="${book?.isbn}"/><br />
      <label for="description">Description:</label><br />
      <g:textArea name="description" value="${book?.description}" rows="5" cols="80"/>
    </fieldset>
    <fieldset class="buttons">
      <g:submitButton name="create" class="save"
value="${message(code: 'default.button.create.label', default: 'Create')}" />
    </fieldset>
  </g:form>
</body>
</html>
