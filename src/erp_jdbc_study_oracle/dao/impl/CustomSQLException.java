package erp_jdbc_study_oracle.dao.impl;

@SuppressWarnings("serial")
public class CustomSQLException extends RuntimeException {

    public CustomSQLException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public CustomSQLException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
