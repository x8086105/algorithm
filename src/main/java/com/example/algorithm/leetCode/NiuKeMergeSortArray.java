package com.example.algorithm.leetCode;

public class NiuKeMergeSortArray {



    public static void merge(int A[], int m, int B[], int n) {
        int right = A.length-1;
        int curA = m-1;
        int curB = n-1;

        while(curA >= 0 && curB >= 0) {
            if(A[curA] > B[curB]) {
                A[right--] = A[curA--];
            }else {
                A[right--] = B[curB--];
            }
        }

        while(curA >= 0) {
            A[right--] = A[curA--];
        }

        while(curB >= 0) {
            A[right--] = B[curB--];
        }
    }

    private static int[] insert(int A[],int index,int value){
        int []AA = new int[A.length + 1];
        for(int i = 0; i < AA.length; i++){
            if(i < index){
                AA[i] = A[i];
            }else if(i == index){
                AA[i] = value;
            }else{
                int j = i - 1;
                AA[i] = A[j];
            }
        }
        return AA;
    }

    public static void main(String[] args) {
        int []A= {1,2,5,7,8,0,0,0};
        int []B= {3,4,6};
        merge(A,5,B,3);

    }
}
