package com.sarik.learn.streams.parallel.notuse;

public class Sum {
    private int total;
    private int totalWithSync;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalWithSync() {
        return totalWithSync;
    }

    public void setTotalWithSync(int totalWithSync) {
        this.totalWithSync = totalWithSync;
    }

    public void performSum(int input){
        total+=input;
        //System.out.println("total: " + total);
    }

    synchronized public void performSumSync(int input){
        totalWithSync += input;
    }

}
