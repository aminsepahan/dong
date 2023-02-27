<#-- @ftlvariable name="users" type="kotlin.collections.List<ir.aminkeshavarzian.dong.server.model.DongUser>" -->
<#import "_template.ftl" as layout />
<@layout.header>
    <#list users?reverse as user>
        <div>
            <h3>
                <a href="/dongusers/${user.id}">${user.name}</a>
            </h3>
            <p>
                ${user.phoneNumber}
            </p>
        </div>
    </#list>
    <p>
        <a href="/dongusers/new">Create User</a>
    </p>
</@layout.header>
