package pers.zequs.springboot.starter.demo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import pers.zequs.springboot.starter.demo.dao.ZequsDao;
import pers.zequs.springboot.starter.demo.properties.DBProperties;

/**
 * @author zequs
 * @version $Id: starter, v0.1 2019 08 20 Exp $
 */
@EnableConfigurationProperties(DBProperties.class)
@Import(ZequsDao.class)
public class ZequsDaoAutoConfiguration {
}
