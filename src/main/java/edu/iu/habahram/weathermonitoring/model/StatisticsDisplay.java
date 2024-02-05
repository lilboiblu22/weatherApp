package edu.iu.habahram.weathermonitoring.model;

import org.springframework.stereotype.Component;

@Component
public class StatisticsDisplay implements Observer, DisplayElement {

    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public String display() {
        String html = "";
        html += String.format("<div style=\"background-image: " +
                "url(/images/sky.webp); " +
                "height: 400px; " +
                "width: 647.2px;" +
                "display:flex;flex-wrap:wrap;justify-content:center;align-content:center;" +
                "\">");
        html += "<section>";
        html += String.format("<label>Average Temp: %s</label><br />", averageTemp());
        html += String.format("<label>Min. Temp: %s</label><br />", minTemp());
        html += String.format("<label>Max. Temp: %s</label>", maxTemp());
        html += "</section>";
        html += "</div>";
        return html;
    }

    @Override
    public void update(float temp, float humidity, float pressure){
        this.averageTemp();
        this.minTemp();
        this.maxTemp();
    }

    @Override
    public String name() {
        return "Statistics Display:";
    }

    @Override
    public String id() {
        return "weather-statistics";
    }

    public float averageTemp() {
        double temp1 = Math.random();
        double temp2 = Math.random();
        double temp3 = Math.random();
        return (float) ((temp1 + temp2 + temp3) / 3);
    }

    public float minTemp() {
        double temp1 = Math.random();
        double temp2 = Math.random();
        double temp3 = Math.random();
        return (float) Math.min(temp1, Math.min(temp2, temp3));
    }

    public float maxTemp() {
        double temp1 = Math.random();
        double temp2 = Math.random();
        double temp3 = Math.random();
        return (float) Math.max(temp1, Math.max(temp2, temp3));
    }
}
