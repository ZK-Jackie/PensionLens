package edu.gdou.pensionlens.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@MappedTypes(List.class)
public class StringListTypeHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < parameter.size(); j++) {
            if (j > 0) {
                sb.append(",");
            }
            sb.append(parameter.get(j));
        }
        ps.setString(i, sb.toString());
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToList(value);
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToList(value);
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToList(value);
    }

    private List<String> convertToList(String value) {
        if (value == null || value.trim().isEmpty()) {
            return new ArrayList<>();
        }
        // 假设值是以逗号或空格分隔的
        return Arrays.stream(value.split("[,\\s]+"))
                     .filter(s -> !s.isEmpty())
                     .collect(Collectors.toList());
    }
}
