package edu.gdou.pensionlens.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DoubleSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            // 将 double 转换为字符串，并保留足够的小数位数
            gen.writeString(String.format("%.15f", value));
        } else {
            gen.writeNull();
        }
    }
}
