package erp_jdbc_study_oracle.ds;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class OracleDataSourceTest {
	protected Logger logger = LogManager.getLogger();

	@Test
	public void testGetConnection() {
		try (Connection con = OracleDataSource.getConnection();){
			logger.debug(con);

	        Assert.assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
