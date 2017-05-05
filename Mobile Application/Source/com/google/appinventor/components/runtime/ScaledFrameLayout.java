package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;

public class ScaledFrameLayout
  extends ViewGroup
{
  private int mLeftWidth;
  private int mRightWidth;
  private float mScale = 1.0F;
  private final Rect mTmpChildRect = new Rect();
  private final Rect mTmpContainerRect = new Rect();
  
  public ScaledFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScaledFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaledFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClipChildren(false);
  }
  
  private void updatePadding(int paramInt1, int paramInt2)
  {
    setPadding(0, 0, (int)(paramInt1 * (this.mScale - 1.0F) / this.mScale), (int)(paramInt2 * (this.mScale - 1.0F) / this.mScale));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save(1);
    paramCanvas.scale(this.mScale, this.mScale);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.setLocation(paramMotionEvent.getX() * (1.0F / this.mScale), paramMotionEvent.getY() * (1.0F / this.mScale));
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    int i = (int)(paramArrayOfInt[0] * this.mScale);
    int j = (int)(paramArrayOfInt[1] * this.mScale);
    paramArrayOfInt = new Rect((int)(paramRect.left * this.mScale), (int)(paramRect.top * this.mScale), (int)(paramRect.right * this.mScale), (int)(paramRect.bottom * this.mScale));
    invalidate(paramArrayOfInt);
    return super.invalidateChildInParent(new int[] { i, j }, paramArrayOfInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    paramInt3 = getPaddingLeft();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      View localView = getChildAt(paramInt1);
      int i = paramInt3;
      if (localView.getVisibility() != 8)
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        this.mTmpContainerRect.left = paramInt3;
        this.mTmpContainerRect.right = paramInt3;
        i = this.mTmpContainerRect.right;
        this.mTmpContainerRect.top = k;
        this.mTmpContainerRect.bottom = (paramInt4 - paramInt2 - m);
        Gravity.apply(51, n, i1, this.mTmpContainerRect, this.mTmpChildRect);
        localView.layout(this.mTmpChildRect.left, this.mTmpChildRect.top, this.mTmpChildRect.right, this.mTmpChildRect.bottom);
      }
      paramInt1 += 1;
      paramInt3 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    this.mLeftWidth = 0;
    this.mRightWidth = 0;
    int j = 0;
    int i = 0;
    int k = 0;
    while (k < i1)
    {
      View localView = getChildAt(k);
      int n = i;
      m = j;
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        this.mLeftWidth += Math.max(0, localView.getMeasuredWidth());
        j = Math.max(j, localView.getMeasuredHeight());
        n = i;
        m = j;
        if (SdkLevel.getLevel() >= 11)
        {
          n = HoneycombUtil.combineMeasuredStates(this, i, HoneycombUtil.getMeasuredState(localView));
          m = j;
        }
      }
      k += 1;
      i = n;
      j = m;
    }
    k = this.mLeftWidth;
    int m = this.mRightWidth;
    j = Math.max(j, getSuggestedMinimumHeight());
    k = Math.max(0 + (k + m), getSuggestedMinimumWidth());
    if (SdkLevel.getLevel() >= 11)
    {
      setMeasuredDimension(HoneycombUtil.resolveSizeAndState(this, k, paramInt1, i), HoneycombUtil.resolveSizeAndState(this, j, paramInt2, i << 16));
      return;
    }
    setMeasuredDimension(resolveSize(k, paramInt1), resolveSize(j, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updatePadding(paramInt1, paramInt2);
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
    updatePadding(getWidth(), getHeight());
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\ScaledFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */