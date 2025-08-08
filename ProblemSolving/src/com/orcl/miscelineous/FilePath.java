package com.orcl.miscelineous;

import java.util.LinkedList;

public class FilePath {
    public static void main(String[] args) {
        FilePath filePath = new FilePath();
        System.out.println(filePath.simplifyPath("/../"));

    }

    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        LinkedList<String> modified = new LinkedList<>();
        modified.add("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..") && modified.size() > 1) {
                modified.removeLast();
            } else if (arr[i].equals(".") || arr[i].length() == 0) {
                continue;
            } else {
                modified.add(arr[i] + "/");
            }

        }
        if (modified.size() == 0) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < modified.size(); i++) {
                if(!modified.get(i).equals("..")){
                    sb.append(modified.get(i));
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
}
