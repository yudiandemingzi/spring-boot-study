package com.jincou.trim.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class StringJsonUtils {

    /**
     * json字符串首尾去空格
     *
     * @param jsonStr json字符串
     * @return 去掉首尾空格的json
     */
    public static JSONObject JsonStrTrim(String jsonStr) {

        JSONObject reagobj = JSONObject.parseObject(jsonStr);
        Set<String> keySet = reagobj.keySet();
        Iterator<String> itt = keySet.iterator();

        while (itt.hasNext()) {
            String key = itt.next();
            Object obj = reagobj.get(key);

            if (obj instanceof JSONObject) {
                Set<String> keySets = ((JSONObject) obj).keySet();
                Iterator<String> iterator = keySets.iterator();
                while (iterator.hasNext()) {
                    String key1 = iterator.next();
                    Object o = ((JSONObject) obj).get(key1);
                    if (o instanceof String) {
                        if (o == null) {
                            continue;
                        } else if ("".equals(o.toString().trim())) {
                            //空转null
                            ((JSONObject) obj).put(key1, null);
                            continue;
                        } else {
                            ((JSONObject) obj).put(key1, o.toString().trim());
                        }
                    }
                }
                reagobj.put(key, obj);
            } else if (obj instanceof JSONArray) {
                for (int i = 0; i < ((JSONArray) obj).size(); i++) {
                    Object o = ((JSONArray) obj).get(i);
                    if (o instanceof JSONObject) {
                        Set<String> keySets = ((JSONObject) o).keySet();
                        Iterator<String> iterator = keySets.iterator();
                        while (iterator.hasNext()) {
                            String key1 = iterator.next();
                            Object o1 = ((JSONObject) o).get(key1);
                            if (o1 instanceof String) {
                                if (o1 == null) {
                                    continue;
                                } else if ("".equals(o1.toString().trim())) {
                                    //空转null
                                    ((JSONObject) obj).put(key1, null);
                                    continue;
                                } else {
                                    ((JSONObject) o).put(key1, o1.toString().trim());
                                }
                            }
                        }
                    } else if (o instanceof String) {
                        if (o == null) {
                            continue;
                        } else if ("".equals(o.toString().trim())) {
                            //空转null
                            ((JSONArray) obj).set(i,null);
                            continue;
                        } else {
                            ((JSONArray) obj).set(i, ((String) o).trim());
                        }
                    }
                }
                reagobj.put(key, obj);
            } else if (obj instanceof String) {
                if (obj == null) {
                    continue;
                } else if ("".equals(obj.toString().trim())) {
                    //空转null
                    reagobj.put(key, null);
                    continue;
                } else {
                    reagobj.put(key, obj.toString().trim());
                }
            }
        }
        return reagobj;
    }
}
