package com.annotations.repeatableannotation;

import java.lang.annotation.*;

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BugReport {
    String description();
}