package com.water.crawl.db.service.impl.statistics;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.water.crawl.db.dao.statistics.WeiboMapper;
import com.water.crawl.db.service.interfaces.statistics.WeiboService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

@Service("weiboService")
public class WeiboServiceImpl implements WeiboService {
    @Resource
    private WeiboMapper weiboMapper;
}