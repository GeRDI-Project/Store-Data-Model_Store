package org.gerdiproject.store.data.kafka.serializer;

import org.apache.kafka.common.serialization.ByteBufferSerializer;
import org.apache.kafka.common.serialization.Serializer;
import org.gerdiproject.store.data.model.StoreDataModel;

import java.io.IOException;
import java.util.Map;

public class StoreDataSerializer  implements Serializer<StoreDataModel> {

    private final ByteBufferSerializer bbDeserializer = new ByteBufferSerializer();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Nothing to do
    }

    @Override
    public byte[] serialize(String topic, StoreDataModel data) {
        try {
            return bbDeserializer.serialize(topic, data.toByteBuffer());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {
        // Nothing to do
    }
}