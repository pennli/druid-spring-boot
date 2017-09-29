package com.github.trang.druid.actuate;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * 将 Druid 的信息暴露出来
 *
 * @author trang
 */
@ConfigurationProperties(prefix = "endpoints.druid")
public class DruidDataSourceEndpoint extends AbstractEndpoint<List<Map<String, Object>>> {

    public DruidDataSourceEndpoint() {
        super("druid");
    }

    private static final DruidStatManagerFacade statManager = DruidStatManagerFacade.getInstance();

    @Override
    public List<Map<String, Object>> invoke() {
        return statManager.getDataSourceStatDataList();
    }

}