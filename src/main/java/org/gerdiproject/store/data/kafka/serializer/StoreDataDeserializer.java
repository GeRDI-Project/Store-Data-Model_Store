/**
 * Copyright 2018 Nelson Tavares de Sousa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
