# ThoughtWorks Programming Pair Programming Season 4

## Conway's Game of Life

[康威生命游戏简介](https://zh.wikipedia.org/wiki/%E5%BA%B7%E5%A8%81%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F)

#### 规则
生命游戏中，对于任意细胞，规则如下：
每个细胞有两种状态 - 存活或死亡，每个细胞与以自身为中心的周围八格细胞产生互动（如图，黑色为存活，白色为死亡）
* 当前细胞为存活状态时，当周围的存活细胞低于2个时（不包含2个），该细胞变成死亡状态。（模拟生命数量稀少）
* 当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
* 当前细胞为存活状态时，当周围有超过3个存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
* 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）
可以把最初的细胞结构定义为种子，当所有在种子中的细胞同时被以上规则处理后，可以得到第一代细胞图。按规则继续处理当前的细胞图，可以得到下一代的细胞图，周而复始。

## 效果图展示

![image](https://github.com/zhangwanyue/ThoughtWorksPairProgramming/blob/master/files/image/%E5%BD%95%E5%B1%8F1.gif)

![image](https://github.com/zhangwanyue/ThoughtWorksPairProgramming/blob/master/files/image/Jietu20190613-101518.jpg)

## 项目架构

* 使用`JUnit`进行TDD开发

* 使用`swing`实现用户界面

* 使用`gradle`做项目管理

* 使用`jacoco`进行测试覆盖率的检查


## 项目构建

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


