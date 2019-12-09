package altp.DAO;


import java.util.List;

import entity.CauHoi;

public interface UserDao {
	List<CauHoi> select();
	void add(CauHoi user);
}