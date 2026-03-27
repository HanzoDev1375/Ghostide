package ir.ninjacoder.prograsssheet.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RenderNode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class GlassFrameLayout extends FrameLayout {

  private LiquidGlassEffect liquidGlassEffect;
  private RenderNode renderNode;
  private int color;

  public GlassFrameLayout(Context context) {
    super(context);
    init();
  }

  public GlassFrameLayout(Context c, AttributeSet s) {
    super(c, s);
    init();
  }

  public GlassFrameLayout(Context c, AttributeSet s, int defstyle) {
    super(c, s, defstyle);
    init();
  }

  void init() {
    renderNode = new RenderNode("");
    liquidGlassEffect = new LiquidGlassEffect(renderNode, getContext());
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    // تنظیمات
    float left = 0;
    float top = 0;
    float right = getWidth();
    float bottom = getHeight();
    float radiusLeftTop = 20;
    float radiusRightTop = 20;
    float radiusRightBottom = 20;
    float radiusLeftBottom = 20;
    float thickness = 10;
    float intensity = 0.5f;
    float index = 0.2f;
    liquidGlassEffect.update(
        left,
        top,
        right,
        bottom,
        radiusLeftTop,
        radiusRightTop,
        radiusRightBottom,
        radiusLeftBottom,
        thickness,
        intensity,
        index,
        color);
    if (renderNode != null) canvas.drawRenderNode(renderNode);
  }

  public int getColor() {
    return this.color;
  }

  public void setColor(int color) {
    this.color = color;
  }
}
