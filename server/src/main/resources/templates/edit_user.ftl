<#-- @ftlvariable name="user" type="ir.aminkeshavarzian.dong.server.model.DongUser" -->
<#import "_template.ftl" as layout />
<@layout.header>
<div>
    <h3>Create a new user</h3>
    <form action="/dongusers/${id}" method="post">
        <p>
            <input type="text" name="name" value="${user.name}">
        </p>
        <p>
            <input type="email" name="email" value="${user.email}">
        </p>
        <p>
            <input type="tel" id="phone" name="phone" value="${user.phoneNumber}">
        </p>
        <p>
            <input maxlength="19" name="card-number" pattern="\d*" placeholder="Card Number"
                   type="tel" value="${user.bankCard}">
        </p>
        <p>
            <input type="submit" name="_action" value="Save changes">
        </p>
    </form>
</div>

<div>
    <form action="/dongusers/${user.id}" method="post">
        <p>
            <input type="submit" name="_action" value="delete">
        </p>
    </form>
</div>
</@layout.header>
