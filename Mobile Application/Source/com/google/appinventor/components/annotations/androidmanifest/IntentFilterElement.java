package com.google.appinventor.components.annotations.androidmanifest;

import java.lang.annotation.Annotation;

public @interface IntentFilterElement
{
  ActionElement[] actionElements();
  
  CategoryElement[] categoryElements() default {};
  
  DataElement[] dataElements() default {};
  
  String icon() default "";
  
  String label() default "";
  
  String priority() default "";
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\annotations\androidmanifest\IntentFilterElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */