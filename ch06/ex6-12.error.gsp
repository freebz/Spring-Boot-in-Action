<!-- 코드 6-12 GSP 오류 페이지(error.gsp) -->

<!DOCTYPE html>
<html>
<head>
  <title>Oops!</title>
  <link rel="stylesheet" href="/css/style.css"></link>
</head>
<body>
  <div class="errorPage">
    <span class="oops">Oops!</span><br />
    <img src="/images/MissingPage.png"></img>
    <p>There seems to be a problem with the page you requested
      (${path}).</p>
    <p>Details ${message}</p>
  </div>
</body>
</html>
