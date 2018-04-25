package com.ty.shop.coustemor;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.ty.shop.entities.Address;


public class AddressTypeHandler extends BaseTypeHandler<Address> {
	
//-------------------------------设置参数为字符串保存到数据库中-----------------------------------------
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Address address, JdbcType jdbcType)
			throws SQLException {
		
		//1.对address对象进行验证
		if(address == null) {
			return ;
		}
		
		//2.从address对象中取出具体数据
		String province = address.getProvince();
		String city = address.getCity();
		String street = address.getStreet();
		
		//3.拼装成一个字符串
		//规则：各个值之间使用“,”分开
		StringBuilder builder = new StringBuilder();
		builder
			.append(province)
			.append(",")
			.append(city)
			.append(",")
			.append(street);
		
		String parameterValue = builder.toString();
		
		//4.设置参数
		ps.setString(i, parameterValue);
		
	}
//---------------------后三个为设置参数为从数据库中接收到的类型转换实体类中对应的类型------------------------
	@Override
	public Address getNullableResult(ResultSet rs, String columnName) throws SQLException {
		
		//1.根据字段名从rs对象中获取字段值
		String columnValue = rs.getString(columnName);
		
		//2.验证columnValue是否有效
		if(columnValue == null || columnValue.length() == 0 || !columnValue.contains(",")) {
			return null;
		}
		
		//3.根据“,”对columnValue进行拆分
		String[] split = columnValue.split(",");
		
		//4.从拆分结果数组中获取Address需要的具体数据
		String province = split[0];
		String city = split[1];
		String street = split[2];
		
		//5.根据具体对象组装一个Address对象
		Address address = new Address(province, city, street);
		
		return address;
	}

	@Override
	public Address getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		//1.根据字段名从rs对象中获取字段值
		String columnValue = rs.getString(columnIndex);
		
		//2.验证columnValue是否有效
		if(columnValue == null || columnValue.length() == 0 || !columnValue.contains(",")) {
			return null;
		}
		
		//3.根据“,”对columnValue进行拆分
		String[] split = columnValue.split(",");
		
		//4.从拆分结果数组中获取Address需要的具体数据
		String province = split[0];
		String city = split[1];
		String street = split[2];
		
		//5.根据具体对象组装一个Address对象
		Address address = new Address(province, city, street);
		
		return address;
	}

	@Override
	public Address getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		//1.根据字段名从rs对象中获取字段值
		String columnValue = cs.getString(columnIndex);
		
		//2.验证columnValue是否有效
		if(columnValue == null || columnValue.length() == 0 || !columnValue.contains(",")) {
			return null;
		}
		
		//3.根据“,”对columnValue进行拆分
		String[] split = columnValue.split(",");
		
		//4.从拆分结果数组中获取Address需要的具体数据
		String province = split[0];
		String city = split[1];
		String street = split[2];
		
		//5.根据具体对象组装一个Address对象
		Address address = new Address(province, city, street);
		return address;
	}
}
