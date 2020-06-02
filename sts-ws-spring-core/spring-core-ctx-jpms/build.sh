 

#/Library/Java/JavaVirtualMachines/jdk-11.0.5.jdk/Contents/Home/bin/javac -d  mods -p  /Users/peddi/.m2/repository/org/springframework/spring-core/5.2.3.RELEASE/spring-core-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-context/5.2.3.RELEASE/spring-context-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-beans/5.2.3.RELEASE/spring-beans-5.2.3.RELEASE.jar --module-source-path src/main/java $(find src/main/java -name '*.java')


/Library/Java/JavaVirtualMachines/jdk-11.0.5.jdk/Contents/Home/bin/java -p mods:/Users/peddi/.m2/repository/org/springframework/spring-core/5.2.3.RELEASE/spring-core-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-context/5.2.3.RELEASE/spring-context-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-beans/5.2.3.RELEASE/spring-beans-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-jcl/5.2.3.RELEASE/spring-jcl-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-aop/5.2.3.RELEASE/spring-aop-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-expression/5.2.3.RELEASE/spring-expression-5.2.3.RELEASE.jar --add-opens org.peddi.spring.core.ctx/org.peddi.spring.core.ctx.annotation=spring.core -m org.peddi.spring.core.ctx/org.peddi.spring.core.ctx.annotation.AnnotationAppConfigDemo


 #/Users/peddi/.m2/repository/org/springframework/spring-core/5.2.3.RELEASE/spring-core-5.2.3.RELEASE.jar:/Users/peddi/.m2/repository/org/springframework/spring-context/5.2.3.RELEASE/spring-context-5.2.3.RELEASE:/Users/peddi/.m2/repository/org/springframework/spring-beans/5.2.3.RELEASE/spring-beans-5.2.3.RELEASE
