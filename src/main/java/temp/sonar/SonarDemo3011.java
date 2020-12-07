package temp.sonar;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ClassName: SonarDemo01
 * Description: sonar squid:S3011 案例：Changing or bypassing accessibility is security-sensitive
 * data: 2020/12/07 21:46
 *
 * @author zhy
 * @version 1.0
 */
public class SonarDemo3011 {

    public void changeAccessible(Method method) {
        method.setAccessible(true);
    }

    public void changeAccessible(Field field) {
        field.setAccessible(true);
    }

    // spring 工具实现源码
    @SuppressWarnings("deprecation")  // on JDK 9
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) ||
                !Modifier.isPublic(field.getDeclaringClass().getModifiers()) ||
                Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }


    public void changeAccessibleWithSpring(Method method) {
        ReflectionUtils.makeAccessible(method); // spring 工具
        ReflectUtil.setAccessible(method);  // cu.hutool 工具
    }

    public void changeAccessibleWithSpring(Field field) {
        ReflectionUtils.makeAccessible(field); // spring 工具
        ReflectUtil.setAccessible(field); // cu.hutool 工具
    }

}
