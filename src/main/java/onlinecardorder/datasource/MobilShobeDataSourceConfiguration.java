package onlinecardorder.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.vault.annotation.VaultPropertySource;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@VaultPropertySource("db/mobileshobe")
public class MobilShobeDataSourceConfiguration {

    @Value("${datasource.mobileshobe.user}")
    private String datasourceUser;
    @Value("${datasource.mobileshobe.password}")
    private String datasourcePassword;
    @Value("${datasource.mobileshobe.host}")
    private String datasourceHost;
    @Value("${datasource.mobileshobe.driver}")
    private String datasourceDriver;
    @Value("${datasource.mobileshobe.dialect}")
    private String datasourceDialect;

    @Bean
    public DataSource dataSource() {
        System.err.println("user p: " + datasourceUser);
        System.err.println("pass: " + datasourcePassword);
        System.err.println("host: " + datasourceHost);

        return DataSourceBuilder.create()
                .username(datasourceUser)
                .password(datasourcePassword)
                .url("jdbc:postgresql://192.168.211.56:5432/mobil_shobe")
                .driverClassName(datasourceDriver)
                .build();
    }

    @Bean
    public HashMap<String, Object> jpaProperties() {
        HashMap<String, Object> jpaPropertiesMap = new HashMap<String, Object>();
        jpaPropertiesMap.put("hibernate.dialect", datasourceDialect);
        jpaPropertiesMap.put("spring.jpa.show-sql", "true");
        jpaPropertiesMap.put("hibernate.show_sql", "true");
        jpaPropertiesMap.put("hibernate.format_sql", "true");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        jpaPropertiesMap.put("hibernate.enable_lazy_load_no_trans", "true");
        return jpaPropertiesMap;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setJpaPropertyMap(jpaProperties());
        em.setPackagesToScan("az.bankrespublika.mobileshobe.cardstorage.entity.mobilshobe");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}

