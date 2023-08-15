<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Dojo Survey Index</title>
    </head>
    <body>
        <form action="/" method="post">
            <div>
                <label>Your name: <input type="text" name="name"></label>
            </div>
            <div>
                <label>
                    Dojo Location:
                    <select name="location">
                        <option selected value=""> -- Choose --</option>
                        <option>San Jose</option>
                        <option>Los Angeles</option>
                        <option>New York</option>
                    </select>
                </label>
            </div>
            <div>
                <label>
                    Favorite language:
                    <select name="language">
                        <option selected value=""> -- Choose --</option>
                        <option>Python</option>
                        <option>Java</option>
                        <option>Javascript</option>
                    </select>
                </label>
            </div>
            <div>
                <label>Comment (optional):
                    <textarea name="comment" cols="30" rows="10" style="display: block"></textarea></label>
            </div>
            <button>Submit</button>
        </form>
    </body>
</html>
