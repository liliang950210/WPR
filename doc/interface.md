## WPR系统接口文档

##  1 项目中心 （/project）
### 1.1 创建项目 （/addProject）
方式： post
参数：  
* projectName: String 项目名字
* projectDesc： String  项目描述

返回结果：  
> "data": ""
> 'code": 1 表示成功执行 0 表示参数有误


## 2.个人中心
### 2.1 用户登录(/login）
方式： post  
参数：
* username: String 用户名
* password: String 密码  

返回结果：  
> "code": 1 表示登录成功  2 表示用户名或密码错误 3 用户名不存在  
> "error": 错误信息

### 2.2 用户名是否一注册（/isRegister） 
方式：post  
参数：  
* username： String 用户名

返回结果:
> "code": 1 表示未被注册，2 已被注册
>"error": 错误信息

