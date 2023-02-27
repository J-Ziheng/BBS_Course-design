# BBS_Course-design
<h3>一、开发说明</h3>

这是一个**极简但功能齐全**的BBS，已于2021秋期开发完成！

<h4>开发者：</h4>

- 靳子恒 北京科技大学天津学院信息工程系

<h4>开发技术：</h4>

- 使用语言：Java+HTML+JSP+SQL
- 数据库：SQLServer
- B/S结构系统

<h4>工程量：</h4>

约三千行代码

<h4>开发用时：</h4>

15天

<h3>二、BBS说明</h3>
<h4>名称：</h4>校园论坛
<h4>支持的功能：</h4>

- 登录、注册功能，注册自动成为普通用户
- 登录时检查账户类型进入不同界面的BBS
- 查看个人信息
- 查看个人最近动态
- 查看版块列表
- 查看版块中的帖子列表，支持分页
- 查看时间序的全部列表，支持分页
- 查看某个帖子的具体内容
- 回复某个帖子
- 删除回复
- 向某个版块发帖
- 分版块用户检索
- 寻找版块帖和回复人
- ...
- 404功能，自定义404页面
- 退出功能，清理用户信息防止信息泄露
- 自动适配功能，适配不同大小的屏幕
- ...

<h3>三、代码部分结构</h3>

1. java代码的结构如下

![JavaWeb做BBS(课程设计)_YesIcan2021-CSDN博客_(1) pdf_和另外_3msedge](https://user-images.githubusercontent.com/92208322/221403248-ba70cb56-5352-4504-aad7-f8fe50d39ecb.png)<br>
---
2. 中间件和JSP代码的部分结构如下

![2](https://user-images.githubusercontent.com/92208322/221403448-a86b0a90-4c3c-4a04-96f5-d3ceb642a717.png)<br>
![3](https://user-images.githubusercontent.com/92208322/221403453-22dd92e2-6293-4564-803e-879617d1b76d.png)<br>
---
3. 数据库部分截图如下

![数据库部分](https://user-images.githubusercontent.com/92208322/221403471-7540ca19-b9f9-4c0e-a2b8-f83406c070ae.png)<br>
---
<h3>四、程序使用说明</h3>

1. 自行配置SQLServer，参数可自行更改
2. 配置Apache_Tomcat 8.0
