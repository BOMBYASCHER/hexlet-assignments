<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <title>Hexlet</title>
    </head>
    <body>
        @for(var user : page.getUsers())
           <div>
               <h2><a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a></h2>
               <p>${user.getEmail()}</p>
           </div>
        @endfor
    </body>
</html>
<!-- END -->
