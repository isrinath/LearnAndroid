package com.airbnb.lottie;

import org.json.JSONObject;

class PolystarShape {
  enum Type {
    Star(1),
    Polygon(2);

    private final int value;

    Type(int value) {
      this.value = value;
    }

    static Type forValue(int value) {
      for (Type type : Type.values()) {
        if (type.value == value) {
          return type;
        }
      }
      return null;
    }
  }

  private final Type type;
  private final AnimatableFloatValue points;
  private final IAnimatablePathValue position;
  private final AnimatableFloatValue rotation;
  private final AnimatableFloatValue innerRadius;
  private final AnimatableFloatValue outerRadius;
  private final AnimatableFloatValue innerRoundedness;
  private final AnimatableFloatValue outerRoundedness;

  private PolystarShape(Type type, AnimatableFloatValue points, IAnimatablePathValue position,
      AnimatableFloatValue rotation, AnimatableFloatValue innerRadius,
      AnimatableFloatValue outerRadius, AnimatableFloatValue innerRoundedness,
      AnimatableFloatValue outerRoundedness) {
    this.type = type;
    this.points = points;
    this.position = position;
    this.rotation = rotation;
    this.innerRadius = innerRadius;
    this.outerRadius = outerRadius;
    this.innerRoundedness = innerRoundedness;
    this.outerRoundedness = outerRoundedness;
  }

  static class Factory {
    private Factory() {
    }

    static PolystarShape newInstance(JSONObject json, LottieComposition composition) {
      Type type = Type.forValue(json.optInt("sy"));
      AnimatableFloatValue points =
          AnimatableFloatValue.Factory.newInstance(json.optJSONObject("pt"), composition, false);
      IAnimatablePathValue position = AnimatablePathValue.createAnimatablePathOrSplitDimensionPath(
          json.optJSONObject("p"), composition);
      AnimatableFloatValue rotation =
          AnimatableFloatValue.Factory.newInstance(json.optJSONObject("r"), composition, false);
      AnimatableFloatValue outerRadius =
          AnimatableFloatValue.Factory.newInstance(json.optJSONObject("or"), composition);
      AnimatableFloatValue outerRoundedness =
          AnimatableFloatValue.Factory.newInstance(json.optJSONObject("os"), composition, false);
      AnimatableFloatValue innerRadius;
      AnimatableFloatValue innerRoundedness;

      if (type == Type.Star) {
        innerRadius =
            AnimatableFloatValue.Factory.newInstance(json.optJSONObject("ir"), composition);
        innerRoundedness =
            AnimatableFloatValue.Factory.newInstance(json.optJSONObject("is"), composition, false);
      } else {
        innerRadius = null;
        innerRoundedness = null;
      }
      return new PolystarShape(type, points, position, rotation, innerRadius, outerRadius,
          innerRoundedness, outerRoundedness);
    }
  }

  Type getType() {
    return type;
  }

  AnimatableFloatValue getPoints() {
    return points;
  }

  IAnimatablePathValue getPosition() {
    return position;
  }

  AnimatableFloatValue getRotation() {
    return rotation;
  }

  AnimatableFloatValue getInnerRadius() {
    return innerRadius;
  }

  AnimatableFloatValue getOuterRadius() {
    return outerRadius;
  }

  AnimatableFloatValue getInnerRoundedness() {
    return innerRoundedness;
  }

  AnimatableFloatValue getOuterRoundedness() {
    return outerRoundedness;
  }
}
