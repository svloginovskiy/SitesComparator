package ru.loginovskiy.sitescomparator;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        SitesDao sitesDao = new SitesDao();
        Map<URL, String> yesterdaySitesMap = sitesDao.getYesterdaySitesMap();
        Map<URL, String> todaySitesMap = sitesDao.getTodaySitesMap();
        yesterdaySitesMap.forEach((k,v) -> System.out.println(k + v));
        SitesMapComparator sitesMapComparator = new SitesMapComparator();

        sitesMapComparator.compareSitesMap(yesterdaySitesMap, todaySitesMap);

        printLetter(sitesMapComparator.getAbsentInSecondMap(), sitesMapComparator.getAbsentInFirstMap(), sitesMapComparator.getDifferentInMaps() );

    }

    static void printLetter(List<URL> disappearedURLs, List<URL> appearedURLs, List<URL> changedURLs) {
        System.out.println("Здравствуйте, дорогая и.о. секретаря\n\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n" +
                "Исчезли следующие страницы:");
        disappearedURLs.forEach(url -> System.out.println(url));
        System.out.println("Появились следующие новые страницы:");
        appearedURLs.forEach(url -> System.out.println(url));
        System.out.println("Изменились следующие страницы:");
        changedURLs.forEach(url -> System.out.println(url));
        System.out.println("С уважением,\nавтоматизированная система\nмониторинга.");
    }

}
