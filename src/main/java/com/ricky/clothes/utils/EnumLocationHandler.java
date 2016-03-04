package com.ricky.clothes.utils;

import com.ricky.clothes.constant.EnumLocation;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by caiqing on 16/3/4.
 */
public class EnumLocationHandler extends BaseTypeHandler<EnumLocation>{
    private Class<EnumLocation> location;
    private final EnumLocation[] enums;

    public EnumLocationHandler(Class<EnumLocation> location) {
        if (location == null)
            throw  new IllegalArgumentException("location argument cannot be null");
        this.location = location;
        this.enums = location.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(location.getSimpleName() + " does not represent an enum type.");
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumLocation parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public EnumLocation getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnumLocation(i);
        }
    }

    @Override
    public EnumLocation getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnumLocation(i);
        }

    }

    @Override
    public EnumLocation getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return locateEnumLocation(i);
        }
    }

    private EnumLocation locateEnumLocation(int code) {
        for(EnumLocation location : enums) {
            if (location.getCode().equals(Integer.valueOf(code))) {
                return location;
            }
        }
        throw new IllegalArgumentException("未知枚举类型: " + code + "请核对" + location.getSimpleName());
    }

}
