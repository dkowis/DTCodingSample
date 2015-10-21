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

    public static String countKeys(URL file) throws URISyntaxException, IOException {
        Path path = Paths.get(file.toURI());

        Stream<String> lineStream = Files.lines(path);

        Map<String, Integer> runningTotals = new LinkedHashMap<>();
        lineStream.forEach(line -> {
            String[] pair = line.split(",");
            String name = pair[0];
            Integer value = Integer.parseInt(pair[1]);

            if (runningTotals.containsKey(name)) {
                runningTotals.put(name, runningTotals.get(name) + value);
            } else {
                runningTotals.put(name, value);
            }
        });

        StringBuilder sb = new StringBuilder();
        runningTotals.keySet().forEach(key -> {
            sb.append("The total for ").append(key).append(" is ").append(runningTotals.get(key)).append(". ");
        });

        sb.deleteCharAt(sb.length() - 1); //lop off that final space

        return sb.toString();
    }
}
