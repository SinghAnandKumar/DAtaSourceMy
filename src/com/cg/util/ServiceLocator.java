package com.cg.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {
	
	static DataSource getDataSource() throws NamingException{
		
		Context context = new InitialContext();
		Context ctx = (Context) context.lookup("java:/comp/env");
		
		DataSource ds = (DataSource) ctx.lookup("jdbc/DSApp");
		
		return ds;
	}
}
