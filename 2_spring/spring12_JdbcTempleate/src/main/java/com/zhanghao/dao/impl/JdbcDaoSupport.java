package com.zhanghao.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * 抽取dao中重复代码
 */
public class JdbcDaoSupport {
    private JdbcTemplate template;
    private DataSource dataSource;


    public JdbcDaoSupport() {
    }

    public JdbcDaoSupport(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        if (template==null){
            createTemplate(dataSource);
        }
    }

    private void createTemplate(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }
}
