package com.water.db.dao.impl;

import com.water.db.dao.IUserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by mrwater on 16/6/4.
 */
@Repository(IUserDao.SERVICE_NAME)
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {
}
