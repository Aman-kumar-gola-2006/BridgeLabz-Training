package com.reflection.intermediatelevel.retrieveanootationsatruntime;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
	String name();
}