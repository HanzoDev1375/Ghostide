package com.mcal.uidesigner;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.mcal.uidesigner.common.PositionalXMLReader;

import java.util.Arrays;
import java.util.Comparator;

public class XmlLayoutProperties {

  public static PropertySpec LAYOUT_TORIGHTOF =
      new PropertySpec(
          "android.widget.RelativeLayout$LayoutParams",
          "layout_toRightOf",
          "ProxyRelativeLayoutParams",
          "setRightOf()",
          PropertyType.ID);
  public static PropertySpec LAYOUT_TOLEFTOF =
      new PropertySpec(
          "android.widget.RelativeLayout$LayoutParams",
          "layout_toLeftOf",
          "ProxyRelativeLayoutParams",
          "setLeftOf()",
          PropertyType.ID);
  public static PropertySpec LAYOUT_BELOW =
      new PropertySpec(
          "android.widget.RelativeLayout$LayoutParams",
          "layout_below",
          "ProxyRelativeLayoutParams",
          "setBelow()",
          PropertyType.ID);
  public static PropertySpec LAYOUT_ABOVE =
      new PropertySpec(
          "android.widget.RelativeLayout$LayoutParams",
          "layout_above",
          "ProxyRelativeLayoutParams",
          "setAbove()",
          PropertyType.ID);
  public static PropertySpec LAYOUT_WIDTH =
      new PropertySpec(
          "android.view.ViewGroup$LayoutParams", "layout_width", "width", PropertyType.LayoutSize);
  public static PropertySpec LAYOUT_HEIGHT =
      new PropertySpec(
          "android.view.ViewGroup$LayoutParams",
          "layout_height",
          "height",
          PropertyType.LayoutSize);
  public static PropertySpec[] LAYOUT_PROPERTIES = {
    LAYOUT_WIDTH,
    LAYOUT_HEIGHT,
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_margin",
        "ProxyMarginLayoutParams",
        "setMargin()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginLeft",
        "leftMargin",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginRight",
        "rightMargin",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginTop",
        "topMargin",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginBottom",
        "bottomMargin",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginStart",
        "setMarginStart()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.ViewGroup$MarginLayoutParams",
        "layout_marginEnd",
        "setMarginEnd()",
        PropertyType.Size),
    new PropertySpec(
        "android.widget.LinearLayout$LayoutParams",
        "layout_gravity",
        "gravity",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.LinearLayout$LayoutParams", "layout_weight", "weight", PropertyType.Float),
    LAYOUT_BELOW,
    LAYOUT_ABOVE,
    LAYOUT_TORIGHTOF,
    LAYOUT_TOLEFTOF,
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_toEndOf",
        "ProxyRelativeLayoutParams",
        "setEndOf()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_toStartOf",
        "ProxyRelativeLayoutParams",
        "setStartOf()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignBaseline",
        "ProxyRelativeLayoutParams",
        "setAlignBaseline()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignBottom",
        "ProxyRelativeLayoutParams",
        "setAlignBottom()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignTop",
        "ProxyRelativeLayoutParams",
        "setAlignTop()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignEnd",
        "ProxyRelativeLayoutParams",
        "setAlignEnd()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignStart",
        "ProxyRelativeLayoutParams",
        "setAlignStart()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignRight",
        "ProxyRelativeLayoutParams",
        "setAlignRight()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignLeft",
        "ProxyRelativeLayoutParams",
        "setAlignLeft()",
        PropertyType.ID),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentBottom",
        "ProxyRelativeLayoutParams",
        "setAlignParentBottom()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentEnd",
        "ProxyRelativeLayoutParams",
        "setAlignParentEnd()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentLeft",
        "ProxyRelativeLayoutParams",
        "setAlignParentLeft()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentRight",
        "ProxyRelativeLayoutParams",
        "setAlignParentRight()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentStart",
        "ProxyRelativeLayoutParams",
        "setAlignParentStart()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_alignParentTop",
        "ProxyRelativeLayoutParams",
        "setAlignParentTop()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_centerHorizontal",
        "ProxyRelativeLayoutParams",
        "setCenterHorizontal()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_centerVertical",
        "ProxyRelativeLayoutParams",
        "setCenterVertical()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.RelativeLayout$LayoutParams",
        "layout_centerInParent",
        "ProxyRelativeLayoutParams",
        "setCenterInParent()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.GridLayout$LayoutParams",
        "layout_gravity",
        "ProxyGridLayoutParams",
        "setGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.GridLayout$LayoutParams",
        "layout_column",
        "ProxyGridLayoutParams",
        "setColumn()",
        PropertyType.Int),
    new PropertySpec(
        "android.widget.GridLayout$LayoutParams",
        "layout_columnSpan",
        "ProxyGridLayoutParams",
        "setColumnSpan()",
        PropertyType.Int),
    new PropertySpec(
        "android.widget.GridLayout$LayoutParams",
        "layout_row",
        "ProxyGridLayoutParams",
        "setRow()",
        PropertyType.Int),
    new PropertySpec(
        "android.widget.GridLayout$LayoutParams",
        "layout_rowSpan",
        "ProxyGridLayoutParams",
        "setRowSpan()",
        PropertyType.Int),
    new PropertySpec(
        "android.widget.FrameLayout$LayoutParams",
        "layout_gravity",
        "gravity",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.TableRow$LayoutParams", "layout_span", "span", PropertyType.Int),
    new PropertySpec(
        "android.widget.TableRow$LayoutParams",
        "layout_column",
        PositionalXMLReader.COLUMN,
        PropertyType.Int),
    new PropertySpec(
        "android.widget.AbsoluteLayout$LayoutParams", "layout_x", "x", PropertyType.Size),
    new PropertySpec(
        "android.widget.AbsoluteLayout$LayoutParams", "layout_y", "y", PropertyType.Size)
  };
  public static PropertySpec[] SORTED_PROPERTIES;
  public static PropertySpec[] VIEW_PROPERTIES = {
    new PropertySpec(
        "android.view.View", "padding", "ProxyViewPaddings", "setPadding()", PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingLeft",
        "ProxyViewPaddings",
        "setPaddingLeft()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingRight",
        "ProxyViewPaddings",
        "setPaddingRight()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingTop",
        "ProxyViewPaddings",
        "setPaddingTop()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingBottom",
        "ProxyViewPaddings",
        "setPaddingBottom()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingStart",
        "ProxyViewPaddings",
        "setPaddingStart()",
        PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "paddingEnd",
        "ProxyViewPaddings",
        "setPaddingEnd()",
        PropertyType.Size),
    new PropertySpec("android.view.View", "alpha", "setAlpha()", PropertyType.Float),
    new PropertySpec("android.view.View", "scaleX", "setScaleX()", PropertyType.Float),
    new PropertySpec("android.view.View", "scaleY", "setScaleY()", PropertyType.Float),
    new PropertySpec(
        "android.view.View", "translationX", "setTranslationX()", PropertyType.FloatSize),
    new PropertySpec(
        "android.view.View", "translationY", "setTranslationY()", PropertyType.FloatSize),
    new PropertySpec(
        "android.view.View", "translationZ", "setTranslationZ()", PropertyType.FloatSize),
    new PropertySpec("android.view.View", "rotation", "setRotation()", PropertyType.Float),
    new PropertySpec("android.view.View", "rotationX", "setRotationX()", PropertyType.Float),
    new PropertySpec("android.view.View", "rotationY", "setRotationY()", PropertyType.Float),
    new PropertySpec("android.view.View", "elevation", "setElevation()", PropertyType.FloatSize),
    new PropertySpec("android.view.View", "minHeight", "setMinimumHeight()", PropertyType.Size),
    new PropertySpec("android.view.View", "minWidth", "setMinimumWidth()", PropertyType.Size),
    new PropertySpec(
        "android.view.View",
        "textAlignment",
        "setTextAlignment()",
        PropertyType.IntConstant,
        "android.view.View",
        "TEXT_ALIGNMENT"),
    new PropertySpec(
        "android.view.View", "visibility", "setVisibility()", PropertyType.IntConstant),
    new PropertySpec(
        "android.view.View", "background", "setBackgroundDrawable()", PropertyType.Drawable),
    new PropertySpec("android.view.View", "onClick", "", PropertyType.Event),
    new PropertySpec(
        "android.view.ViewGroup", "clipChildren", "setClipChildren()", PropertyType.Bool),
    new PropertySpec(
        "android.view.ViewGroup", "clipToPadding", "setClipToPadding()", PropertyType.Bool),
    new PropertySpec(
        "android.widget.LinearLayout", "orientation", "setOrientation()", PropertyType.IntConstant),
    new PropertySpec(
        "android.widget.LinearLayout",
        "gravity",
        "setGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.LinearLayout",
        "baselineAligned",
        "setBaselineAligned()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.LinearLayout",
        "baselineAlignedChildIndex",
        "setBaselineAlignedChildIndex()",
        PropertyType.Int),
    new PropertySpec(
        "android.widget.LinearLayout",
        "measureWithLargestChild",
        "setMeasureWithLargestChildEnabled()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.LinearLayout", "weightSum", "setWeightSum()", PropertyType.Float),
    new PropertySpec(
        "android.widget.RelativeLayout",
        "gravity",
        "setGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.RelativeLayout", "ignoreGravity", "setIgnoreGravity()", PropertyType.ID),
    new PropertySpec(
        "android.widget.FrameLayout",
        "foregroundGravity",
        "setForegroundGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.FrameLayout",
        "measureAllChildren",
        "setMeasureAllChildren()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.GridLayout", "columnCount", "setColumnCount()", PropertyType.Int),
    new PropertySpec("android.widget.GridLayout", "rowCount", "setRowCount()", PropertyType.Int),
    new PropertySpec(
        "android.widget.GridLayout", "orientation", "setOrientation()", PropertyType.IntConstant),
    new PropertySpec(
        "android.widget.GridLayout",
        "columnOrderPreserved",
        "setColumnOrderPreserved()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.GridLayout",
        "rowOrderPreserved",
        "setRowOrderPreserved()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.GridLayout",
        "useDefaultMargins",
        "setUseDefaultMargins()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.GridLayout",
        "alignmentMode",
        "setAlignmentMode()",
        PropertyType.IntConstant,
        "android.widget.GridLayout",
        "ALIGN"),
    new PropertySpec(
        "android.widget.TextView",
        "textAppearance",
        "ProxyTextView",
        "setTextAppearance()",
        PropertyType.TextAppearance),
    new PropertySpec("android.widget.TextView", "text", "setText()", PropertyType.Text),
    new PropertySpec("android.widget.TextView", "hint", "setHint()", PropertyType.Text),
    new PropertySpec("android.widget.TextView", "height", "setHeight()", PropertyType.Size),
    new PropertySpec("android.widget.TextView", "width", "setWidth()", PropertyType.Size),
    new PropertySpec("android.widget.TextView", "maxHeight", "setMaxHeight()", PropertyType.Size),
    new PropertySpec("android.widget.TextView", "maxWidth", "setMaxWidth()", PropertyType.Size),
    new PropertySpec("android.widget.TextView", "ems", "setEms()", PropertyType.Int),
    new PropertySpec("android.widget.TextView", "minEms", "setMinEms()", PropertyType.Int),
    new PropertySpec("android.widget.TextView", "maxEms", "setMaxEms()", PropertyType.Int),
    new PropertySpec(
        "android.widget.TextView",
        "gravity",
        "setGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.TextView", "textScaleX", "setTextScaleX()", PropertyType.Float),
    new PropertySpec(
        "android.widget.TextView", "textScaleY", "setTextScaleY()", PropertyType.Float),
    new PropertySpec(
        "android.widget.TextView", "textIsSelectable", "setTextIsSelectable()", PropertyType.Bool),
    new PropertySpec("android.widget.TextView", "singleLine", "setSingleLine()", PropertyType.Bool),
    new PropertySpec("android.widget.TextView", "lines", "setLines()", PropertyType.Int),
    new PropertySpec("android.widget.TextView", "minLines", "setMinLines()", PropertyType.Int),
    new PropertySpec("android.widget.TextView", "maxLines", "setMaxLines()", PropertyType.Int),
    new PropertySpec("android.widget.TextView", "textColor", "setTextColor()", PropertyType.Color),
    new PropertySpec(
        "android.widget.TextView", "textColorHighlight", "setHighlightColor()", PropertyType.Color),
    new PropertySpec(
        "android.widget.TextView", "textColorHint", "setHintTextColor()", PropertyType.Color),
    new PropertySpec(
        "android.widget.TextView", "textColorLink", "setLinkTextColor()", PropertyType.Color),
    new PropertySpec(
        "android.widget.TextView",
        "ellipsize",
        "setEllipsize()",
        PropertyType.EnumConstant,
        "android.text.TextUtils$TruncateAt",
        null),
    new PropertySpec(
        "android.widget.TextView",
        "textStyle",
        "ProxyTextView",
        "setTextStyle()",
        PropertyType.IntConstant,
        "ProxyTextView",
        "TEXTSTYLE"),
    new PropertySpec(
        "android.widget.TextView",
        "typeface",
        "ProxyTextView",
        "setTypeface()",
        PropertyType.IntConstant,
        "ProxyTextView",
        "TYPEFACE"),
    new PropertySpec(
        "android.widget.TextView",
        "inputType",
        "ProxyTextView",
        "setInputType()",
        PropertyType.IntConstant,
        "ProxyTextView",
        "INPUTTYPE"),
    new PropertySpec("android.widget.TextView", "textSize", "setTextSize()", PropertyType.TextSize),
    new PropertySpec(
        "android.widget.TextView",
        "shadowColor",
        "ProxyTextView",
        "setShadowColor()",
        PropertyType.Color),
    new PropertySpec(
        "android.widget.TextView",
        "shadowDx",
        "ProxyTextView",
        "setShadowDx()",
        PropertyType.Float),
    new PropertySpec(
        "android.widget.TextView",
        "shadowDy",
        "ProxyTextView",
        "setShadowDy()",
        PropertyType.Float),
    new PropertySpec(
        "android.widget.TextView",
        "shadowRadius",
        "ProxyTextView",
        "setShadowRadius()",
        PropertyType.Float),
    new PropertySpec(
        "android.widget.ScrollView", "fillViewport", "setFillViewport()", PropertyType.Bool),
    new PropertySpec(
        "android.widget.ImageView", "src", "setImageDrawable()", PropertyType.DrawableResource),
    new PropertySpec(
        "android.widget.ImageView",
        "scaleType",
        "setScaleType()",
        PropertyType.EnumConstant,
        "android.widget.ImageView$ScaleType",
        null),
    new PropertySpec(
        "android.widget.ImageView", "adjustViewBounds", "setAdjustViewBounds()", PropertyType.Bool),
    new PropertySpec("android.widget.ImageView", "baseLine", "setBaseLine()", PropertyType.Size),
    new PropertySpec(
        "android.widget.ImageView",
        "baselineAlignBottom",
        "setBaselineAlignBottom()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.ImageView", "cropToPadding", "setCropToPadding()", PropertyType.Bool),
    new PropertySpec("android.widget.ImageView", "maxHeight", "setMaxHeight()", PropertyType.Size),
    new PropertySpec("android.widget.ImageView", "maxWidth", "setMaxWidth()", PropertyType.Size),
    new PropertySpec(
        "android.widget.ProgressBar", "indeterminate", "setIndeterminate()", PropertyType.Bool),
    new PropertySpec(
        "android.widget.ProgressBar", "indeterminateOnly", "setIndeterminate()", PropertyType.Bool),
    new PropertySpec(
        "android.widget.ProgressBar",
        "indeterminateDrawable",
        "setIndeterminateDrawable()",
        PropertyType.DrawableResource),
    new PropertySpec(
        "android.widget.ProgressBar",
        "progressDrawable",
        "setProgressDrawable()",
        PropertyType.DrawableResource),
    new PropertySpec(
        "android.widget.Switch", "switchMinWidth", "setSwitchMinWidth()", PropertyType.Size),
    new PropertySpec(
        "android.widget.Switch", "switchPadding", "setSwitchPadding()", PropertyType.Size),
    new PropertySpec("android.widget.Switch", "textOff", "setTextOff()", PropertyType.Text),
    new PropertySpec("android.widget.Switch", "textOn", "setTextOn()", PropertyType.Text),
    new PropertySpec(
        "android.widget.Switch", "thumbTextPadding", "setThumbTextPadding()", PropertyType.Size),
    new PropertySpec("android.widget.Switch", "thumb", "setThumbDrawable()", PropertyType.Drawable),
    new PropertySpec("android.widget.Switch", "track", "setTrackDrawable()", PropertyType.Drawable),
    new PropertySpec("android.widget.ToggleButton", "textOff", "setTextOff()", PropertyType.Text),
    new PropertySpec("android.widget.ToggleButton", "textOn", "setTextOn()", PropertyType.Text),
    new PropertySpec(
        "android.widget.Spinner",
        "gravity",
        "setGravity()",
        PropertyType.IntConstant,
        "android.view.Gravity",
        null),
    new PropertySpec(
        "android.widget.Spinner", "dropDownWidth", "setDropDownWidth()", PropertyType.Size),
    new PropertySpec(
        "android.widget.Spinner",
        "dropDownHorizontalOffset",
        "setDropDownHorizontalOffset()",
        PropertyType.Size),
    new PropertySpec("android.widget.Spinner", "prompt", "setPrompt()", PropertyType.Text),
    new PropertySpec(
        "android.widget.Spinner",
        "dropDownVerticalOffset",
        "setDropDownVerticalOffset()",
        PropertyType.Size),
    new PropertySpec(
        "android.widget.Spinner",
        "popupBackground",
        "setPopupBackgroundDrawable()",
        PropertyType.Drawable),
    new PropertySpec("android.widget.RatingBar", "numStars", "setNumStars()", PropertyType.Int),
    new PropertySpec("android.widget.RatingBar", "rating", "setRating()", PropertyType.Float),
    new PropertySpec("android.widget.RatingBar", "stepSize", "setStepSize()", PropertyType.Float),
    new PropertySpec(
        "android.widget.RatingBar", "isIndicator", "setIsIndicator()", PropertyType.Bool),
    new PropertySpec(
        "android.widget.DatePicker",
        "calendarViewShown",
        "setCalendarViewShown()",
        PropertyType.Bool),
    new PropertySpec(
        "android.widget.DatePicker", "spinnersShown", "setSpinnersShown()", PropertyType.Bool),
    new PropertySpec("android.widget.ListView", "divider", "setDivider()", PropertyType.Drawable),
    new PropertySpec(
        "android.widget.ListView", "dividerHeight", "setDividerHeight()", PropertyType.Size),
    new PropertySpec(
        "com.mcal.uidesigner.view.IncludeLayout", "layout", "setLayout()", PropertyType.Text),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "cardBackgroundColor",
        "setCardBackgroundColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "strokeColor",
        "setStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "cardForegroundColor",
        "setCardForegroundColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "strokeWidth",
        "setStrokeWidth()",
        PropertyType.Int,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "cardElevation",
        "setCardElevation()",
        PropertyType.Int,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "rippleColor",
        "setRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipBackgroundColor",
        "setChipBackgroundColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "rippleColor",
        "setRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipStrokeWidth",
        "setChipStrokeWidthResource()",
        PropertyType.Int,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipStrokeColor",
        "setStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipMinHeight",
        "setChipMinHeight()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "checkable",
        "setCheckable()",
        PropertyType.Bool,
        "android:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipIcon",
        "setChipIcon()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipIconVisible",
        "setChipIconVisible()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipIconTint",
        "setChipIconTintResource()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.ChipGroup",
        "singleLine",
        "setSingleLine()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxBackgroundColor",
        "setBoxBackgroundColor()",
        PropertyType.Color,"app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "elevation",
        "setElevation()",
        PropertyType.Size,"app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxCornerRadiusTopStart",
        "setBoxCornerRadiusTopStart()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxCornerRadiusTopEnd",
        "setBoxCornerRadiusTopEnd()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxCornerRadiusBottomEnd",
        "setBoxCornerRadiusBottomEnd()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeWidth",
        "setBoxStrokeWidth()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeWidthFocused",
        "setBoxStrokeWidthFocused()",
        PropertyType.Size,"app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeColor",
        "setBoxStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeErrorColor",
        "setBoxStrokeErrorColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterEnabled",
        "setCounterEnabled()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterMaxLength",
        "setCounterMaxLength()",
        PropertyType.Text,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterTextColor",
        "setCounterTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterTextAppearance",
        "setCounterTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "hintTextAppearance",
        "setHintTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "errorTextAppearance",
        "setErrorTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterOverflowTextAppearance",
        "setCounterOverflowTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "placeholderTextAppearance",
        "setPlaceholderTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "helperTextTextAppearance",
        "setHelperTextTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "TextInputLayout",
        "textColorHint",
        "setDefaultHintTextColor()",
        PropertyType.Color,"android:")
  };

  static {
    SORTED_PROPERTIES = new PropertySpec[LAYOUT_PROPERTIES.length + VIEW_PROPERTIES.length];
    System.arraycopy(LAYOUT_PROPERTIES, 0, SORTED_PROPERTIES, 0, LAYOUT_PROPERTIES.length);
    System.arraycopy(
        VIEW_PROPERTIES, 0, SORTED_PROPERTIES, LAYOUT_PROPERTIES.length, VIEW_PROPERTIES.length);
    Arrays.sort(SORTED_PROPERTIES, Comparator.comparing(PropertySpec::getDisplayName));
  }

  public enum PropertyType {
    IntConstant(Integer.TYPE),
    EnumConstant(Enum.class),
    LayoutSize(Integer.TYPE),
    Size(Integer.TYPE),
    FloatSize(Integer.TYPE), // Float.TYPE
    TextSize(Integer.TYPE), // Float.TYPE
    Text(CharSequence.class),
    Float(Integer.TYPE), // Float.TYPE
    Int(Integer.TYPE),
    Bool(Boolean.TYPE),
    ID(Integer.TYPE),
    Color(Integer.TYPE),
    Drawable(Drawable.class),
    DrawableResource(Drawable.class),
    TextAppearance(String.class),
    Event(CharSequence.class);

    public final Class<?> valueType;

    PropertyType(Class<?> cls) {
      this.valueType = cls;
    }
  }

  public static class PropertySpec {
    public String attrName;
    public Class<?> constantClass;
    public String constantClassName;
    public String constantFieldPrefix;
    public boolean isLayoutProperty;
    public String setterName;
    public Class<?> setterProxyClass;
    public Class<?> targetClass;
    public PropertyType type;
    private String displayName;

    public PropertySpec(
        String className,
        String name,
        String setterProxyClassName,
        String setterName,
        PropertyType type,
        String constantClassName,
        String constantFieldPrefix) {
      this(className, name, setterName, type, constantClassName, constantFieldPrefix);
      this.setterProxyClass = resolveType(setterProxyClassName);
    }

    public PropertySpec(
        String className,
        String name,
        String setterName,
        PropertyType type,
        String constantClassName,
        String constantFieldPrefix) {
      this(className, name, setterName, type);
      this.constantClass = resolveType(constantClassName);
      this.constantClassName = constantClassName;
      this.constantFieldPrefix = constantFieldPrefix;
    }

    public PropertySpec(
        String className,
        String name,
        String setterProxyClassName,
        String setterName,
        PropertyType type) {
      this(className, name, setterName, type);
      this.setterProxyClass = resolveType(setterProxyClassName);
    }

    public PropertySpec(
        String className, @NonNull String name, String setterName, PropertyType type) {
      Class<?> resolveType = resolveType(className);
      this.constantClass = resolveType;
      this.targetClass = resolveType;
      this.setterName = setterName;
      this.attrName = "android:" + name;
      this.type = type;
      this.isLayoutProperty = name.startsWith("layout_");
      createDisplayName("android:");
    }

    public PropertySpec(
        String className,
        @NonNull String name,
        String setterName,
        PropertyType type,
        String typeSpace) {
      Class<?> resolveType = resolveType(className);
      this.constantClass = resolveType;
      this.targetClass = resolveType;
      this.setterName = setterName;
      this.attrName = typeSpace + name;
      this.type = type;
      this.isLayoutProperty = name.startsWith("layout_");
      createDisplayName(typeSpace);
    }



    @Nullable
    private Class<?> resolveType(@NonNull String className) {
      Class<?> cls;
      try {
        if (!className.contains(".")) {
          cls = Class.forName(XmlLayoutProperties.class.getPackage().getName() + "." + className);
        } else {
          cls = Class.forName(className);
        }
        return cls;
      } catch (ClassNotFoundException e) {
        return null;
      }
    }

    public String getDisplayName() {
      return this.displayName;
    }

    private void createDisplayName(String typeSpace) {
      String name = attrName.substring(typeSpace.length());
      StringBuilder result = new StringBuilder();
      result.append(Character.toUpperCase(name.charAt(0)));
      boolean nextUpper = false;
      for (int i = 1; i < name.length(); i++) {
        char ch = name.charAt(i);
        if (nextUpper) {
          result.append(Character.toUpperCase(ch));
          nextUpper = false;
        } else if (ch == '_') {
          nextUpper = true;
          result.append(" ");
        } else {
          if (Character.isUpperCase(ch)) {
            result.append(" ");
          }
          result.append(ch);
        }
      }
      displayName = result.toString();
    }
  }
}
