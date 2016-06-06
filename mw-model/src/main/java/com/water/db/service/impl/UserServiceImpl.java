package com.water.db.service.impl;

import com.water.db.dao.IUserDao;
import com.water.db.service.IUserService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
@Service(IUserService.SERVICE_NAME)
public class UserServiceImpl implements IUserService {
    @Resource(name = IUserDao.SERVICE_NAME)
    private IUserDao userDao;

    public Map<String, Object> findUserByNameAndPwd(String username, String pwd) {
        MWStringUtils.isBlank(username,pwd);

        String querySQL = "select * from mw_user u where u.account = ? and u.password = ?";
        List<Map<String,Object>> results = userDao.queryForList(querySQL,new Object[]{username,pwd});
        if (results != null && results.size() == 1) {
            return results.get(0);
        }
        return null;
    }
}
