/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package cgl.iotcloud.core.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all") public class THeartBeatRequest implements org.apache.thrift.TBase<THeartBeatRequest, THeartBeatRequest._Fields>, java.io.Serializable, Cloneable, Comparable<THeartBeatRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("THeartBeatRequest");

  private static final org.apache.thrift.protocol.TField SENSORS_FIELD_DESC = new org.apache.thrift.protocol.TField("sensors", org.apache.thrift.protocol.TType.I32, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new THeartBeatRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new THeartBeatRequestTupleSchemeFactory());
  }

  public int sensors; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SENSORS((short)1, "sensors");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SENSORS
          return SENSORS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SENSORS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SENSORS, new org.apache.thrift.meta_data.FieldMetaData("sensors", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(THeartBeatRequest.class, metaDataMap);
  }

  public THeartBeatRequest() {
  }

  public THeartBeatRequest(
    int sensors)
  {
    this();
    this.sensors = sensors;
    setSensorsIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public THeartBeatRequest(THeartBeatRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sensors = other.sensors;
  }

  public THeartBeatRequest deepCopy() {
    return new THeartBeatRequest(this);
  }

  @Override
  public void clear() {
    setSensorsIsSet(false);
    this.sensors = 0;
  }

  public int getSensors() {
    return this.sensors;
  }

  public THeartBeatRequest setSensors(int sensors) {
    this.sensors = sensors;
    setSensorsIsSet(true);
    return this;
  }

  public void unsetSensors() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SENSORS_ISSET_ID);
  }

  /** Returns true if field sensors is set (has been assigned a value) and false otherwise */
  public boolean isSetSensors() {
    return EncodingUtils.testBit(__isset_bitfield, __SENSORS_ISSET_ID);
  }

  public void setSensorsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SENSORS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SENSORS:
      if (value == null) {
        unsetSensors();
      } else {
        setSensors((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SENSORS:
      return Integer.valueOf(getSensors());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SENSORS:
      return isSetSensors();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof THeartBeatRequest)
      return this.equals((THeartBeatRequest)that);
    return false;
  }

  public boolean equals(THeartBeatRequest that) {
    if (that == null)
      return false;

    boolean this_present_sensors = true;
    boolean that_present_sensors = true;
    if (this_present_sensors || that_present_sensors) {
      if (!(this_present_sensors && that_present_sensors))
        return false;
      if (this.sensors != that.sensors)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(THeartBeatRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSensors()).compareTo(other.isSetSensors());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSensors()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sensors, other.sensors);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("THeartBeatRequest(");
    boolean first = true;

    sb.append("sensors:");
    sb.append(this.sensors);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class THeartBeatRequestStandardSchemeFactory implements SchemeFactory {
    public THeartBeatRequestStandardScheme getScheme() {
      return new THeartBeatRequestStandardScheme();
    }
  }

  private static class THeartBeatRequestStandardScheme extends StandardScheme<THeartBeatRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, THeartBeatRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SENSORS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sensors = iprot.readI32();
              struct.setSensorsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, THeartBeatRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SENSORS_FIELD_DESC);
      oprot.writeI32(struct.sensors);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class THeartBeatRequestTupleSchemeFactory implements SchemeFactory {
    public THeartBeatRequestTupleScheme getScheme() {
      return new THeartBeatRequestTupleScheme();
    }
  }

  private static class THeartBeatRequestTupleScheme extends TupleScheme<THeartBeatRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, THeartBeatRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSensors()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSensors()) {
        oprot.writeI32(struct.sensors);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, THeartBeatRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.sensors = iprot.readI32();
        struct.setSensorsIsSet(true);
      }
    }
  }

}

