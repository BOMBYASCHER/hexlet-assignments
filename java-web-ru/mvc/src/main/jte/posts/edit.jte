<!-- BEGIN -->
@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content = @`
        <main>
            @if(page.getErrors() != null)
                <div class="mb-3">
                    <ul>
                        @for(var validator : page.getErrors().values())
                            @for(var error : validator)
                                <li>${error.getMessage()}</li>
                            @endfor
                        @endfor
                    </ul>
                </div>
            @endif
            <form action="${NamedRoutes.postPath(page.getId())}" method="post">
                <div class="mx-auto p-4 py-md-5">
                    <input type="text" name="name" placeholder="name" value="${page.getName()}" />
                </div>
                <div class="mx-auto p-4 py-md-5">
                    <input type="textarea" name="body" placeholder="body" value="${page.getBody()}" />
                </div>
                <div class="mx-auto p-4 py-md-5">
                    <input type="submit" value="save" />
                </div>
            </form>
        </main>
    `
)
<!-- END -->
