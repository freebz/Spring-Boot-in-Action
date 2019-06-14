<!-- 코드 6-10 GSP로 작성한 독서 목록 앱의 메인 뷰(readingList.gsp) -->

<!DOCTYPE html>
<html>
<head>
  <title>Reading List</title>
  <link rel="stylesheet" href="/css/style.css"></link>
</head>
<body>
  <form method="POST" action="/logout">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>

  <h2><span>${reader.fullanme}</span>'s Reading List</h2>
  <g:if test="${books}">
    <g:each in="${books}" var="book"> <!-- 책 목록 -->
      <dl>
	<dt class="bookHeadline">
	  <a href="http://www.amazon.com/gp/product/${book.isbn}/tag=${amazonId}">
	    ${book.title></a> by ${book.author}
	    (ISBN: ${book.isbn})
	</dt>
	<dd class="bookDescription">
	  <g:if test="book.description">
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
  <form method="POST" action="/"> <!-- 책 등록 폼 -->
    <label for="title">Title:</label>
    <input type="text" name="title" value="${book?.title}"/><br />
    <label for="author">Author:</label>
    <input type="text" name="author" value="${book?.author}"/><br />
    <label for="isbn">ISBN:</label>
    <input type="text" name="isbn" value="${book?.isbn}"><br />
    <label for="description">Description:</label><br />
    <textarea name="description" rows="5" cols="80">${book?.description}</textarea><br />
    <input type="submit" value="Add Book" />
    <!-- CSRF 토큰 -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</body>
</html>
