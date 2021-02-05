package com.example.basic.threadTest;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: YinJiaqi
 * Date: 9/21/2020 2:50 PM
 * Content:
 */
public class CompletionServiceTest2 {
    private static final int cpuCount = Runtime.getRuntime().availableProcessors();
    public static ExecutorService poolOne = Executors.newFixedThreadPool(10);
    public static ExecutorService poolTwo = Executors.newFixedThreadPool(10);
    public static CompletionService<List<VipOrderManagerSearchDTO>> serviceOne = new ExecutorCompletionService<>(poolOne);
    public static CompletionService<List<VipOrderManagerSearchDTO>> serviceTwo = new ExecutorCompletionService<>(poolTwo);


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder("select count(*) count from cycle_deduction_order");
        Integer count = 0;
        Integer num = 100;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sb.toString());
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int total = (count / num);
        System.out.println("查询线程数" + total);
        for (int i = 0; i < total; i++) {
            SumCount thread = new SumCount(connection, i * num,num);
            serviceOne.submit(thread);
        }
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("订单id");titles.add("订单号");titles.add("订单类型");titles.add("VIP产品名称");titles.add("作业大师号");
        titles.add("设备号");titles.add("支付方式");titles.add("订单金额");titles.add("订单状态");titles.add("订单完成时间");
        data.setTitles(titles);
        for (int i = 0;i<total;i++){
            try {
                Future<List<VipOrderManagerSearchDTO>> take = serviceOne.take();
                List<VipOrderManagerSearchDTO> list = take.get();
                System.out.println(list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("耗时："+(l2-l));

    }

    public static Connection getConnection() {
        String URL = "jdbc:mysql://172.17.13.3:9011/k12_homework?zeroDateTimeBehavior=convertToNull";
        String USER = "root";
        String PASSWORD = "Hangzhou@123";
        Connection conn = null;
        DataSource ds = null;
        try {
            BasicDataSource dbcpDataSource = new BasicDataSource();
            dbcpDataSource.setUrl(URL);
            dbcpDataSource.setUsername(USER);
            dbcpDataSource.setPassword(PASSWORD);
            dbcpDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dbcpDataSource.setMaxActive(5);
            ds = dbcpDataSource;
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    static class SumCount implements Callable<List<VipOrderManagerSearchDTO>> {
        private Connection con;
        private Integer i;
        private Integer num;

        public SumCount(Connection con, Integer i,Integer num) {
            this.con = con;
            this.i = i;
            this.num = num;
        }

        @Override
        public List<VipOrderManagerSearchDTO> call() throws Exception {
            ResultSet rs = null;
            Statement statement = null;
            List<VipOrderManagerSearchDTO> list = new ArrayList<>();
//            StringBuilder sb = new StringBuilder("select id,subject,pay_type,order_no from cycle_deduction_order \n" +
//                    "WHERE id>=(SELECT id FROM cycle_deduction_order ORDER BY id LIMIT "+i+", 1) LIMIT "+num+";");

            StringBuilder sb = new StringBuilder("select id,subject,pay_type,order_no from cycle_deduction_order");
            statement = con.createStatement();
            rs = statement.executeQuery(sb.toString());
            VipOrderManagerSearchDTO dto = null;
            while (rs.next()){
                dto = new VipOrderManagerSearchDTO();
                dto.setId(rs.getInt("id"));
                dto.setSubject(rs.getInt("subject"));
                dto.setPayType(rs.getInt("pay_type"));
                dto.setOrderNo(rs.getString("order_no"));
                list.add(dto);
            }
            return list ;
        }
    }

}
