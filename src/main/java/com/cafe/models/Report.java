package com.cafe.models;

import java.time.LocalDate;
import java.util.Map;

public final class Report {
    private final LocalDate reportDate;
    private double moneyEarnedToday;
    private double moneyEarnedMonthly;
    private String mostItemBoughtToday;
    private final Map<String, Integer> itemsBoughtWithCount;

    public Report(LocalDate reportDate, double moneyEarnedToday, double moneyEarnedMonthly, String mostItemBoughtToday, Map<String, Integer> itemsBoughtWithCount) {
        this.reportDate = reportDate;
        this.moneyEarnedToday = moneyEarnedToday;
        this.moneyEarnedMonthly = moneyEarnedMonthly;
        this.mostItemBoughtToday = mostItemBoughtToday;
        this.itemsBoughtWithCount = itemsBoughtWithCount;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public double getMoneyEarnedToday() {
        return moneyEarnedToday;
    }

    public void setMoneyEarnedToday(double moneyEarnedToday) {
        this.moneyEarnedToday = moneyEarnedToday;
    }

    public double getMoneyEarnedMonthly() {
        return moneyEarnedMonthly;
    }

    public void setMoneyEarnedMonthly(double moneyEarnedMonthly) {
        this.moneyEarnedMonthly = moneyEarnedMonthly;
    }

    public String getMostItemBoughtToday() {
        return mostItemBoughtToday;
    }

    public void setMostItemBoughtToday(String mostItemBoughtToday) {
        this.mostItemBoughtToday = mostItemBoughtToday;
    }

    public Map<String, Integer> getItemsBoughtWithCount() {
        return itemsBoughtWithCount;
    }
}
