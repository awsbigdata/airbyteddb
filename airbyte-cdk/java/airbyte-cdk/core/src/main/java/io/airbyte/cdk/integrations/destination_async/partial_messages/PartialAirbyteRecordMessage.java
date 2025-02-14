/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.cdk.integrations.destination_async.partial_messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.JsonNode;
import io.airbyte.protocol.models.v0.AirbyteRecordMessageMeta;
import io.airbyte.protocol.models.v0.StreamDescriptor;
import java.util.Objects;

// TODO: (ryankfu) remove this and test with low memory resources to ensure OOM is still not a
// factor, shouldn't be
// but weird things have happened
public class PartialAirbyteRecordMessage {

  @JsonProperty("namespace")
  private String namespace;
  @JsonProperty("stream")
  private String stream;

  @JsonProperty("data")
  private JsonNode data;

  @JsonProperty("emitted_at")
  @JsonPropertyDescription("when the data was emitted from the source. epoch in millisecond.")
  private long emittedAt;

  @JsonProperty("meta")
  private AirbyteRecordMessageMeta meta;

  public PartialAirbyteRecordMessage() {}

  @JsonProperty("namespace")
  public String getNamespace() {
    return namespace;
  }

  @JsonProperty("namespace")
  public void setNamespace(final String namespace) {
    this.namespace = namespace;
  }

  public PartialAirbyteRecordMessage withNamespace(final String namespace) {
    this.namespace = namespace;
    return this;
  }

  @JsonProperty("stream")
  public String getStream() {
    return stream;
  }

  @JsonProperty("stream")
  public void setStream(final String stream) {
    this.stream = stream;
  }

  public PartialAirbyteRecordMessage withStream(final String stream) {
    this.stream = stream;
    return this;
  }

  @JsonProperty("data")
  public JsonNode getData() {
    return data;
  }

  @JsonProperty("data")
  public void setData(final JsonNode data) {
    this.data = data;
  }

  public PartialAirbyteRecordMessage withData(final JsonNode data) {
    this.data = data;
    return this;
  }

  @JsonProperty("emitted_at")
  public Long getEmittedAt() {
    return this.emittedAt;
  }

  @JsonProperty("emitted_at")
  public void setEmittedAt(final long emittedAt) {
    this.emittedAt = emittedAt;
  }

  public PartialAirbyteRecordMessage withEmittedAt(final Long emittedAt) {
    this.emittedAt = emittedAt;
    return this;
  }

  public AirbyteRecordMessageMeta getMeta() {
    return meta;
  }

  public void setMeta(AirbyteRecordMessageMeta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final PartialAirbyteRecordMessage that = (PartialAirbyteRecordMessage) o;
    return Objects.equals(namespace, that.namespace)
        && Objects.equals(stream, that.stream)
        && Objects.equals(emittedAt, that.emittedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, stream, emittedAt);
  }

  @Override
  public String toString() {
    return "PartialAirbyteRecordMessage{" +
        "namespace='" + namespace + '\'' +
        ", stream='" + stream + '\'' +
        ", emittedAt='" + emittedAt + '\'' +
        '}';
  }

  public StreamDescriptor getStreamDescriptor() {
    return new StreamDescriptor().withName(stream).withNamespace(namespace);
  }

}
