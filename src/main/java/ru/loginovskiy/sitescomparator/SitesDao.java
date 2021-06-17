package ru.loginovskiy.sitescomparator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SitesDao {

    Map<URL, String> yesterdaySitesMap = new HashMap<>();
    Map<URL, String> todaySitesMap = new HashMap<>();

    public Map<URL, String> getYesterdaySitesMap() {
        return yesterdaySitesMap;
    }

    public Map<URL, String> getTodaySitesMap() { ;
        return todaySitesMap;
    }
}
