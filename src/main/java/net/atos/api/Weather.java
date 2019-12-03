package net.atos.api;

import java.util.Date;
import java.util.List;

public interface Weather {
	public List<TemperatureInfo> getTemperature(String city, List<Date> dates);
}
