package com.spring.gmta.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.spring.gmta.mvc.repository") // mybatis 에서 지정해주는 repository를 지정해 줍니다.
public class MybatisConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //mybatis/sql 디렉토리 안에있는 모든 xml 파일을 지정해줍니다.
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/sql/*.xml"));
        SqlSessionFactory factory = factoryBean.getObject();
        factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
