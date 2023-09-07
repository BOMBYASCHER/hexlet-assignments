<!-- BEGIN -->
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>Hello Hexlet!</title>
    </head>
    <body>
        <div class="mx-auto p-4 py-md-5">
        <main>
            <div>
                <form action="/users" method="post">
                    <input type="text" required name="firstName" placeholder="firstName" />
                    <input type="text" required name="lastName" placeholder="lastName" />
                    <input type="email" required name="email" placeholder="email" />
                    <input type="password" required name="password" placeholder="password" />
                    <input type="submit" value="finish" />
                </form>
            </div>
        </main>
        </div>
    </body>
</html>
<!-- END -->
