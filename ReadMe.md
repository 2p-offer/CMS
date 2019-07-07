# 数据分析系统系统使用指南
## 一.前提准备：
1).解压“资源文件”压缩文件到任意位置。  \
2).确定文件内含有mysql、idea、git、gradle、jdk的安装包。 \
3).网络查找以上几种插件或工具的安装方式，使用文件内的安装包进行安装。 \
4).linux 或者mac OX 用户自行网络下载安装对应软件。 

## 二.源码拉取：
安装好idea之后，打开软件，会有两种情况： 
### 1.从未使用idea打开过项目:
效果会如图所示： \
<img src="https://img-blog.csdn.net/20180115161626420?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvY2llbnZlbg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"/>

点击 check out from version control 选择gitgub  ，在Git repository Url处，输入“https://github.com/2p-offer/CMS.git”；  \
**注: 推荐使用ssh协议下载源码，使用方式请自行百度。http链接方式和ssh方式任选其一即可。**
### 2.之前使用过idea：
1).打开idea，找到菜单栏，VCS--> check out from version control --> Git -->输入Url。  \
2).等待clone完成。
3).看到提示“You have check out...Would you like to open it?”  选 “Yes”  \
4).Import Project from gradle :   \
&nbsp; &nbsp; 4.1)Gradle Project :项目存储的本地地址。  \
&nbsp; &nbsp; 4.2)Gradle home :安装Gradle时选择的安装地址（bin 文件夹之前）。  \
&nbsp; &nbsp; 4.3)Gradle JVM :本地Jdk安装目录,或者选择"user project jdk"。  \
5).New Project： NewWindow/ThisWindow  任选。  
## 三.数据库搭建
### 1.环境准备 
确保安装好mysql，并打开mysql服务。   \
资源文件-->安装包 下会有sqlyog，一款很好用的mysql的可视化操作界面工具。（你可以选择任何你习惯的可视化工具，这个软件只是参考）  \
安装sqlyog，一直下一步就可以。  
### 2.数据库创建
打开刚刚clone的CMS项目，打开"mp-starter-->src-->main-->resources-->sql".找到"CMS-sql.sql"文件  \
这个文件就是我们项目的数据库导出的sql脚本，接下来用sqlyog执行脚本，在本地创建我们需要的数据库。  \
(1).打开sqlyog，弹出“连接我的sql主机”，输入主机地址（localhost），用户名，密码，端口（正常情况下是3306）  \
(2).右键根目录，点击 创建“cms_wy”数据库。  \
(3).右键“执行sql脚本”。选择上面的CMS_sql.sql。  \
(4).点击执行。  
## 四.项目本地运行
### 1.配置更新
1).打开mp-starter-->src-->main-->resources-->application-dev.yml文件。  \
2).修改spring.datasource下 url、username、paasword 三项分别为mysql地址（jdbc:mysql://[ip]:[端口]/[数据库名称]?useUnicode=true&characterEncoding=utf8）、mysql登录用户名、mysql登录密码  \
3).修改 biz-->analyis-->excelspath 项，值为 此项目本地路径+mp-starter\src\main\resources\。eg："F:\IdeaProject\BiShe\CMS\mp-starter\src\main\resources\"  \
### 2.项目运行
1).打开mp-starter-->src-->main-->java-->com.wy.manager.mp文件夹，找到ManagerBmpApplication文件，打开。  \
2).右键，选择Run ManagerBmpApplication  或者 Debug ManagerBmpApplication；  \
3).控制台最终打印出“URCSs MANAGER-MP BOOT SUCCESS”代表项目启动成功。  \
4).打开浏览器，访问"http://localhost:8200".




