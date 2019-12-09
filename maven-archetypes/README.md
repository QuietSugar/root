#### 子模块
- quickstart
> 参考的是 `org.apache.maven.archetypes:maven-archetype-quickstart`(删除了test模块)

##### 0.安装使用
```shell
# 下载本项目源码
git clone https://github.com/QuietSugararchetype-resources/blank.git
# 进入目录
cd blank
# 安装到本机，并且更新
mvn clean install 
# 或者 mvn -Dmaven.test.skip=true clean install
mvn archetype:update-local-catalog
# 去找一个空的目录运行，根据提示设置
mvn archetype:generate
```
