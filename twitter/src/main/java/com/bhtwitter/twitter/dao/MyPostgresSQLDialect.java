package com.bhtwitter.twitter.dao;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

@SuppressWarnings("deprecation")
public class MyPostgresSQLDialect extends PostgreSQLDialect {
	 public MyPostgresSQLDialect() {
		    super();

		    this.registerFunction( "array_any", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,"ANY(?1)") );
		    this.registerFunction( "array_array", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,"array[?1]") );

		  }
		}


