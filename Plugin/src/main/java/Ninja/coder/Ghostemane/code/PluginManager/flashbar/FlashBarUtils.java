package Ninja.coder.Ghostemane.code.PluginManager.flashbar;

import Ninja.coder.Ghostemane.code.PluginManager.*;
import Ninja.coder.Ghostemane.code.PluginManager.R;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import androidx.appcompat.app.AppCompatActivity;
import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;

public class FlashBarUtils {

  public AppCompatActivity c;
  private Flashbar bar = null;

  protected static final String name = "FLASHBAR^";

  public FlashBarUtils(AppCompatActivity c) {
    this.c = c;
  }

  public Flashbar basic(String massges) {
    return new Flashbar.Builder(c).gravity(Flashbar.Gravity.BOTTOM).message(massges).build();
  }

  @isField
  public void basic(Spannable massges) {
    new Flashbar.Builder(c).gravity(Flashbar.Gravity.BOTTOM).message(massges).build();
  }

  @isField
  public void basicDuration(int duration, String massges) {
    new Flashbar.Builder(c)
        .gravity(Flashbar.Gravity.TOP)
        .duration(duration)
        .message(massges)
        .build();
  }

  @isField
  public void gravityTop(String msg) {
    new Flashbar.Builder(c).gravity(Flashbar.Gravity.TOP).message(msg).build();
  }

  @isField
  public void gravityBottom(String msg) {
    new Flashbar.Builder(c).gravity(Flashbar.Gravity.BOTTOM).message(msg).build();
  }

  @isField
  public void titleBasic(String massges, String title) {
    new Flashbar.Builder(c).gravity(Flashbar.Gravity.BOTTOM).title(title).message(massges).build();
  }

  @isField
  public void setCustomGravity(Flashbar.Gravity g, String massges) {

    new Flashbar.Builder(c).gravity(g).message(massges).build();
  }

  public Flashbar setCustomMassge(String m) {
    return new Flashbar.Builder(c)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Save File")
        .message(m)
        .duration(600)
        .titleColor(Color.WHITE)
        .messageColor(Color.WHITE)
        .castShadow(true, 4)
        .enterAnimation(FlashAnim.with(c).animateBar().duration(400).slideFromLeft().overshoot())
        .exitAnimation(FlashAnim.with(c).animateBar().duration(250).slideFromLeft().accelerate())
        .backgroundColor(Color.parseColor("#FF030111"))
        .build();
  }

  public void setCustomMassges(String f) {
    if (bar == null) {
      bar = setCustomMassge(f);
    }
    bar.show();
    new Handler(Looper.getMainLooper())
        .postDelayed(
            () -> {
              bar.dismiss();
            },
            1000);
  }
}
