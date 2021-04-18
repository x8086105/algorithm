package com.example.studyBase;

import java.util.*;


public class ConsistentHash {

    private interface HashFunction {
        //hash函数
        Integer hash(String key);
    }

    private final HashFunction hashFunction;// hash 函数接口
    private final int numberOfReplicas;// 每个机器节点关联的虚拟节点个数
    private final SortedMap<Integer, Node> circle = new TreeMap<>();// 环形虚拟节点

    /**
     * @param hashFunction     hash 函数接口
     * @param numberOfReplicas 每个机器节点关联的虚拟节点个数
     * @param nodes            真实机器节点
     */
    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<Node> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (Node node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实机器节点
     *
     * @param node
     */
    public void add(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.put(this.hashFunction.hash(node.getIp() + i), node);
        }
    }

    /**
     * 删除真实机器节点
     *
     * @param node
     */
    public void remove(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.remove(this.hashFunction.hash(node.getIp() + i));
        }
    }

    /**
     * 取得真实机器节点
     *
     * @param key
     * @return
     */
    public Node get(String key) {
        if (circle.isEmpty()) {
            return null;
        }

        Integer hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, Node> tailMap = circle.tailMap(hash);// 沿环的顺时针找到一个虚拟节点
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        return circle.get(hash); // 返回该虚拟节点对应的真实机器节点的信息
    }

    // 物理机节点模拟类，保存节点的IP、名称、端口等信息
    private static class Node {

        private String ip;// IP
        private String name;// 名称

        public Node(String ip, String name) {
            this.ip = ip;
            this.name = name;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class HashFunctionImpl implements HashFunction {
        //FNV1_32_HASH算法
        @Override
        public Integer hash(String key) {

            final int p = 16777619;
            int hash = (int) 2166136261L;
            for (int i = 0; i < key.length(); i++)
                hash = (hash ^ key.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;

            // 如果算出来的值为负数则取其绝对值
            if (hash < 0)
                hash = Math.abs(hash);
            return hash;
        }
    }

    private static final String IP_PREFIX = "192.168.1.";// 机器节点IP前缀

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();// 每台真实机器节点上保存的记录条数
        HashFunction hashFunction = new HashFunctionImpl();
        //真实物理节点
        List<Node> realNodes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0);// 每台真实机器节点上保存的记录条数初始为0

            Node node = new Node(IP_PREFIX + i, "node" + i);
            realNodes.add(node);
        }


        ConsistentHash consistentHash = new ConsistentHash(hashFunction, 100, realNodes);
        // 将10000条记录尽可能均匀的存储到10台机器节点
        for (int i = 0; i < 10000; i++) {
            // 产生随机一个字符串当做一条记录，可以是其它更复杂的业务对象,比如随机字符串相当于对象的业务唯一标识
            String data = UUID.randomUUID().toString() + i;
            // 通过记录找到真实机器节点
            Node node = consistentHash.get(data);
            // 这里可以通过其它工具将记录存储真实机器节点上，比如MemoryCache等
            // ...
            // 每台真实机器节点上保存的记录条数加1
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }

        // 打印每台真实机器节点保存的记录条数
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get("192.168.1." + i));
        }
    }

}
