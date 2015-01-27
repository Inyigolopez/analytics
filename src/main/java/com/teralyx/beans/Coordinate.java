
package com.teralyx.beans;

import java.math.BigDecimal;

public class Coordinate {

    private final BigDecimal longitude;
    private final BigDecimal latitude;

    public Coordinate(String longitude, String latitude) {
	this(new BigDecimal(longitude), new BigDecimal(latitude));
    }

    public Coordinate(BigDecimal longitude, BigDecimal latitude) {
	this.longitude = longitude;
	this.latitude = latitude;
    }

    public double getLatitude() {
	return latitude.doubleValue();
    }

    public double getLongitude() {
	return longitude.doubleValue();
    }
}