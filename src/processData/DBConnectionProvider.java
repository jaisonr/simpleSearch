package processData;

import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection connection = null;
	private Logger log = Logger.getLogger(DBConnectionProvider.class);

	public DBConnectionProvider() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();

		log.info("Server Started ....");
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			DBConnectionProvider.connection = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			log.fatal("SQL Exception arised... Connection="+ connection.toString());
		} catch (NamingException e) {
			e.printStackTrace();
			log.fatal("Naming Exception arised... Connection="+ connection.toString());
		}
		if (DBConnectionProvider.connection == null) {
			System.out
					.println("Connection cannot be established... Server stoped...........!");
			String command = "D:\\program files\\apache-tomcat-6.0.37\\bin\\shutdown.bat";
			try {
				Process child = Runtime.getRuntime().exec(command);
				child.destroy();
			} catch (IOException e) {
				e.printStackTrace();
				log.fatal("Connection Establishment error.. Connection="
						+ connection.toString());
			}
		}

	}

	public static Connection getConnection() {
		return connection;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log.info("Server Stopped at...");
	}
}