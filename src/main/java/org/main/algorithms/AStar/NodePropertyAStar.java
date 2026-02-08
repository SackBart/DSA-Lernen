package org.main.algorithms.AStar;

public class NodePropertyAStar {
    private double posX;
    private double posY;
    private double costFromStart = 0;
    private double sumCost = 0;
    private int index;
    private NodePropertyAStar pred;

    public NodePropertyAStar(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public NodePropertyAStar(int index, double posX, double posY) {
        this.index = index;
        this.posX = posX;
        this.posY = posY;
    }

    public NodePropertyAStar getPred() {
        return pred;
    }
    public void setPred(NodePropertyAStar pred) {
        this.pred = pred;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public double getCostFromStart() {
        return costFromStart;
    }
    public void setCostFromStart(double costFromStart) {
        this.costFromStart = costFromStart;
    }
    public double getSumCost() {
        return sumCost;
    }
    public void setSumCost(double sumCost) {
        this.sumCost = sumCost;
    }
    public double getPosX() {
        return posX;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }
    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getDistanceBetween(NodePropertyAStar node) { // This calculates h
        return Math.sqrt(Math.pow(this.posX - node.getPosX(), 2) + Math.pow(this.posY - node.getPosY(), 2));
    }
}
