package com.airbnb.lottie;

import java.util.List;

import static com.airbnb.lottie.MiscUtils.lerp;

class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
  ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> keyframes) {
    super(keyframes);
  }

  @Override public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float keyframeProgress) {
    ScaleXY startTransform = keyframe.startValue;
    ScaleXY endTransform = keyframe.endValue;
    return new ScaleXY(
        lerp(startTransform.getScaleX(), endTransform.getScaleX(), keyframeProgress),
        lerp(startTransform.getScaleY(), endTransform.getScaleY(), keyframeProgress));
  }
}
