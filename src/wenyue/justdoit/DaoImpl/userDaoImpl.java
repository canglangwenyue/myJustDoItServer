package wenyue.justdoit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import wenyue.justdoit.Dao.userDao;
import wenyue.justdoit.Entity.user;
import wenyue.justdoit.util.MySQLHelper;

public class userDaoImpl implements userDao {

	MySQLHelper helper = new MySQLHelper();
	Connection connection = helper.getConnection();
	PreparedStatement preStatement;

	public int add(user u) {
		int status = 0;
		String insertSql = "insert into user (username,userpassword)values(?,?)";
		try {
			preStatement = connection.prepareStatement(insertSql);
			preStatement.setString(1, u.getUsername());
			preStatement.setString(2, u.getUserpassword());
			if (preStatement.executeUpdate() != 0) {
				System.out.println("用户注册成功");
				status = 1;
			} else {
				System.out.println("用户注册失败");
			}
			helper.closeConnecrion(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	public boolean checkUserExistsWithName(String uname) {
		int count = 0;
		String checkSql = "SELECT count(*) FROM JustDoIt.user WHERE username = "
				+ "'" + uname + "'";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(checkSql);
			resultSet.next();
			count = resultSet.getInt(1);
			System.out.println(String.valueOf(count));
			helper.closeConnecrion(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	public boolean getUserData(String uname, String password) {
		String serchSql = "select username,userpassword from user where username=? and userpassword=?";
		boolean bool = false;
		try {
			preStatement = connection.prepareStatement(serchSql);
			if (uname != null && password != null) {
				preStatement.setString(1, uname);
				preStatement.setString(2, password);
				ResultSet resultSet = preStatement.executeQuery();
				bool = resultSet.next();
				if (bool) {
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
