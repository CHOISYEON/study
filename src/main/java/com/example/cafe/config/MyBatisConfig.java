package com.example.cafe.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(
        basePackages={
        		"com.example.cafe.infra"
        },
        sqlSessionFactoryRef = "defaultSqlSessionFactory"
)
public class MyBatisConfig {
    @Autowired
    ApplicationContext applicationContext;

    @Primary
    @Bean(name="defaultSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory (@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis-mapper/**/*.xml"));
//        sqlSessionFactoryBean.setTypeAliasesPackage(TypeAliasesPackage.getInstance().getTypeAliasesPackage());
//        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis-config.xml");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(null);
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name="defaultSqlSessionTemplate")
    public SqlSessionTemplate sqlSession (@Qualifier("defaultSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
