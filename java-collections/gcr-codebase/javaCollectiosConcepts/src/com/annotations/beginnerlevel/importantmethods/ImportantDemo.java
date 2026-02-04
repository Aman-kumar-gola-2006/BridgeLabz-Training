package com.annotations.beginnerlevel.importantmethods;
import java.lang.reflect.Method;

public class ImportantDemo {

    @ImportantMethod
    public void saveData() {}

    @ImportantMethod(level = "LOW")
    public void loadData() {}

    public static void main(String[] args) {
        for (Method m : ImportantDemo.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " - " + im.level());
            }
        }
    }
}