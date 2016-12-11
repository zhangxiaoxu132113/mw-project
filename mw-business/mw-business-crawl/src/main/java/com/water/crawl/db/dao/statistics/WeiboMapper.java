package com.water.crawl.db.dao.statistics;

import java.util.List;
import com.water.crawl.db.dao.statistics.extend.WeiboMapperExtend;
import com.water.crawl.model.Weibo;
import com.water.crawl.model.WeiboCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WeiboMapper extends WeiboMapperExtend {
    int countByExample(WeiboCriteria example);

    int deleteByExample(WeiboCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    List<Weibo> selectByExampleWithRowbounds(WeiboCriteria example, RowBounds rowBounds);

    List<Weibo> selectByExample(WeiboCriteria example);

    Weibo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Weibo record, @Param("example") WeiboCriteria example);

    int updateByExample(@Param("record") Weibo record, @Param("example") WeiboCriteria example);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);

    int insertBatch(List<Weibo> list);
}