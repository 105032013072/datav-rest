 package com.bosssoft.platform.datav.constant;

 public class BasicConstant {
     public static final String DEFAULT_OPERATOR = "system";
     
     /**
      * 所支持的数据源类型的配置文件路径
      */
     public static final String DATASOURCE_SUPPORTED_FILEPATH = "dataSource/dataSource_supported.xml";
     

     /**
      * 数据源获取连接出错时的自动重连次数
      */
     public static final int DATASOURCE_CONNECTIONERROR_RETRYS = 10;

     /**
      * 数据源设置获取连接时的重试次数，-1为不重试
      */
     public static final int DATASOURCE_TIMEOUT_RETRYS = 10;
    
     public static final String DB_TYPE_MYSQL = "mysql";

     public static final String DB_TYPE_ORACLE = "oracle";

     public static final String DB_TYPE_SQLSERVER = "microsoft sql server";

     public static final String DB_TYPE_POSTGRESQL = "postgres";

     /**
      * 编码格式_UTF-8
      */
     public static final String ENCODING_UTF8 = "utf-8";
     

}
