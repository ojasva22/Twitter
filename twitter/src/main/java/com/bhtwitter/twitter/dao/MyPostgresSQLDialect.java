package com.bhtwitter.twitter.dao;


import org.hibernate.dialect.PostgreSQL82Dialect;

import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;


public class MyPostgresSQLDialect extends PostgreSQL82Dialect {
	 public MyPostgresSQLDialect() {
		    super();

		    this.registerFunction( "array_any", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,"ANY(?1)") );
		    this.registerFunction( "array_array", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,"array[?1]") );

		  }
		}


