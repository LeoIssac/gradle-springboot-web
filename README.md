# gradle
gradle-idea spring boot 多模块项目编码。

#1.创建 Gradle 父模块
**1.**`new project`—`Gradle`—选择对应`SDK`—`Next`。
&emsp;选择gradle项目，自己环境中的SDK（最低版本为JDK1.8），创建父模块。
![parent-new.png](https://upload-images.jianshu.io/upload_images/17834333-3a73e3211650975d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**2.**输入`GroupId`—输入`artifictId`—`Next`。
&emsp;输入groupId，命名请遵循相应命名规范。公司-com;组织-org；个人-pers。
![parent-name.png](https://upload-images.jianshu.io/upload_images/17834333-f16c0b7bb06f1fe3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**3.**选择`Use auto-import`—选择`Use local gradle distribution`—`Next`。
&emsp;选择自动导入，使用本地gradle环境，选择后会自动出现本地配置的`GRADLE_HOME`路径,然后选择本地的`jdk`配置即可。
![parent-setting.png](https://upload-images.jianshu.io/upload_images/17834333-49ef9d3af5d4090f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**4.**输入`Project name`—选择`Project location`—`Finish`。
&emsp;输入项目名称，选择相对应的项目存储路径，点击Finish，一个gradle 父模块创建完成。
![parent-finish.png](https://upload-images.jianshu.io/upload_images/17834333-6538a374543dc5a9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**5.**`gradle-springboot-web 右键`—`new`—`Module`。
&emsp;对应父模块，创建一个新的子模块。
![module-new.png](https://upload-images.jianshu.io/upload_images/17834333-957b0d421f274c42.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**6.**`new project`—`Gradle`—选择对应`SDK`—`Java`—`Next`。
&emsp;选择gradle项目，自己环境中的SDK（最低版本为JDK1.8），创建JAVA子模块。
![project-new.png](https://upload-images.jianshu.io/upload_images/17834333-d8a31c9e8fbb2a04.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**7.**输入`artifictId`—`Next`。
&emsp;输入子项目artifictId，检查`GroupId`，`ArtifactId`是否正确，以及该子项目是否在对应的父项目`gradle-springboot-wen`下。
![core-name.png](https://upload-images.jianshu.io/upload_images/17834333-e7fc30ca1982721f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**8.**输入`Module name`—选择`Content root`—选择`Project location`—`Finish`。
![core-finish.png](https://upload-images.jianshu.io/upload_images/17834333-5293288822f4f67b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**9.**`gradle-springboot-web 右键`—`new`—`Module`。
&emsp;对应父模块，创建一个新的子模块。
![module-new.png](https://upload-images.jianshu.io/upload_images/17834333-957b0d421f274c42.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**10.**`new project`—`Gradle`—选择对应`SDK`—`Java`—`Next`。
&emsp;选择gradle项目，自己环境中的SDK（最低版本为JDK1.8），创建JAVA子模块。
![project-new.png](https://upload-images.jianshu.io/upload_images/17834333-d8a31c9e8fbb2a04.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**11.**输入`artifictId`—`Next`。
&emsp;输入子项目artifictId，检查`GroupId`，`ArtifactId`是否正确，以及该子项目是否在对应的父项目`gradle-springboot-wen`下。
![web-name.png](https://upload-images.jianshu.io/upload_images/17834333-2197d4086a2f8ab2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**12.**输入`Module name`—选择`Content root`—选择`Project location`—`Finish`。
![web-finish.png](https://upload-images.jianshu.io/upload_images/17834333-e793ecda9bea83d8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

**13.**看到项目中出现文件`build.gradle`并且`Build:Sync`无异常，说明gradle java项目已创建成功。
![project-structure.png](https://upload-images.jianshu.io/upload_images/17834333-ca9ae7f643215fe8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

#2.Gradle 配置文件介绍
**1.**`settings.gradle`配置文件
```
//父模块名称
rootProject.name = 'gradle-springboot-web'
//子模块 core包名称
include 'gradle-core'
//子模块 web包名称
include 'gradle-web'
```
***

**2.**父模块`gradle-springboot-web` 的`build.gradle`配置文件
```
/**
 * 声明 gradle脚本自身需要使用的资源。可以声明的资源包括依赖项、第三方插件、maven仓库地址等。
 * gradle是由groovy语言编写的，支持groovy语法，可以灵活的使用已有的各种ant插件、基于jvm的类库，
 * 这也是它比maven、 ant等构建脚本强大的原因。虽然gradle支持开箱即用，但是如果你想在脚本中使用一些第三方的插件、类库等，
 * 就需要自己手动添加对这些插件、类库的 引用。而这些插件、类库又不是直接服务于项目的，而是支持其它build脚本的运行。
 * 所以你应当将这部分的引用放置在buildscript代码块中。 gradle在执行脚本时，会优先执行buildscript代码块中的内容，
 * 然后才会执行剩余的build脚本。
 */
buildscript {
    /**
     * 指定所使用仓库的路径
     * mavenCentral()，中央仓库，项目中所使用的jar包都会从中央仓库下载到本地仓库。
     *                 若本地仓库已经拥有相应的jar包，则不会重复下载
     *                 可以使用命令maven { url "http://maven.aliyun.com/nexus/content/groups/public" }指定maven的远程仓库地址
     * mavenLocal()本地仓库，与GRADLE_USER_HOME配置的路径一致。
     * */
    repositories{
        mavenLocal()
        maven {url "http://maven.aliyun.com/nexus/content/groups/public/"}
        mavenCentral()
    }
    //定义全局变量
    ext{
        //指定springboot 版本
        springBootVersion='2.1.3.RELEASE'
    }
    /**
     * gradle所有的jar包文件坐标都在dependencies属性内放置
     * 每一个jar包都具备以下特点
     * 1.scope（作用域）：gradle支持compile、runtime、testCompile、testRuntime四种scope
     *   compile：jar包在编译期与运行期依赖。
     *   runtime：jar包在运行期依赖。
     *   testCompile：jar包在测试编译期与运行期依赖。
     *   testRuntime：jar包在测试运行期依赖。
     *   补充：
     *   providedCompile：jar包/依赖代码 仅在编译的时候需要，但是在运行时不需要依赖。
     *   providedCompile与compile,runtime区别：
     *   compile: 前提：apply plugin: 'war'或者apply plugin: 'java'
     *   providedCompile:前提：apply plugin: 'war'，若前提为'java',则使用compileOnly
     *   runtime:前提：apply plugin: 'war'
     *   以上所说的前提，如果不正确配置的话，就会遇到依赖包无法导入，以及runtime以及providedCompile无法使用的情况。
     * 2. group:与maven的groupId一致。
     *    name:与maven的artifactId一致。
     *    version:与maven的version一致。
     */
    dependencies{
        //引入springboot gradle 插件
        classpath"org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}"
    }
    
}
/**
 * 引入所有模块的配置，包括父模块 gradle-spring-web，子模块gradle-core，gradle-web 
 */
allprojects {
    //创建项目输入groupId
    group 'pers.gradle'
    //创建项目所输入的版本
    version '1.0-SNAPSHOT'
    //指定运行环境，java
    apply plugin: 'java'
    //指定ide环境，idea
    apply plugin: 'idea'
    //定义全局变量
    ext{
        //指定springboot 版本
        springBootVersion='2.1.3.RELEASE'
    }
}
/**
 * 引入所有子模块的配置，包括子模块 gradle-spring-web，gradle-core，gradle-web 
 */
subprojects {
    //引入spring 依赖管理插件
    apply plugin: 'io.spring.dependency-management'
    //引入springboot 插件
    apply plugin: 'org.springframework.boot'
    //指定编译编译.java文件的jdk版本
    sourceCompatibility = 1.8
    //确保class文件与targetCompatibility指定版本，或者更新的java虚拟机兼容
    targetCompatibility = 1.8
    //指定gradle编译时，针对java文件使用 UTF-8 编码
    tasks.withType(JavaCompile) {
        options.encoding = 'UTF-8'
    }
    /**
     * 指定子模块所使用仓库的路径
     * */
    repositories {
        mavenLocal()
        maven{url "http://maven.aliyun.com/nexus/content/groups/public"}
        mavenCentral()
    }
    /**
     * 引入之模块jar包
     */
    dependencies {
        //引入log4j
        compile 'org.slf4j:slf4j-api:1.7.25'
        //引入Junit 单元测试
        testCompile 'junit:junit:4.12'
        //引入springboot start test
        testCompile('org.springframework.boot:spring-boot-starter-test')
    }

}
```
***
问题分析：
**3.**关于 `Execution failed for task ':gradle-core:bootJar.`问题
![core error.png](https://upload-images.jianshu.io/upload_images/17834333-7c0931e6a0e9585c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;build时，web编译不通过，错误：`Execution failed for task ':gradle-core:bootJar`，原因是依赖项目“gradle-core:bootJar FAILED”。

以下为build执行过程：
```
Executing task 'build'...

Parallel execution with configuration on demand is an incubating feature.
:compileJava
:gradle-core:compileJava
:gradle-web:processResources
:compileJava NO-SOURCE
:processResources
:gradle-web:processResources UP-TO-DATE
:processResources NO-SOURCE
:gradle-web:processTestResources
:classes UP-TO-DATE
:jar
:gradle-web:processTestResources NO-SOURCE
:jar UP-TO-DATE
:assemble UP-TO-DATE
:compileTestJava NO-SOURCE
:processTestResources NO-SOURCE
:testClasses UP-TO-DATE
:test NO-SOURCE
:check UP-TO-DATE
:build UP-TO-DATE
:gradle-core:compileJava UP-TO-DATE
:gradle-core:processResources NO-SOURCE
:gradle-core:classes UP-TO-DATE
:gradle-core:bootJar FAILED
```
解决方案：
在子模块`gradle-core`的build.gradle文件中，配置`jar.enabled = true  `和`bootJar.enabled = false`即可解决以上问题.
****

**4.**子模块`gradle-core` 的`build.gradle`配置文件
```
/**
 * 解决 Execution failed for task ':gradle-core:bootJar 问题
 * 引入 jar.enabled = true,bootJar.enabled = false
 */
jar.enabled = true
bootJar.enabled = false
/**
 * 引入 gradle-core依赖
 */
dependencies {
    //引入springboot starter
    compile('org.springframework.boot:spring-boot-starter')
    //引入lombok依赖
    //@Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
    compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.2'
}
```
***

**5.**子模块`gradle-web` 的`build.gradle`配置文件
```
/**
 * 引入 gradle-web依赖
 */
dependencies {
    //引入子模块 gradle-core
    compile project(':gradle-core')
    //引入 springboot starter web
    compile'org.springframework.boot:spring-boot-starter-web'
    //引入 thymeleaf 模板引擎
    compile ('org.springframework.boot:spring-boot-starter-thymeleaf')
}
```
#3.springboot-web 项目结构
![project structure.png](https://upload-images.jianshu.io/upload_images/17834333-fc201d80b14aa4d1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

#4.子模块 gradle-core 项目
**1.**在`model`文件夹下编写实体类`User.java`。
```
package pers.gradle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 用户信息实体
 * @Data 添加getter、setter方法
 * @NoArgsConstructor 添加无参构造器
 * @AllArgsConstructor 添加全参构造器
 * @AllArgsConstructor 添加链式调用
 * @ToString 添加toString
 * @author Leo
 * @date 11:53 2019/5/17
 * @param
 * @return
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
}

```
***

**2.**在`service`文件夹下编写接口类`UserService.java`。
```
package pers.gradle.service;

import pers.gradle.model.User;

import java.util.List;
/**
 * 用户信息service
 * @author Leo
 * @date 10:37 2019/5/22
**/
public interface UserService {
    /**
     * getUserList() 获取User列表
     * @author Leo
     * @date 10:27 2019/5/22
     * @return java.util.List<pers.gradle.model.User>
    **/
    List<User> getUserList();
}

```
***

**3.**在`service`文件夹下编写接口实现类`UserServiceImpl.java`。
```
package pers.gradle.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.gradle.dao.UserDao;
import pers.gradle.model.User;

import java.util.List;

/**
 * 用户信息service实现
 * @author Leo
 * @date 13:25 2019/5/22
**/
@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> getUserList() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao=applicationContext.getBean(UserDao.class);
        return userDao.getUserList();
    }
}
```
***

**4.**在`dao`文件夹下编写接口类`UserDao.java`。
```
package pers.gradle.dao;

import org.springframework.stereotype.Repository;
import pers.gradle.model.User;

import java.util.List;

/**
 * 用户信息dao
 * @author Leo
 * @date 13:25 2019/5/22
**/
@Repository
public interface UserDao {
    /**
     * getUserList() 获取用户信息列表
     * @author Leo
     * @date  2019/5/22
     * @return java.util.List<pers.gradle.model.User>
     **/
    List<User> getUserList();
}

```
***

**5.**在`dao`文件夹下编写接口实现类`UserDaoImpl.java`。
```
package pers.gradle.dao;

import pers.gradle.model.User;

import java.util.ArrayList;
import java.util.List;
/**
 * 用户信息dao实现类，模拟数据库返回结果
 * @author Leo
 * @date 13:23 2019/5/22
 * @param
 * @return
**/
public class UserDaoImpl implements UserDao{


    @Override
    public List<User> getUserList() {
        List<User> userList=new ArrayList<>();
        //链式调用
        User userZs=new User().setId(1L).setName("张三").setAge(18);
        userList.add(userZs);
        //链式调用
        User userLs=new User().setId(2L).setName("李四").setAge(20);
        userList.add(userLs);

        return userList;
    }
}
```
***

#5.子模块 gradle-web 项目
**1.**在`controller`文件夹下编写实体类`UserController.java`。
```
package pers.gradle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.gradle.model.User;
import pers.gradle.service.UserService;

import java.util.List;

/**
 * 获取用户列表
 * @author Leo
 * @date 18:48 2019/5/22
**/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * getUserList()
     * @author Leo
     * @date 18:49 2019/5/22
     * @param model
     * @return java.lang.String
    **/
    @RequestMapping("/list")
    public String toList(Model model){
        List<User> users=userService.getUserList();
        model.addAttribute("users",users);
        return "list";
    }
}
```
***

**2.**在`pers.gradle`文件夹下编写启动类`Application.java`。
```
package pers.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leo
 * @date 10:37 2019/8/26
 **/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        System.out.println("启动成功！");
    }

}
```
***

**3.**在`resources.templates`文件夹下编写html页面`list.html`。
```
<!DOCTYPE html>
<html lang="en">
<!-- 让IDEA编辑器有Thymeleaf语法提示，不写不影响运行 -->
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--后台控制器输出数据：model.addAttribute("users",users);-->
<!--List<User> getUserList()，即数据格式为常见的：List<User>-->
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    </thead>
    <tbody>
    <!-- 遍历集合，如果被遍历的变量 users 为 null 或者不存在，则不会进行遍历，也不报错-->
    <tr th:each="user : ${users}">
        <td th:text="${user.id}" th:name="${user.id}"></td>
        <td th:text="${user.name}"></td>
        <td th:text="${user.age}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
```
**4.**在`resources.templates`文件夹下编写配置文件`list.html`。
```
#端口号
server.port=8080
#视图所在文件路径
spring.mvc.view.prefix=/
#视图文件类型
spring.mvc.view.suffix=.html
```

#6.Gradle build 项目
&emsp;`ideal右侧工具栏`—`Gradle`—`gradle-springboot-web` —`Tasks`—`build`。
![gradle build.png](https://upload-images.jianshu.io/upload_images/17834333-5d0a6013fd610d4f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp;注意事项:
&emsp;若出现`Execution failed for task ':gradle-core:bootJar.`问题，请看文章中的解决方案。
&emsp;若出现`其他问题`请根据`具体提示信息检查相应配置或文件`。
&emsp;若出现`找不到setMethod()方法符号 `问题，请下载lombok 插件。
&emsp;`File`—`Settings`—`Plugins`。搜索lombok Pulgin，点击安装install。然后会提示重启，重启。
&emsp;重启后若问题仍然存在，则在`File`—`Settings`—`Build,Execution,Deployment`—`Annotation Processors`—去除`Enable annotation processors`勾选。如下图：
![lombok error.png](https://upload-images.jianshu.io/upload_images/17834333-c8bb9a229fa436c8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![lombok Pulgin.png](https://upload-images.jianshu.io/upload_images/17834333-7d77a47494f14ed7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

#7.springboot 启动项目
&emsp;打开子项目`gradle-web`下启动类`Application.java`，点击`▶`，选择`Run 'Application'`。
![run application.png](https://upload-images.jianshu.io/upload_images/17834333-8bc037a0e0177783.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp; 当出现打印信息`启动成功！`。则项目启动成功。
![run success.png](https://upload-images.jianshu.io/upload_images/17834333-7d897fc7c41fa4e8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***

#8.访问springboot 项目
&emsp;根据提示信息:
&emsp;` o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path`可知，端口号为`8080`。
&emsp;浏览器输入地址`http://localhost:8080/user/list`则可访问list.html页面。
![list.png](https://upload-images.jianshu.io/upload_images/17834333-b3345d13f7fe1ecb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

