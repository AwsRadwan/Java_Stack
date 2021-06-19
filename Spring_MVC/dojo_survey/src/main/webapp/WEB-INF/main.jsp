<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
        article {
            margin: 40px auto;
            width: 500px;
            background-color: antiquewhite;
            padding: 20px;
        }
        button {
            float: right;
        }
    </style>

    <title>Document</title>
</head>
<body>
    <article>
        <form action="/result" method="POST">
            <input type="hidden" name="register">
            <div class="form-group">
                <label for="exampleFormControlInput1">Your Name</label>
                <input type="text" name="name" class="form-control" id="exampleFormControlInput1" placeholder="Your Name" required>
            </div>
            <br>
            <div class="form-group">
                <label for="exampleFormControlInput1">Dojo Location</label>
                <select name="loc" id="loc">
                    <option value="USA">USA</option>
                    <option value="Palestine">Palestine</option>
                    <option value="Jordan">Jordan</option>
                    <option value="Chaina">Chaina</option>
                </select>
            </div>
            <br>
            <div class="form-group">
                <label for="exampleFormControlInput1">FavoriteLanguage</label>
                <select name="lang" id="lang">
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="HTML">HTML</option>
                    <option value="Css">Css</option>
                </select>
            </div>
            <br>
            <div class="form-group">
                <label for="exampleTextarea">Comment (Optional): </label><br>
                <textarea class="form-control" name="comment" id="exampleTextarea" rows="2"></textarea>
            </div>
            
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
        </form>
    </article>
</body>
</html>