package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class KitkatUtil
{
  public static List<SmsMessage> getMessagesFromIntent(Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    paramIntent = Telephony.Sms.Intents.getMessagesFromIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.length >= 0)) {
      Collections.addAll(localArrayList, paramIntent);
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\util\KitkatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */