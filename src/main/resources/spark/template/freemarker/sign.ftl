<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

    <h1>SignUp to SAM 2019</h1>

    <div class="body">
        <form class="loginForm" action="/login" method="POST">
            <span>Enter a First name:</span>
            <input name="firstName"/>
            <span>Enter a Last name:</span>
            <input name="lastName"/>
            <span>Enter a Password:</span>
            <input password="pass"/>
            <button class="loginButton" type="submit">Sign Up</button>
        </form>
        <#if failedLogin>
           <span class="errorMessage">${failedLoginMessage}</span>
        </#if>
    </div>

</div>
</body>
</html>