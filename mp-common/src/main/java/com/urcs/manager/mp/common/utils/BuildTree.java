package com.urcs.manager.mp.common.utils;

import com.urcs.manager.mp.common.domain.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {

    public static <T> Tree<T> build(List<Tree<T>> nodes) {

        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();
        //如果当前登陆用户不是超级管理，则不展示系统管理菜单模块

//        if (ShiroUtils.getUser().getRoleIds().get(0) != 1L) {
        if (!ShiroUtils.getUser().isSystem()) {

            for (Tree<T> children : nodes) {
                //TODO 判断是不是系统管理目录不合适用id，姑且先这么用吧。
                String pid = children.getParentId();
                String cid = children.getId();
                if (pid == null || "0".equals(pid)) {
                    //忽略系统管理菜单
                    if (!"3".equals(cid)) {
                        topNodes.add(children);
                    }
                    continue;
                }
                //忽略系统管理目录的子级菜单
                if ("3".equals(pid)) {
                    continue;
                }
                for (Tree<T> parent : nodes) {
                    String id = parent.getId();
                    //当前菜单是系统管理，则直接跳过

                    if (id != null && id.equals(pid)) {
                        parent.getChildren().add(children);
                        children.setHasParent(true);
                        parent.setChildren(true);
                        continue;
                    }
                }
            }
        } else {
            for (Tree<T> children : nodes) {

                String pid = children.getParentId();
                if (pid == null || "0".equals(pid)) {
                    topNodes.add(children);
                    continue;
                }
                for (Tree<T> parent : nodes) {
                    String id = parent.getId();
                    if (id != null && id.equals(pid)) {
                        parent.getChildren().add(children);
                        children.setHasParent(true);
                        parent.setChildren(true);
                        continue;
                    }
                }
            }
        }


        Tree<T> root = new Tree<T>();
        if (topNodes.size() == 1) {
            root = topNodes.get(0);
        } else {
            root.setId("-1");
            root.setParentId("");
            root.setHasParent(false);
            root.setChildren(true);
            root.setChecked(true);
            root.setChildren(topNodes);
            root.setText("顶级节点");
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            root.setState(state);
        }

        return root;
    }

    public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

        for (Tree<T> children : nodes) {

            String pid = children.getParentId();
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);

                continue;
            }

            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setChildren(true);

                    continue;
                }
            }

        }
        return topNodes;
    }

}