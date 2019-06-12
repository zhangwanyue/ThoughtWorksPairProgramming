# ThoughtWorks Programming Pair Programming Season 4

## Conway's Game of Life

[康威生命游戏简介](https://zh.wikipedia.org/wiki/%E5%BA%B7%E5%A8%81%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F)

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