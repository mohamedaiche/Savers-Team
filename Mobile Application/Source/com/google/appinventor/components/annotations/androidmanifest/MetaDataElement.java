package com.google.appinventor.components.annotations.androidmanifest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface MetaDataElement
{
  String name();
  
  String resource() default "";
  
  String value() default "";
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\annotations\androidmanifest\MetaDataElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */