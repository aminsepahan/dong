<#import "_template.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create a new user</h3>
        <form action="/dongusers" method="post">
            <p>
                <input type="text" name="name" placeholder="name">
            </p>
            <p>
                <input type="email" name="email" placeholder="email">
            </p>
            <p>
                <input type="tel" id="phone" name="phone" placeholder="phone" >
            </p>
            <p>
                <input maxlength="19" name="card-number" pattern="\d*" placeholder="Card Number" type="tel" />
            </p>
            <p>
                <input type="submit" value="Create new DongMoz user">
            </p>
        </form>
    </div>
</@layout.header>
