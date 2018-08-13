package org.gerdiproject.store.data.kafka.serializer;

import org.apache.kafka.common.serialization.ByteBufferDeserializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.gerdiproject.store.data.model.StoreDataModel;

import java.io.IOException;
import java.util.Map;

public class StoreDataDeserializer implements Deserializer<StoreDataModel> {

    private final ByteBufferDeserializer bbSerializer = new ByteBufferDeserializer();

    @Override
    public void configure(Map<String, ?> map, boolean b) {
        // Nothing to do
    }

    @Override
    public StoreDataModel deserialize(String topic, byte[] bytes) {
        try {
            return StoreDataModel.fromByteBuffer(bbSerializer.deserialize(topic, bytes));
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
