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

    // ====== MaterialCardView Properties ======
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
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "cardElevation",
        "setCardElevation()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "cardMaxElevation",
        "setMaxCardElevation()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "rippleColor",
        "setRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "checkedIcon",
        "setCheckedIcon()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "checkedIconTint",
        "setCheckedIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "checkedIconMargin",
        "setCheckedIconMargin()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.card.MaterialCardView",
        "checkedIconSize",
        "setCheckedIconSize()",
        PropertyType.Size,
        "app:"),

    // ====== Chip Properties ======
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
        "setChipStrokeWidth()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipStrokeColor",
        "setChipStrokeColor()",
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
        "chipMinTouchTargetSize",
        "setChipMinTouchTargetSize()",
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
        "checkedIcon",
        "setCheckedIcon()",
        PropertyType.DrawableResource,
        "app:"),
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
        "setChipIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "chipIconSize",
        "setChipIconSize()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "closeIcon",
        "setCloseIcon()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "closeIconVisible",
        "setCloseIconVisible()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "closeIconTint",
        "setCloseIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "closeIconSize",
        "setCloseIconSize()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "textStartPadding",
        "setTextStartPadding()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.Chip",
        "textEndPadding",
        "setTextEndPadding()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.ChipGroup",
        "singleLine",
        "setSingleLine()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.ChipGroup",
        "singleSelection",
        "setSingleSelection()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.chip.ChipGroup",
        "checkedChip",
        "setCheckedChip()",
        PropertyType.Int,
        "app:"),

    // ====== TextInputLayout Properties ======
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxBackgroundColor",
        "setBoxBackgroundColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxBackgroundMode",
        "setBoxBackgroundMode()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeColor",
        "setBoxStrokeColor()",
        PropertyType.Color,
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
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "boxStrokeErrorColor",
        "setBoxStrokeErrorColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "hintTextColor",
        "setHintTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "defaultHintTextColor",
        "setDefaultHintTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "errorTextColor",
        "setErrorTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "helperTextTextColor",
        "setHelperTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterTextColor",
        "setCounterTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterOverflowTextColor",
        "setCounterOverflowTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "placeholderTextColor",
        "setPlaceholderTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "prefixTextColor",
        "setPrefixTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "suffixTextColor",
        "setSuffixTextColor()",
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
        PropertyType.Int,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "helperTextEnabled",
        "setHelperTextEnabled()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "errorEnabled",
        "setErrorEnabled()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "passwordToggleEnabled",
        "setPasswordVisibilityToggleEnabled()",
        PropertyType.Bool,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "passwordToggleTint",
        "setPasswordVisibilityToggleTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "endIconTint",
        "setEndIconTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "startIconTint",
        "setStartIconTintList()",
        PropertyType.Color,
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
        "helperTextTextAppearance",
        "setHelperTextTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.textfield.TextInputLayout",
        "counterTextAppearance",
        "setCounterTextAppearance()",
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
        "shapeAppearance",
        "setShapeAppearanceModel()",
        PropertyType.TextAppearance,
        "app:"),

    // ====== FAB Properties ======
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "backgroundTint",
        "setBackgroundTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "tint",
        "setImageTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "fabSize",
        "setSize()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "fabCustomSize",
        "setCustomSize()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "elevation",
        "setCompatElevation()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "hoveredFocusedTranslationZ",
        "setHoveredFocusedTranslationZ()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "pressedTranslationZ",
        "setPressedTranslationZ()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "rippleColor",
        "setRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.FloatingActionButton",
        "borderWidth",
        "setBorderWidth()",
        PropertyType.Size,
        "app:"),

    // ====== ExtendedFAB Properties ======
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton",
        "backgroundTint",
        "setBackgroundTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton",
        "iconTint",
        "setIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton",
        "elevation",
        "setCompatElevation()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton",
        "rippleColor",
        "setRippleColor()",
        PropertyType.Color,
        "app:"),

    // ====== Slider Properties ======
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "sliderColor",
        "setSliderColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "sliderStrokeColor",
        "setSliderStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "haloColor",
        "setHaloColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "haloRadius",
        "setHaloRadius()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "labelStyle",
        "setLabelStyle()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "labelBehavior",
        "setLabelBehavior()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "thumbColor",
        "setThumbColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "thumbRadius",
        "setThumbRadius()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "thumbStrokeColor",
        "setThumbStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "thumbStrokeWidth",
        "setThumbStrokeWidth()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "tickColor",
        "setTickColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "tickColorActive",
        "setTickColorActive()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "tickColorInactive",
        "setTickColorInactive()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "trackColor",
        "setTrackColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "trackColorActive",
        "setTrackColorActive()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "trackColorInactive",
        "setTrackColorInactive()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.slider.Slider",
        "trackHeight",
        "setTrackHeight()",
        PropertyType.Size,
        "app:"),

    // ====== TabLayout Properties ======
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabIndicatorColor",
        "setSelectedTabIndicatorColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabIndicatorHeight",
        "setSelectedTabIndicatorHeight()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabTextColor",
        "setTabTextColors()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabSelectedTextColor",
        "setTabTextColors()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabMode",
        "setTabMode()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabGravity",
        "setTabGravity()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabBackground",
        "setBackground()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabRippleColor",
        "setTabRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.tabs.TabLayout",
        "tabIndicatorAnimationMode",
        "setTabIndicatorAnimationMode()",
        PropertyType.IntConstant,
        "app:"),

    // ====== BottomAppBar Properties ======
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "backgroundTint",
        "setBackgroundTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "fabAlignmentMode",
        "setFabAlignmentMode()",
        PropertyType.IntConstant,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "fabCradleMargin",
        "setFabCradleMargin()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "fabCradleRoundedCornerRadius",
        "setFabCradleRoundedCornerRadius()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "fabCradleVerticalOffset",
        "setCradleVerticalOffset()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomappbar.BottomAppBar",
        "navigationIconTint",
        "setNavigationIconTint()",
        PropertyType.Color,
        "app:"),

    // ====== NavigationView Properties ======
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "itemTextColor",
        "setItemTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "itemIconTint",
        "setItemIconTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "itemBackground",
        "setItemBackground()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "itemTextAppearance",
        "setItemTextAppearance()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "headerLayout",
        "setHeaderLayout()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.navigation.NavigationView",
        "menu",
        "setMenu()",
        PropertyType.TextAppearance,
        "app:"),

    // ====== BottomNavigationView Properties ======
    new PropertySpec(
        "com.google.android.material.bottomnavigation.BottomNavigationView",
        "itemTextColor",
        "setItemTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomnavigation.BottomNavigationView",
        "itemIconTint",
        "setItemIconTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomnavigation.BottomNavigationView",
        "itemBackground",
        "setItemBackground()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomnavigation.BottomNavigationView",
        "itemRippleColor",
        "setItemRippleColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.bottomnavigation.BottomNavigationView",
        "labelVisibilityMode",
        "setLabelVisibilityMode()",
        PropertyType.IntConstant,
        "app:"),

    // ====== MaterialToolbar Properties ======
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "title",
        "setTitle()",
        PropertyType.Text,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "titleTextColor",
        "setTitleTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "subtitle",
        "setSubtitle()",
        PropertyType.Text,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "subtitleTextColor",
        "setSubtitleTextColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "navigationIconTint",
        "setNavigationIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "logo",
        "setLogo()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.appbar.MaterialToolbar",
        "overFlowIcon",
        "setOverflowIcon()",
        PropertyType.DrawableResource,
        "app:"),

    // ====== ProgressIndicator Properties ======
    new PropertySpec(
        "com.google.android.material.progressindicator.LinearProgressIndicator",
        "indicatorColor",
        "setIndicatorColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.LinearProgressIndicator",
        "trackColor",
        "setTrackColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.LinearProgressIndicator",
        "trackThickness",
        "setTrackThickness()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.CircularProgressIndicator",
        "indicatorColor",
        "setIndicatorColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.CircularProgressIndicator",
        "trackColor",
        "setTrackColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.CircularProgressIndicator",
        "trackThickness",
        "setTrackThickness()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.progressindicator.CircularProgressIndicator",
        "indicatorSize",
        "setIndicatorSize()",
        PropertyType.Size,
        "app:"),

    // ====== MaterialButton Properties ======
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "backgroundTint",
        "setBackgroundTintList()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "iconTint",
        "setIconTint()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "icon",
        "setIcon()",
        PropertyType.DrawableResource,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "iconSize",
        "setIconSize()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "cornerRadius",
        "setCornerRadius()",
        PropertyType.Size,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "strokeColor",
        "setStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.button.MaterialButton",
        "strokeWidth",
        "setStrokeWidth()",
        PropertyType.Size,
        "app:"),

    // ====== ShapeableImageView Properties ======
    new PropertySpec(
        "com.google.android.material.imageview.ShapeableImageView",
        "shapeAppearance",
        "setShapeAppearanceModel()",
        PropertyType.TextAppearance,
        "app:"),
    new PropertySpec(
        "com.google.android.material.imageview.ShapeableImageView",
        "strokeColor",
        "setStrokeColor()",
        PropertyType.Color,
        "app:"),
    new PropertySpec(
        "com.google.android.material.imageview.ShapeableImageView",
        "strokeWidth",
        "setStrokeWidth()",
        PropertyType.Size,
        "app:"),
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
    FloatSize(Integer.TYPE),
    TextSize(Integer.TYPE),
    Text(CharSequence.class),
    Float(Integer.TYPE),
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
