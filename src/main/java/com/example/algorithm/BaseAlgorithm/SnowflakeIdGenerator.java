package com.example.algorithm.BaseAlgorithm;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

public class SnowflakeIdGenerator {
    /**
     * 唯一实例
     */
    public static SnowflakeIdGenerator instance = new SnowflakeIdGenerator();
    /**
     * work id的最大bit数，最多支持2^13 -1 个节点
     */
    private static final int WORKER_ID_BITS = 13;
    /**
     * 最大work id
     * -1 的补码（二进制所有位均为1）右移13位然后取反
     */
    private static final long MAX_WORK_ID = ~(-1L << WORKER_ID_BITS);

    private static final long START_TIME = 1483200000000L;
    /**
     * 序列号，支持单节点每毫秒生成的最大ID数为1024
     */
    private static final int SEQUENCE_BITS = 10;
    /**
     * 最大序列号
     * -1的补码右移10位，然后取反
     */
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    /**
     * work 节点编号的位移
     */
    private static final long APP_HOST_ID_SHIFT = SEQUENCE_BITS;
    /**
     * 时间戳 移位
     */
    private static final long TIMESTAMP_LEFT_SHIFT = WORKER_ID_BITS + APP_HOST_ID_SHIFT;

    private long workerId;
    /**
     * 上一次生成ID的时间
     */
    private long lastTimeStamp = -1;
    /**
     * 当前毫秒生成的序列号
     */
    private long sequence = 0;

    /**
     * 初始化唯一实例
     * @param workerId
     */
    public synchronized void init(long workerId) {
        if (workerId > MAX_WORK_ID) {
            throw new IllegalArgumentException("work ID is wrong:" + workerId);
        }
        instance.workerId = workerId;
    }

    private SnowflakeIdGenerator() {

    }

    public long nextId() {
        return generateId();
    }

    private synchronized long generateId() {
        long current = System.currentTimeMillis();
        if (current < lastTimeStamp) {
            return -1;
        }
        if (current == lastTimeStamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == MAX_SEQUENCE) {
                current = this.nextMs(lastTimeStamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimeStamp = current;
        long time = (current - START_TIME) << TIMESTAMP_LEFT_SHIFT;
        long workId = this.workerId << APP_HOST_ID_SHIFT;
        //存到一个map中 ，覆盖当前毫秒的值，
        return time | workId | sequence;
    }

    private long nextMs(long timeStamp) {
        long current = System.currentTimeMillis();
        while (current <= timeStamp) {
            current = System.currentTimeMillis();
        }
        return current;
    }

    public static void main(String[] args) throws InterruptedException {
        SnowflakeIdGenerator snowflakeIdGenerator = SnowflakeIdGenerator.instance;
        while (true){
            TimeUnit.MILLISECONDS.sleep(10);
            long id = snowflakeIdGenerator.nextId();
            System.out.println(id);
        }
    }
}
