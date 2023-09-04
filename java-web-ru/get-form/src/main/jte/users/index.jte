<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<!docktype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                    rel="stylesheet"
                    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                    crossorigin="anonymous">
        <title>Users</title>
    </head>
    <body>
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
        @if(page.getUsers().isEmpty())
            <p>No added users yet.</p>
        @else
            @for(User user : page.getUsers())
                <div>
                    <h2>${user.getFirstName() + " " + user.getLastName()}</h2>
                    <p>${user.getEmail()}</p>
                </div>
            @endfor
        @endif
    </body>
</html>
<!-- END -->
