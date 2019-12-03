package net.atos.api;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureInfo implements Serializable {
    private String city;
    private Date date;
    private double min;
    private double max;
    private double average;

}
