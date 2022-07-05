package com.djhu.imp.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.djhu.imp.utils.WordExport;
import lombok.Data;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zw
 * @DATE 2019/8/7 17:24
 * @VERSION 1.0.0
 **/
@Service
public class SaveTemplateServiceImpl {


    @Autowired
    private WordExport wordExport;

    private String file = "config/jdbc.json";

    public Map<String,DataSource> dataSourceMap = new HashMap<String,DataSource>();

    public List<TableInfo> tableEntities = new ArrayList<TableInfo>();

    @Data
    public class TableInfo{
        private String tablename;
        private String remark;
        private String dataSourceId;
    }


    @Data
    public class TableEntity{
        private String column_name = "";
        private String data_type = "";
        private String data_length = "";
        private String nullAble = "true";
        private String comments = "";
    }




    public void init(){
        try {
            String databasesString = IOUtils.toString(new FileInputStream(file), "UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(databasesString);
            JSONArray jsonArray = jsonObject.getJSONArray("datasources");
            for (int i = 0;i<jsonArray.size();i++){
                JSONObject jsObject = jsonArray.getJSONObject(i);
                Map.Entry entry = getDataSourceEntry(jsObject);
                dataSourceMap.put(String.valueOf(entry.getKey()),(DataSource) entry.getValue());
            }

            JSONArray tableArray = jsonObject.getJSONArray("tables");
            for (int i = 0;i<tableArray.size();i++){
                JSONObject object = tableArray.getJSONObject(i);
                String tableName = object.getString("tablename").toUpperCase();
                String remark = object.getString("remark");
                String datasourceId = object.getString("datasource_id");
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTablename(tableName);
                tableInfo.setDataSourceId(datasourceId);
                tableInfo.setRemark(remark);
                tableEntities.add(tableInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Map.Entry getDataSourceEntry(JSONObject jsObject) {
        String key = jsObject.getString("key");
        String url = jsObject.getString("url");
        String driverclass = jsObject.getString("driverclass");
        String username = jsObject.getString("username");
        String password = jsObject.getString("password");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverclass);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DefaultMapEntry entry = new DefaultMapEntry(key,dataSource);
        return entry;

    }

    public void importData(){
        init();
        Map<TableInfo,List<TableEntity>> map = new HashMap<>();
        for (TableInfo tableInfo:tableEntities){
            List<TableEntity> list = getTableEntity(tableInfo);
            System.out.println(JSONArray.fromObject(list).toString()  + "---------" + JSONArray.fromObject(tableEntities).toString());
            map.put(tableInfo,list);
        }
        //导出word文档  调用工具类
        wordExport.export(map);
    }

    private  List<TableEntity> getTableEntity(TableInfo tableInfo) {
        String tableName = tableInfo.getTablename();
        DataSource dataSource = dataSourceMap.get(tableInfo.dataSourceId);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        StringBuffer sqlformat = new StringBuffer();
        sqlformat.append("SELECT t1.Column_Name ,").append(" t1.DATA_TYPE ,t1.DATA_LENGTH ,t1.NullAble ,t2.Comments ");
        sqlformat.append("  FROM cols t1");
        sqlformat.append("  LEFT JOIN user_col_comments t2  ON t1.Table_name = t2.Table_name   AND t1.Column_Name = t2.Column_Name");
        sqlformat.append("  LEFT JOIN user_tab_comments t3    ON t1.Table_name = t3.Table_name");
        sqlformat.append("  LEFT JOIN user_objects t4   ON t1.table_name = t4.OBJECT_NAME");
        sqlformat.append(" WHERE");
        sqlformat.append(" NOT EXISTS (SELECT t4.Object_Name FROM User_objects t4   WHERE t4.Object_Type = 'TABLE' AND t4.Temporary = 'Y'  AND t4.Object_Name = t1.Table_Name )  ");
        sqlformat.append("  and t1.Table_Name = '%s'");
        sqlformat.append("  ORDER BY t1.Table_Name, t1.Column_ID");
        String sql = String.format(sqlformat.toString(),tableName);
        List<TableEntity> tableEntities = new ArrayList<TableEntity>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map:list){
            TableEntity tableEntity = new TableEntity();
            String columnName = String.valueOf(map.get("column_name")).toUpperCase();
            String dataType  = String.valueOf(map.get("DATA_TYPE"));
            String length  = String.valueOf(map.get("DATA_length"));
            String isNull= String.valueOf(map.get("NULLABLE"));
            String comments= String.valueOf(map.get("Comments"));
            tableEntity.setColumn_name(columnName);
            tableEntity.setData_type(dataType);
            tableEntity.setData_length(length);
            tableEntity.setNullAble(isNull);
            tableEntity.setComments(comments);
            tableEntities.add(tableEntity);
        }
        return tableEntities;

    }
}
