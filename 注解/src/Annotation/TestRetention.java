package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//表示在上面级别保存改注释信息，用于描述注解的生命周期
//取值SOURCE(在源文件中有效)，CLASS(在class文件中有效)，RUNTIME(运行时有效，可以被反射读取)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestRetention {

}
