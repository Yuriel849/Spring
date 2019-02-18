# Spring
A repository of my studies of the Spring framework
<br/>

## Spring Configuration Guidelines

### Set up new Spring Legacy Project
> Right-click > Properties > Project Facets > Java ver. 1.8 <br/>
pom.xml > properties > <java-version>1.8</java-version><org.springframework-version>4.3.8.RELEASE</org.springframework-version> <br/>
Optional (Changing Project Facets is sufficient) <br/>
>> Right-click > Properties > Java Build Path > Add JRE System Library 1.8 <br/>
Right-click > Properties > Java Compiler > Java Compliance > Java ver. 1.8
<br/>

### Important dependencies
> MySQL Connector J
>> <dependency><groupId>mysql</groupId><artifactId>mysql-connector-java</artifactId><version>5.1.47</version></dependency>
<br/>

> JDBC with Spring
>> <dependency><groupId>org.springframework</groupId><artifactId>spring-jdbc</artifactId><version>${org.springframework-version}</version></dependency>
<br/>

> Connection Pool using C3P0 (alternative to DBCP)
>> <dependency><groupId>com.mchange</groupId><artifactId>c3p0</artifactId><version>0.9.5.3</version></dependency>
<br/>

> MyBatis with Spring – Requires mybatis & mybatis-spring dependencies
>> <dependency><groupId>org.mybatis</groupId><artifactId>mybatis</artifactId><version>3.4.1</version></dependency> <br/>
>> <dependency><groupId>org.mybatis</groupId><artifactId>mybatis-spring</artifactId><version>1.3.0</version></dependency>
<br/>

> File Uploading – Requires commons-fileupload & commons-io dependencies
>> <dependency><groupId>commons-fileupload</groupId><artifactId>commons-fileupload</artifactId><version>1.3.3</version></dependency> <br/>
>> <dependency><groupId>commons-io</groupId><artifactId>commons-io</artifactId><version>2.5</version></dependency>
<br/>

> Send emails – Requires JavaMail API (javax.mail) & spring-context-support dependencies
>> <dependency><groupId>javax.mail</groupId><artifactId>mail</artifactId><version>1.4.7</version></dependency> <br/>
>> <dependency><groupId>org.springframework</groupId><artifactId>spring-context-support</artifactId><version>${org.springframework-version}</version></dependency>
