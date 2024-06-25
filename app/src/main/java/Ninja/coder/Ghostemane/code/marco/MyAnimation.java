package Ninja.coder.Ghostemane.code.marco;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.transition.*;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.android.material.transition.MaterialSharedAxis;

public class MyAnimation extends Transition {

    protected static void showView(final View view) {
        if (view == null)
            return;

        // Convert the parent view to a ViewGroup
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;
        ViewGroup parentView = (ViewGroup) parent;

        // Create a new shared axis transition
        Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Y, true);
        // Apply the transition to the current scene
        TransitionManager.beginDelayedTransition(parentView, sharedAxis);
        view.setVisibility(View.VISIBLE);

    }

    protected static void hideView(final View view) {
        if (view == null)
            return;

        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;

        // Create a new shared axis transition
        Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Y, false);

        // Apply the transition to the current scene
        TransitionManager.beginDelayedTransition((ViewGroup) parent, sharedAxis);
        view.setVisibility(View.GONE);

    }

    public static void getLinearLayout(View layout) {
        KeyboardUtils.registerSoftInputChangedListener(((Activity) layout.getContext()), (soft) -> {
            if (soft > 1) {
                showView(layout);
            } else {
                hideView(layout);
            }
        });
    }

    public static void setMaterialFadeThrough(final View view) {
        if (view == null)
            return;
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;
        ViewGroup parentView = (ViewGroup) parent;
        Transition transition = new MaterialFadeThrough();
        TransitionManager.beginDelayedTransition(parentView, transition);
        view.setVisibility(View.VISIBLE);
    }

    public static void setMaterialFadeThroughGONE(final View view) {
        if (view == null)
            return;
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;
        ViewGroup parentView = (ViewGroup) parent;
        Transition transition = new MaterialFadeThrough();
        TransitionManager.beginDelayedTransition(parentView, transition);
        view.setVisibility(View.GONE);
    }

    public static void setMaterialContainerTransform(final View view) {
        if (view == null)
            return;
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;
        ViewGroup parentView = (ViewGroup) parent;
        Transition transition = new MaterialContainerTransform();
        TransitionManager.beginDelayedTransition(parentView, transition);
    }

    public static void setMaterialArcMotion(final View view) {
        if (view == null)
            return;

        // Get the parent view
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup))
            return;
        ViewGroup parentView = (ViewGroup) parent;

        // Create a ChangeBounds transition with ArcMotion
        Transition transition = new ChangeBounds();
        transition.setPathMotion(new ArcMotion());
        TransitionManager.beginDelayedTransition(parentView, transition);
    }

    @Override
    public void captureStartValues(TransitionValues arg0) {
    }

    @Override
    public void captureEndValues(TransitionValues arg0) {
    }

}
