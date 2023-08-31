<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Show</title>
  </head>
  <body>
    <main>
      <h1>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</h1>
      <h1>${page.getUser().getEmail()}</h1>
    </main>
  </body>
</html>
<!-- END -->
