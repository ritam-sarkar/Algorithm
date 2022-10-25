package com.riversand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

public class VariantGraphGenerator {
   public static void main(String[] args) {
      Map<String , List<String>> attributeMap = new LinkedHashMap<>();
      attributeMap.put("attr1", Arrays.asList("a","b","c"));
      attributeMap.put("attr2", Arrays.asList("e","f"));
      attributeMap.put("attr3", Arrays.asList("g","h"));
      attributeMap.put("attr4", Arrays.asList("i"));
      //List<Entity> entities = getAllEntities(variantMap);
      List<LinkedHashSet<String>> listOfValueSets = new ArrayList<>();
      for (Map.Entry<String,List<String>> entry : attributeMap.entrySet()){
         listOfValueSets.add(new LinkedHashSet<>(entry.getValue()));
      }
      Set<List<String>> cartesianProduct = Sets.cartesianProduct(listOfValueSets);
      Set<List<String>> productSet = new HashSet<>();
      for (List<String> immList : cartesianProduct) {
         List<String> list = new ArrayList<>(immList);
         productSet.add(list);
      }
      System.out.println(productSet);


   }

   private static List<Entity> getAllEntities(Map<String, List<String>> variantMap) {
      long totalCount = getTotalCount(variantMap);
      List<Map.Entry<String, List<String>>> variantList = sortByValue(variantMap);
      int keyCount = variantList.size();
      System.out.println(variantList);
      List<Entity> entities = new ArrayList<>();
      for(int i= 0; i< totalCount; i++){

      }
      return null;
   }

   private static int getTotalCount(Map<String, List<String>> variantMap) {
     int totalCount =1;
     for (List<String> list : variantMap.values()){
        totalCount *= list.size();
     }
     return totalCount;
   }
   private static List<Map.Entry<String, List<String>>> sortByValue(Map<String, List<String>> variantMap){
      List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(variantMap.entrySet());
      Collections.sort(sortedList,(e1,e2)->e2.getValue().size() - e1.getValue().size());
      return sortedList;
   }


   public static class Entity{
      private String attr1;
      private String attr2;
      private String attr3;
      private String attr4;

      public String getAttr1() {
         return attr1;
      }

      public void setAttr1(String attr1) {
         this.attr1 = attr1;
      }

      public String getAttr2() {
         return attr2;
      }

      public void setAttr2(String attr2) {
         this.attr2 = attr2;
      }

      public String getAttr3() {
         return attr3;
      }

      public void setAttr3(String attr3) {
         this.attr3 = attr3;
      }

      public String getAttr4() {
         return attr4;
      }

      public void setAttr4(String attr4) {
         this.attr4 = attr4;
      }

      public Entity(List<String> attrList) {
         this.attr1 = attrList.get(0);
         this.attr2 = attrList.get(1);
         this.attr3 = attrList.get(2);
         this.attr4 = attrList.get(3);
      }
   }
}

