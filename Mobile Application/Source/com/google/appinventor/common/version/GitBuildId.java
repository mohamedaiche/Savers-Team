package com.google.appinventor.common.version;

public final class GitBuildId
{
  public static final String ACRA_URI = "${acra.uri}";
  public static final String ANT_BUILD_DATE = "March 5 2017";
  public static final String GIT_BUILD_FINGERPRINT = "8b72310c0b634c4c02ac30dfbe3b365242030506";
  public static final String GIT_BUILD_VERSION = "nb155";
  
  public static String getAcraUri()
  {
    if ("${acra.uri}".equals("${acra.uri}")) {
      return "";
    }
    return "${acra.uri}".trim();
  }
  
  public static String getDate()
  {
    return "March 5 2017";
  }
  
  public static String getFingerprint()
  {
    return "8b72310c0b634c4c02ac30dfbe3b365242030506";
  }
  
  public static String getVersion()
  {
    String str = "nb155";
    if (("nb155" == "") || ("nb155".contains(" "))) {
      str = "none";
    }
    return str;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\common\version\GitBuildId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */