package com.cdut.domain;

/**
 * 飞机类
 */
public class Flight {
    private int fid;//序号
    private String flightNo;//航班号
    private String departureCity;//起飞城市
    private String arrivalCity;//目的地
    private String departureTime;//起飞时间
    private String arrivalTime;//到达时间

    public Flight(int fid, String flightNo, String departureCity, String arrivalCity, String departureTime, String arrivalTime) {
        this.fid = fid;
        this.flightNo = flightNo;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Flight(String flightNo, String departureCity, String arrivalCity, String departureTime, String arrivalTime) {
        this.flightNo = flightNo;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
