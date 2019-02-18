# Spring
A repository of my studies of the Spring framework
<br/>

## Spring Configuration Guidelines
<br/>

### Set up new Spring Legacy Project
> Right-click > Properties > Project Facets > Java ver. 1.8 <br/>
pom.xml > properties > <java-version>1.8</java-version><org.springframework-version>4.3.8.RELEASE</org.springframework-version>
Optional (Changing Project Facets is sufficient) <br/>
>> Right-click > Properties > Java Build Path > Add JRE System Library 1.8 <br/>
Right-click > Properties > Java Compiler > Java Compliance > Java ver. 1.8
<br/>

### Important dependencies
> MySQL Connector J
>> <dependency><groupId>mysql</groupId><artifactId>mysql-connector-java</artifactId><version>5.1.47</version></dependency>
<br/>

#### &nbsp;&nbsp;&nbsp;JDBC with Spring
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>org.springframework</groupId><artifactId>spring-jdbc</artifactId><version>${org.springframework-version}</version></dependency>
<br/>

#### &nbsp;&nbsp;&nbsp;Connection Pool using C3P0 (alternative to DBCP)
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>com.mchange</groupId><artifactId>c3p0</artifactId><version>0.9.5.3</version></dependency>
<br/>

#### &nbsp;&nbsp;&nbsp;MyBatis with Spring – Requires mybatis & mybatis-spring dependencies
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>org.mybatis</groupId><artifactId>mybatis</artifactId><version>3.4.1</version></dependency>
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>org.mybatis</groupId><artifactId>mybatis-spring</artifactId><version>1.3.0</version></dependency>
<br/>

#### &nbsp;&nbsp;&nbsp;File Uploading – Requires commons-fileupload & commons-io dependencies
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>commons-fileupload</groupId><artifactId>commons-fileupload</artifactId><version>1.3.3</version></dependency>
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>commons-io</groupId><artifactId>commons-io</artifactId><version>2.5</version></dependency>
<br/>

#### &nbsp;&nbsp;&nbsp;Send emails – Requires JavaMail API (javax.mail) & spring-context-support dependencies
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>javax.mail</groupId><artifactId>mail</artifactId><version>1.4.7</version></dependency>
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<dependency><groupId>org.springframework</groupId><artifactId>spring-context-support</artifactId><version>${org.springframework-version}</version></dependency>
