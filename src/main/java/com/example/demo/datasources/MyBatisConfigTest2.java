package com.example.demo.datasources;


import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.test2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class MyBatisConfigTest2 {


    @Bean(name = "test2DataSource")
    public DataSource test2DataSource(DBConfigTest2 dbConfigTest2) throws SQLException {
//        DruidXADataSource druidXADataSource=new DruidXADataSource();
//        druidXADataSource.setDriverClassName(dbConfig.getDriverClassName());
//        druidXADataSource.setUrl(dbConfig.getUrl());
//        druidXADataSource.setPassword(dbConfig.getPassword());
//        druidXADataSource.setUsername(dbConfig.getUsername());
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfigTest2.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfigTest2.getPassword());
        mysqlXaDataSource.setUser(dbConfigTest2.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test2DataSource");
        xaDataSource.setMinPoolSize(dbConfigTest2.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfigTest2.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfigTest2.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfigTest2.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfigTest2.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfigTest2.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfigTest2.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfigTest2.getValidationQuery());
        return xaDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
