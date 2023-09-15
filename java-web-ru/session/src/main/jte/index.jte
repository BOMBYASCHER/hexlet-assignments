@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!-- BEGIN -->
@template.layout.page(
    content = @`
        <main>
            @if(page.getName() == null)
                <div>
                    <a href="${NamedRoutes.buildSessionPath()}">Log in</a>
                </div>
            @else
                <div>
                    <form action="${NamedRoutes.logoutPath()}" method="post">
                        <h2>${String.valueOf(page.getName())}</h2>
                        <input type="submit" value="Log out" />
                    </form>
                </div>
            @endif
        </main>
    `
)
<!-- END -->
