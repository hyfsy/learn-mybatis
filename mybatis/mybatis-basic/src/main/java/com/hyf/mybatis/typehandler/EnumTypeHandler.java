package com.hyf.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举类型处理器
 */
//@MappedTypes(UserStatusEnum.class)
public class EnumTypeHandler implements TypeHandler<UserStatusEnum> {

    /**
     * 设置存入数据库的参数
     *
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, UserStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    /**
     * 设置从数据库中获取的参数
     *
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public UserStatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return UserStatusEnum.getUserStatusEnum(code);
    }

    @Override
    public UserStatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return UserStatusEnum.getUserStatusEnum(code);
    }

    @Override
    public UserStatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return UserStatusEnum.getUserStatusEnum(code);
    }
}
