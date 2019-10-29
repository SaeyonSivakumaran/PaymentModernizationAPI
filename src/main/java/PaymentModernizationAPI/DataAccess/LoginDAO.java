package PaymentModernizationAPI.DataAccess;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAO for login
 */
@Repository
public class LoginDAO {

    private Statement statement;

    /**
     * Constructor for LoginDAO
     * @throws SQLException SQL error when creating LoginDAO
     */
    public LoginDAO() throws SQLException {
        statement = DAOManager.getStatement();
    }

    /**
     * Returns data for a specific username and password
     * @param username Username
     * @param password Password
     * @return Info from table for the username and password
     * @throws SQLException Error when retrieving details
     */
    public ResultSet getAuthDetails(String username, String password) throws SQLException{
        String infoQuery = String.format("SELECT auth_token FROM heroku_b8a1f59b8d70fd1.users WHERE user_name='%s' " +
                "AND password='%s'", username, password);
        return statement.executeQuery(infoQuery);
    }

}
