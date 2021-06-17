import org.junit.Assert;
import org.junit.Test;
import ru.loginovskiy.sitescomparator.SitesMapComparator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SitesMapComparatorTest {

    @Test
    public void comparisonTest() {
        Map<URL, String> firstMap = new HashMap<>();
        Map<URL, String> secondMap = new HashMap<>();

        try {
            firstMap.put(new URL("http://same_url.com"), "<html></html>");
            firstMap.put(new URL("http://firstmapurl.com"), "<html><head>123</head></html>");
            firstMap.put(new URL("http://changedcontent.com"), "<p>Old saying</p>");
            secondMap.put(new URL("http://changedcontent.com"), "<p>New saying</p>");
            secondMap.put(new URL("http://second_map_url.com"), "second");
            secondMap.put(new URL("http://same_url.com"), "<html></html>");
            SitesMapComparator sitesMapComparator = new SitesMapComparator();
            sitesMapComparator.compareSitesMap(firstMap, secondMap);

            List<URL> actualAbsentInSecondMap = sitesMapComparator.getAbsentInSecondMap();
            List<URL> actualAbsentInFirstMap = sitesMapComparator.getAbsentInFirstMap();
            List<URL> actualDifferentInMaps = sitesMapComparator.getDifferentInMaps();


            List<URL> expectedAbsentInSecondMap = new ArrayList<>();
            expectedAbsentInSecondMap.add(new URL("http://firstmapurl.com"));

            List<URL> expectedAbsentInFirstMap = new ArrayList<>();
            expectedAbsentInFirstMap.add(new URL("http://second_map_url.com"));

            List<URL> expectedDifferentInMaps = new ArrayList<>();
            expectedDifferentInMaps.add(new URL("http://changedcontent.com"));

            Assert.assertEquals(expectedAbsentInSecondMap, actualAbsentInSecondMap);
            Assert.assertEquals(expectedAbsentInFirstMap, actualAbsentInFirstMap);
            Assert.assertEquals(expectedDifferentInMaps, actualDifferentInMaps);

        } catch (MalformedURLException e) {
            System.err.println("URL MALFORMED");
        }
    }

}
