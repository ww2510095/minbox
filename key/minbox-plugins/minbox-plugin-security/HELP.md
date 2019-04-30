# MinBoxSecurity

### 此插件提供了3个方法以及2个注解可以使用

### 方法
- **1:`SecurityMain.setUser`**
- **此方法需要您在登录的时候调用，
可以将您的用户信息设置到session里面，
您可通过`SecurityMain.getUser`方法来获取设置的用户信息
但是您的用户必须继承自`org.minbox.key.plugin.security.minboxpluginsecurity.key.UserBase`
这个类提供了一个成员`AuthKey`，您必须把用户所具有的权限设置到里面。**
- **2:`SecurityMain.setAuthKey`**
- **如果您不需要在项目中获取用户的信息，
那么您可以在登陆方法里面调用这个方法，设置用户所具有的权限就可以了**

###注解
- **MinBoxSecurity默认只校验是否登录，如果您需要更精确的校验，
那么您只需添加`@MinboxSecurityAuth`注解就可以了**
- **这个注解为您提供了2个解释**
- **1：`SecurityAuthKey`**
- **这个方法需要一个String数组，
您可以在里面定义访问所需要的权限**
- **这个注解也可以用于类上**
- **如果用于注释类，那么类里面的所有方法都将具有相同安全能力**
- **如果您在类上面注释了同时又在方法上面注释了，那么将采取就近规则，方法上面的注释会覆盖类上面的注释**
- **2：`isAuthAll`**
- **`isAuthAll`是一`boolean`指，如果为`false`，那么用户只需要具备`SecurityAuthKey`中的一种权限就可以通过校验，如果为`true`那么用户需要同时具备`SecurityAuthKey`中的所有的权限才可以通过校验**
- ** `isAuthAll`的值默认是投`true`

- **`MinBoxSecurity`会拦截校验您所有的请求，如果您某些接口不需要校验(比如登陆)，
那么您可以通过添加`@NotAuth`注解来去掉拦截。**
- **当存在此注解的时候，`MinBoxSecurity`不考虑权限**
- **如果用来注释类，那么类中所有的方法都不考虑权限，如果用来注释方法，那么只有被注释的那一个方法不校验**
- **需要注意的是`NotAuth` 的优先级高于`MinboxSecurityAuth`
    也就是说当`NotAuth`与`MinboxSecurityAuth`同时存在的时候的时候，`MinboxSecurityAuth`会被忽略**












