package ru.loginovskiy.sitescomparator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SitesMapComparator {
    private List<URL> absentInSecondMap = new ArrayList<>();
    private List<URL> absentInFirstMap = new ArrayList<>();
    private List<URL> differentInMaps = new ArrayList<>();

    public void compareSitesMap(Map<URL, String> firstMap, Map<URL, String> secondMap) {


        firstMap.forEach((url, firstStr) -> {
            String secondStr = secondMap.get(url);
            if (secondStr == null) {
                absentInSecondMap.add(url);
            } else if (!secondStr.equals(firstStr)) {
                differentInMaps.add(url);
            }
        });

        secondMap.forEach((url, secondStr) -> {
            if (firstMap.get(url) == null) {
                absentInFirstMap.add(url);
            }
        });

    }

    public List<URL> getAbsentInSecondMap() {
        return absentInSecondMap;
    }

    public List<URL> getAbsentInFirstMap() {
        return absentInFirstMap;
    }

    public List<URL> getDifferentInMaps() {
        return differentInMaps;
    }
}
