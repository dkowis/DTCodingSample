package dealertrack;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class KeyCounts {

    /**
     * Just a relatively naive function to collect data from a file and total up the keys.
     * I didn't do a whole lot of error checking, given the assumptions given in the coding exercise.
     * @param file
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String countKeys(URL file) throws URISyntaxException, IOException {
        //Convert it to a path, so we can use the Stream API to hopefully avoid loading the entire file
        Path path = Paths.get(file.toURI());
        Stream<String> lineStream = Files.lines(path);

        //Used a linked hash map, based on the assumption from the test case that I should order the output based
        //On the order I discover names
        Map<String, Integer> runningTotals = new LinkedHashMap<>();

        //Woo java 8 lambdas, not quite scala, but moderately useful!
        lineStream.forEach(line -> {
            //Again no error checking, assuming that the data matches the case as described
            String[] pair = line.split(",");
            String name = pair[0];
            Integer value = Integer.parseInt(pair[1]);

            //Do a put or update on the map as we're munching through all the lines
            if (runningTotals.containsKey(name)) {
                runningTotals.put(name, runningTotals.get(name) + value);
            } else {
                runningTotals.put(name, value);
            }
        });

        //Turn that map of key/sums into a string for the output
        StringBuilder sb = new StringBuilder();
        runningTotals.keySet().forEach(key -> {
            sb.append("The total for ").append(key).append(" is ").append(runningTotals.get(key)).append(". ");
        });

        sb.deleteCharAt(sb.length() - 1); //lop off that final space

        return sb.toString();
    }
}
