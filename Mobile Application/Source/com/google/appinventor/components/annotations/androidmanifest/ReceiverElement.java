package com.google.appinventor.components.annotations.androidmanifest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ReceiverElement
{
  String enabled() default "";
  
  String exported() default "";
  
  String icon() default "";
  
  IntentFilterElement[] intentFilters() default {};
  
  String label() default "";
  
  MetaDataElement[] metaDataElements() default {};
  
  String name();
  
  String permission() default "";
  
  String process() default "";
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\annotations\androidmanifest\ReceiverElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */