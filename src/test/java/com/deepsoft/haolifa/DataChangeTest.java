package com.deepsoft.haolifa;

import com.deepsoft.haolifa.model.domain.SysUser;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * 数据修改的sql
 *
 * @author murphy.he
 **/
public class DataChangeTest  {

    /**
     * 图号修改
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("d://1.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d://2.sql")));
        String line = null;
        while (null != (line = br.readLine())) {
            String[] split = line.split(",");
            String oldGraphNo = split[0];
            String newGraphNo = split[1];

            bw.write("update apply_buy set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update check_material_log set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update entry_out_store_record set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update inspect_history set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update inspect_item set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update material_inspect_result set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update order_material set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update price_material set graph_no='" + newGraphNo + "' where graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update product_material set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update purchase_order_item set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update replace_material set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update spray_inspect_history set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update spray_item set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update stock set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update supplier_product set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update spray_inspect_history set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update entrust_graph_no_relation set original_graph_no='" + newGraphNo + "' where original_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update entrust_graph_no_relation set processed_graph_no='" + newGraphNo + "' where processed_graph_no='" + oldGraphNo + "';\r\n");
            bw.write("update reject_material_record set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';\r\n");


            bw.flush();
        }
        br.close();
        bw.close();

    }

    @Test
    public void graphNoChange() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("d://1.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d://2.sql")));
        String line = null;
        if (null == (line = br.readLine())) {
            String[] split = line.split(",");
            String oldGraphNo = split[0];
            String newGraphNo = split[1];

            bw.write("update apply_buy set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';/r/n");
            bw.write("update check_material_log set material_graph_no='" + newGraphNo + "' where material_graph_no='" + oldGraphNo + "';/r/n");


            bw.flush();
        }
        br.close();
        bw.close();


    }
}
