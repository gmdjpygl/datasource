package com.baseAdmin.dataSource;

import org.apache.ibatis.session.Configuration;

public class MybatisPropertiesCustom {
   String typeAliasesPackage;
    private Configuration configuration;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
