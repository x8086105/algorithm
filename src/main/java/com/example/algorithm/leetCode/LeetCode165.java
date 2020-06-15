package com.example.algorithm.leetCode;

public class LeetCode165 {
    public static void main(String[] args) {
        //System.out.println(compareVersion("7.5.2.4.1.0.1","7.5.2.4.1"));
        String ss = "1757760018, 1030629, 6269446, 677628, 125610170, 733545533, 529119918, 537582968, 5381698, 5010634, 942849190, 64761, 9095138, 504317395, 23991, 1129649, 3015311, 249059562, 648835831, 9562584, 13124709, 8806298, 171553, 1271391, 467835831, 5351339, 407120431, 165458888, 9118427, 1695592, 841569507, 7400391, 109149, 88122, 3863152, 608567727, 3698441, 1250001, 118950018, 1014092, 6311944, 107957, 2335852, 4167280, 127239, 518625, 628203, 459432, 746469, 350939834, 219983398, 202133252, 33114, 93021, 551141785, 142049409, 287107437, 2280006, 3375142, 103236818, 306412076, 8289086, 946668879, 8192818, 800469068, 295695593, 25382969, 182284897, 217156457, 797458, 38675956, 562547139, 772405333, 5554549, 91879, 164853012, 509278, 688454, 778645286, 637483, 7190532, 788246466, 277, 4847216, 699633, 7135423, 893125, 837196261, 2287193, 767652073, 663951222, 848620012, 3525864, 1790306, 1746838, 422302, 2019511, 227558, 6343582, 900095";
        String []t = ss.split(",");
        System.out.println(t.length);
    }
    public static int compareVersion(String version1, String version2) {
        String []v1 = version1.split("\\.");
        String []v2 = version2.split("\\.");
        int length = Math.min(v1.length, v2.length);
        for(int i = 0; i<length;i++){
            if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i])){
                return 1;
            }
            if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i])){
                return -1;
            }
        }
        //遍历大的那些剩余的部分
        int emptyLength = Math.abs(v1.length - v2.length);
        for(int i = 0;i<emptyLength;i++){
            if(v1.length > v2.length){
                if(Integer.parseInt(v1[length + i]) > 0){
                    return 1;
                }
            }else{
                if(Integer.parseInt(v2[length + i]) > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
