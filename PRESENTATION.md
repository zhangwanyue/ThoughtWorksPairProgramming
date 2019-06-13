# 展示汇报

## 项目介绍

* 参看[README.md](https://github.com/zhangwanyue/ThoughtWorksPairProgramming/blob/master/README.md)中的介绍

## 项目功能展示

* 选择文件（用户可以自定义初始化文件）

* 随机初始化一个初始状态

* 设置生命周期的间隔时间

* 开始游戏

* 暂停游戏

* 更改布局配色（更改完配色之后游戏会自动暂停，需要再次手动点击开始）

## 项目设计思路

### 使用TDD小步迭代开发

TDD的迭代开发步骤：红灯 -> 绿灯 -> 重构

完成了**36**个测试用例，核心业务逻辑的代码覆盖率达到了**95%**；小步提交，github上的commit次数为**80**

#### 分工

* 一起拆分任务并商定好每个任务的解决方案

* 我主要负责测试代码

* 搭档负责实现部分的代码

* 待实现部分的代码完成后，再一起进行重构

#### 核心逻辑部分的任务拆分

* 任务一

读取case文件，加载到CellMatrix对象中。

对此编写了五个测试方法，测试了加载成功，case文件格式不正确等各种情况。

* 任务二

统计当前状况下每个细胞周围的存活细胞数目

* 任务三

计算某个细胞下一个生命周期的存活状态

* 任务四

计算下一个生命周期全部细胞的存活状态

在完成该任务的时候，我们发现一个问题：如果使用当前细胞矩阵计算并修改下一周期的细胞存活状态，必定存在已修改过的细胞影响周围细胞的状态计算。
为解决这个问题，我们又新建了一个任务：深拷贝当前细胞矩阵，在计算下一周期细胞存活状态的时候，使用深拷贝出的细胞矩阵进行计算。

### 良好的代码规范性

* 重构消除冗余代码

* 重构时对重复性代码做封装

比如`CellMatrix.getSurroundLiveCellNum`方法中，统计某个细胞周围存活细胞的数量时，需要判断统计的细胞是否存在（即是否越界），这里就存在大量重复代码，我们在重构时封装出新的`CellMatrix.countLiveCell`方法消除重复代码。

* 良好的命名规范

1)规范的项目包结构的命名

```
- files（测试case文件）
- src
    - main.java
        - com.thoughtworks.gameOfLife
                - models（细胞主体类及核心逻辑）
                - ui（用户界面）
                - utils（基础类）
            - Main方法（入口函数）
    - test.java
        - com.thoughtworks.gameOfLife
                - models（细胞主体类及核心逻辑）
                - utils（基础类）
            - SuiteTest（测试套件）  
```

2)有意义的项目类名、方法名、变量名

3)测试方法的命名部分采用了BDD的`given/when/then`语法（比如`whenReadFileNotLegalNumThenException`），部分采用了`测试方法名+Test`的命名方式

* 规范性备注

在主要的业务方法上都给了Javadoc格式的描述性备注。

* 保证代码可读性

没有Hard Code，不写Magic Code。

### UI设计

* 使用Swing进行UI部分的开发

### 代码健壮性

* 保证核心逻辑的代码覆盖率（尤其是边界条件的覆盖）

* UI界面的线程安全性

### 项目架构

* 使用`JUnit`进行TDD开发

* 使用`swing`实现用户界面

* 使用`gradle`做项目管理

* 使用`jacoco`进行测试覆盖率的检查

#### 本地运行

1. 直接点击`Run Main`运行

2. `./gradlew run`运行

#### 打包、部署、运行

* 打包
```bash
./gradlew assembleDist
```
* 解压
```bash
cd build/distributions/
unzip TWGameOfLife-1.0-SNAPSHOT.zip
cd TWGameOfLife-1.0-SNAPSHOT/bin
```
* 运行
```bash
./ThoughtWorksPairProgramming
```

#### 运行测试及代码覆盖率检查

* 运行全部测试

```bash
./gradlew test
```
该命令不仅会运行全部测试，并且会生成一个代码测试报告，位置在：`build/reports/tests/test/index.html`

或者手动点击`com.thoughtworks.gameOfLife.SuiteTest`运行全部测试

* 代码覆盖率检查
```bash
./gradlew test jacocoTestReport
```
该命令会生成一个代码覆盖率报告，位置在：`build/reports/jacoco/test/html/index.html`

### 待改进的地方

* UI部分的测试编写难度大，没有使用TDD进行开发

* 只完成了TDD开发，但是TDD只适用于开发人员，而对于无法理解代码的客户及相关方，最好能完成BDD（行为驱动开发）

* UI界面更新的时候偶尔会卡，后期考虑一下如何优化

* UI的更新和后端逻辑的计算放在了同一线程中（主要是由于该计算过程耗时很短，并且计算过程需要实时显示在UI界面上），如果后续需要开发更复杂的计算逻辑，可以考虑计算线程和UI显示线程分开（这里又要设计到多线程的交互和同步问题了）

## 活动感受

第一次体验结对编程，和小伙伴合作的非常愉快。

我的小伙伴做事非常认真细致，经常能发现许多细节的问题，而且非常负责，我们昨晚回去又一起协同开发到很晚。而我开发经验相对多一些，在项目的构建和代码的规范性方面可以给团队提供能多支持。

很感谢我们的coach，我们可能自己的想法比较多，一直在自己埋头写，而coach非常关心我们的进度，经常会过来询问以及给予帮助。

这次活动体验非常愉快，和小伙伴合作写代码总是能进入到心流状态。希望以后还能有机会和各位合作。