// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloService.proto

package com.example.grpc.grpc;

/**
 * Protobuf enum {@code com.example.grpc.Sentiment}
 */
public enum Sentiment
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ANGRY = 0;</code>
   */
  ANGRY(0),
  /**
   * <code>SLEEPY = 2;</code>
   */
  SLEEPY(2),
  /**
   * <code>HAPPY = 3;</code>
   */
  HAPPY(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>ANGRY = 0;</code>
   */
  public static final int ANGRY_VALUE = 0;
  /**
   * <code>SLEEPY = 2;</code>
   */
  public static final int SLEEPY_VALUE = 2;
  /**
   * <code>HAPPY = 3;</code>
   */
  public static final int HAPPY_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Sentiment valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Sentiment forNumber(int value) {
    switch (value) {
      case 0: return ANGRY;
      case 2: return SLEEPY;
      case 3: return HAPPY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Sentiment>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Sentiment> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Sentiment>() {
          public Sentiment findValueByNumber(int number) {
            return Sentiment.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return HelloServiceOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final Sentiment[] VALUES = values();

  public static Sentiment valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Sentiment(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.example.grpc.Sentiment)
}

