package com.airbnb.lottie;

import org.json.JSONObject;

class RectangleShape {
  private final IAnimatablePathValue position;
  private final AnimatablePointValue size;
  private final AnimatableFloatValue cornerRadius;

  private RectangleShape(IAnimatablePathValue position, AnimatablePointValue size,
      AnimatableFloatValue cornerRadius) {
    this.position = position;
    this.size = size;
    this.cornerRadius = cornerRadius;
  }

  static class Factory {
    private Factory() {
    }

    static RectangleShape newInstance(JSONObject json, LottieComposition composition) {
      return new RectangleShape(
          AnimatablePathValue.createAnimatablePathOrSplitDimensionPath(
              json.optJSONObject("p"), composition),
          AnimatablePointValue.Factory.newInstance(json.optJSONObject("s"), composition),
          AnimatableFloatValue.Factory.newInstance(json.optJSONObject("r"), composition));
    }
  }

  AnimatableFloatValue getCornerRadius() {
    return cornerRadius;
  }

  AnimatablePointValue getSize() {
    return size;
  }

  IAnimatablePathValue getPosition() {
    return position;
  }

  @Override public String toString() {
    return "RectangleShape{" + "cornerRadius=" + cornerRadius.getInitialValue() +
        ", position=" + position +
        ", size=" + size +
        '}';
  }
}
