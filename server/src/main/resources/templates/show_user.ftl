<#-- @ftlvariable name="article" type="ir.aminkeshavarzian.dong.server.model.DongUser" -->
<#import "_template.ftl" as layout />
<@layout.header>
    <div>
        <h2>Dong user name = ${article.name}</h2>
        <h5>email = ${article.email}</h5>
        <h5>phone = ${article.phoneNumber}</h5>
        <h5>bank card = ${article.bankCard}</h5>
        <hr>
        <p>
            <a href="/dongusers/${article.id}/edit">Edit user</a>
        </p>
    </div>
</@layout.header>
