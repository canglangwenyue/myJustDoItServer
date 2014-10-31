package wenyue.justdoit.Dao;

import wenyue.justdoit.Entity.user;

public interface userDao {

	public int add(user u);

	public boolean checkUserExistsWithName(String uname);

	public boolean getUserData(String uname, String password);

}
