<!DOCTYPE html>
<html>
<style>
    body{
        background-color: #B7EAFF;
    }
    h1{
        background-color: #3BC5FF;
        color: white;
    }
     h2{
        background-color: #3BC5FF;
        color: white;
    }
    button{
        background-color: blue;
        color: white;
    }
    ul{
        background-color: white;
    }
</style>
<h1>Paper Preferences</h1>
<h2>Please indicate what papers you are interested in!</h2>
<body>
<form action="/" method="POST">
    <ul>
        <#list papers as paper>
            <li><label for="paper"><input id ="paper" type="checkbox" name="paper" value=${paper_index}>${paper}</label></li>
        </#list>
    </ul>
    <button type="submit" id="btnSubmit" >Submit</button>
</form>
</body>

</html>