package com.deepsoft.haolifa.util;

import com.alibaba.fastjson.JSONArray;
import com.deepsoft.haolifa.model.dto.BaseTreeGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: TreeUtils
 * @description: 数形工具类
 * @author: hedong@ibeesaas.com
 * @date: 2019-01-04 16:28
 **/
public class TreeUtils {


    /**
     * 格式化list为树形list
     *
     * @param list
     * @param falg true 表示全部展开，其他 表示不展开
     * @return
     */
    public static <T  extends BaseTreeGrid> List<T> formatTree(List<T> list, Boolean flag) {

        List<T> nodeList = new ArrayList<T>();
        for (T node1 : list) {
            boolean mark = false;
            for (T node2 : list) {
                if (node1.getPid() != null && node1.getPid().equals(node2.getId())) {
                    node2.setLeaf(false);
                    mark = true;
                    if (node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<BaseTreeGrid>());
                    }
                    node2.getChildren().add(node1);
                    if (flag) {
                        //默认已经全部展开
                    } else {
                        node2.setExpanded(false);
                    }
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
                if (flag) {
                    //默认已经全部展开
                } else {
                    node1.setExpanded(false);
                }
            }
        }
        return nodeList;
    }

    public static void main(String[] args) {
        List<BaseTreeGrid> list = new ArrayList<BaseTreeGrid>();
        BaseTreeGrid root1 = new BaseTreeGrid();
        root1.setId(1);
        BaseTreeGrid child1 = new BaseTreeGrid();
        child1.setId(11);
        child1.setPid(1);
        BaseTreeGrid child11 = new BaseTreeGrid();
        child11.setId(111);
        child11.setPid(11);
        BaseTreeGrid root2 = new BaseTreeGrid();
        root2.setId(2);
        BaseTreeGrid child2 = new BaseTreeGrid();
        child2.setId(21);
        child2.setPid(2);
        list.add(root1);
        list.add(child1);
        list.add(child11);
        list.add(root2);
        list.add(child2);
        List<BaseTreeGrid> treelist = formatTree(list, false);
        String json = JSONArray.toJSONString(treelist);
        System.out.println(json);
    }


}
