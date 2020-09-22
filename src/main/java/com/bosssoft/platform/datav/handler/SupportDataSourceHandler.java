 package com.bosssoft.platform.datav.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.platform.datav.constant.BasicConstant;
import com.bosssoft.platform.datav.model.DataSourceElement;
import com.bosssoft.platform.datav.model.SupportDataSourceModel;
import com.bosssoft.platform.datav.util.DatavUtil;
import com.thoughtworks.xstream.XStream;

public class SupportDataSourceHandler {
     private static Logger log = LoggerFactory.getLogger(SupportDataSourceHandler.class);

     private static Map<String, String> dataSourceURLTemplates;

     static {
         dataSourceURLTemplates = new HashMap<>();
         dataSourceURLTemplates.put(BasicConstant.DB_TYPE_MYSQL,
             "jdbc:mysql://{0}:{1}/{2}?useUnicode=true&amp;characterEncoding=utf8");
         dataSourceURLTemplates.put(BasicConstant.DB_TYPE_ORACLE, "jdbc:oracle:thin:@{0}:{1}:{2}");
         dataSourceURLTemplates.put(BasicConstant.DB_TYPE_SQLSERVER,
             "jdbc:microsoft:sqlserver://{0}:{1};DatabaseName={2}");
         dataSourceURLTemplates.put(BasicConstant.DB_TYPE_POSTGRESQL, "jdbc:postgresql://{0}:{1}/{2}");
     }

     public static Map<String, DataSourceElement> getSupportDataSources() {
         return Singleton.INSTANCE.getSupportDataSources();
     }

     public static DataSourceElement getSupportDataSourceByMateKey(String dataSourceMateKey) {
         return getSupportDataSources().get(dataSourceMateKey);
     }

     private static enum Singleton {
         INSTANCE;

         private Map<String, DataSourceElement> supportDataSources = new HashMap<String, DataSourceElement>();

         private Singleton() {
             // 加载dataSource_supported.xml
             log.info("加载dataSource_supported.xml");
             XStream xstream = new XStream();
             xstream.processAnnotations(SupportDataSourceModel.class);
             xstream.autodetectAnnotations(true);
             SupportDataSourceModel supportDataSourceModel =
                 (SupportDataSourceModel)xstream.fromXML(readSupportDataSourceXmlToStr());

             initSupportDataSources(supportDataSourceModel);
         }

         private void initSupportDataSources(SupportDataSourceModel supportDataSourceModel) {
             if (supportDataSourceModel != null) {
                 for (DataSourceElement dataSourceMate : supportDataSourceModel.getSupportDataSources()) {
                     String mateKey = getDataSourceMateKey(dataSourceMate);
                     dataSourceMate.setKey(mateKey);
                     if (StringUtils.isEmpty(dataSourceMate.getUrlTemplate())) {
                         dataSourceMate
                             .setUrlTemplate(dataSourceURLTemplates.get(dataSourceMate.getType().toLowerCase()));
                     }

                     supportDataSources.put(mateKey, dataSourceMate);
                 }
             }

         }

         private String getDataSourceMateKey(DataSourceElement dataSourceMate) {
             StringBuffer buffer = new StringBuffer();
             buffer.append(dataSourceMate.getType());
             buffer.append("_");
             buffer.append(dataSourceMate.getVersion());
             return buffer.toString();
         }

         /**
          * 将dataSource_supported.xml 读取为字符串
          * 
          * @return
          */
         private String readSupportDataSourceXmlToStr() { 
             return DatavUtil.readClassPathFileToStr(BasicConstant.DATASOURCE_SUPPORTED_FILEPATH);

         }

         public Map<String, DataSourceElement> getSupportDataSources() {
             return supportDataSources;
         }
     }
}
