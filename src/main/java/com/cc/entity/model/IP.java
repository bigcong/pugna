package com.cc.entity.model;

/**
 * Created by cong.cui on 16/10/12 上午11:39.
 */
public class IP {
    /**
     * name	description	example	type
     status	always success	success	string
     country	country	United States	string
     countryCode	country short	US	string
     region	region/state short	CA or 10	string
     regionName	region/state	California	string
     city	city	Mountain View	string
     zip	zip code	94043	string
     lat	latitude	37.4192	float
     lon	longitude	-122.0574	float
     timezone	city timezone	America/Los_Angeles	string
     isp	ISP name	Google	string
     org	Organization name	Google	string
     as	AS number and name, separated by space	AS15169 Google Inc.	string
     reverse	Reverse DNS of the IP	wi-in-f94.1e100.net	string
     mobile	mobile (cellular) connection	true	bool
     proxy	proxy (anonymous)	true	bool
     query	IP used for the query	173.194.67.94	string

     */
    private String as = "";
    private String city = "";
    private String country = "";
    private String countryCode = "";
    private String isp = "";
    private Double lat = 0d;
    private Double lon = 0d;
    private String org = "";
    private String query = "";
    private String region = "";
    private String regionName = "";
    private String status = "";
    private String timezone = "";
    private String zip = "";

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
