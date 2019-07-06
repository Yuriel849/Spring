# Spring
A repository of my studies of the Spring framework <br/>

06.07.2019 - False alarm, email about pom.xml security issues (jackson-databind)

## Spring Configuration Guidelines

### Set up new Spring Legacy Project
> Right-click > Properties > Project Facets > Java ver. 1.8 <br/>
pom.xml > properties > java-version = 1.8; org.springframework-version = 5.0.7.RELEASE; org.aspectj-version = 1.8.9 <br/>
pom.xml > build > plugins > plugin; groupId = org.apache.maven.plugins; artifactId = maven-compiler-plugin; version = 3.5.1; configuration; source = 1.8; target = 1.8; compilerArgument = -Xlint:all; showWarnings = true; showDeprecation = true <br/>

Optional (Changing Project Facets is sufficient) <br/>
>> Right-click > Properties > Java Build Path > Add JRE System Library 1.8 <br/>
Right-click > Properties > Java Compiler > Java Compliance > Java ver. 1.8 <br/>

### Important dependencies
> MySQL Connector J
>> groupId = mysql; artifactId = mysql-connector-java; version = 5.1.47
<br/>

> JDBC with Spring
>> groupId = org.springframework; artifactId = spring-jdbc; version = ${org.springframework-version}
<br/>

> Connection Pool using C3P0 (alternative to DBCP)
>> groupId = com.mchange; artifactId = c3p0; version = 0.9.5.3
<br/>

> HikariCP (superior alternative to DBCP & C3P0)
>> groupId = com.zaxxer; artifactId = HikariCP; version = 3.3.1
<br/>

> MyBatis with Spring – Requires mybatis & mybatis-spring dependencies
>> groupId = org.mybatis; artifactId = mybatis; version = 3.4.1 <br/>
>> groupId =org.mybatis; artifactId = mybatis-spring; version = 1.3.0
<br/>

> Lombok (superior alternative to getters, setters, and basic constructors)
>> groupId = org.projectlombok; artifactId = lombok; version = 1.18.6; scope = provided
<br/>

> Spring-tx (required to use @Transactional)
>> groupId = org.springframework; artifactId = spring-tx; version = ${org.springframework-version}
<br/>

> File Uploading – Requires commons-fileupload & commons-io dependencies
>> groupId = commons-fileupload; artifactId = commons-fileupload; version = 1.3.3 <br/>
>> groupId = commons-io; artifactId = commons-io; version = 2.5
<br/>

> Send emails – Requires JavaMail API (javax.mail) & spring-context-support dependencies
>> groupId = javax.mail; artifactId = mail; version = 1.4.7 <br/>
>> groupId = org.springframework; artifactId = spring-context-support; version = ${org.springframework-version}
