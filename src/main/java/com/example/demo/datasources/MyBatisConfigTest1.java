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
@MapperScan(basePackages = "com.example.demo.mapper.test1", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class MyBatisConfigTest1 {


    @Bean(name = "test1DataSource")
    @Primary
    public DataSource test1DataSource(DBConfigTest1 dbConfigTest1) throws SQLException {
//        DruidXADataSource druidXADataSource=new DruidXADataSource();
//        druidXADataSource.setDriverClassName(dbConfig.getDriverClassName());
//        druidXADataSource.setUrl(dbConfig.getUrl());
//        druidXADataSource.setPassword(dbConfig.getPassword());
//        druidXADataSource.setUsername(dbConfig.getUsername());
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfigTest1.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfigTest1.getPassword());
        mysqlXaDataSource.setUser(dbConfigTest1.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test1DataSource");
        xaDataSource.setMinPoolSize(dbConfigTest1.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfigTest1.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfigTest1.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfigTest1.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfigTest1.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfigTest1.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfigTest1.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfigTest1.getValidationQuery());
        return xaDataSource;
    }

    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate test1SqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
