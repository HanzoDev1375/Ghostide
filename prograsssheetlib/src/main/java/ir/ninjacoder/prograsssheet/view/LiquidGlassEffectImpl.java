package ir.ninjacoder.prograsssheet.view;

import android.graphics.RenderNode;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.card.MaterialCardView;

public class LiquidGlassEffectImpl {
  public static void bindByView(View frame, int color) {
    var renderNode = new RenderNode("LiquidGlassEffect");
    LiquidGlassEffect liquidGlassEffect = new LiquidGlassEffect(renderNode, frame.getContext());
  //  frame.setRenderNode(renderNode);
    liquidGlassEffect.update(
        0f, 0f, frame.getWidth(), frame.getHeight(), 20f, 20f, 20f, 20f, 5f, 0.5f, 0.2f, color);
  }

  public static void bindByMaterialCardView(MaterialCardView card, int color) {
    bindByView(card, color);
    
  }
}
