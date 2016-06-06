package com.water.db.dao.impl;

import com.water.db.dao.IBaseDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/5/31.
 */
public class BaseDaoImpl implements IBaseDao {

    @Resource(name="jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    /**
     * 查询对象
     * @date  2016-05-31
     * @param sql
     */
    public Map<String, Object> queryForMap(String sql) {
        return jdbcTemplate.queryForMap(sql);
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     * @param elementType
     */
    public <T> List<T> queryForList(String sql, Class<T> elementType) {
        return jdbcTemplate.queryForList(sql,elementType);
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     */
    public List<Map<String, Object>> queryForList(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    public List<Map<String, Object>> queryForList(String sql, Object... args) {
        return jdbcTemplate.queryForList(sql,args);
    }

    /**
     * 删除数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    public void deleteData(String sql, Object... args) {
        jdbcTemplate.update(sql,args);
    }

    /**
     * 更新数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    public void updateData(String sql, Object... args) {
        jdbcTemplate.update(sql,args);
    }

    /**
     * 插入数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    public int insertData(String sql, Object... args) {
        return jdbcTemplate.update(sql,args);
    }
}
