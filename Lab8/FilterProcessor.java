import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterData(List<String> sentences) {

        List<String> filteredData = sentences.stream()
                .filter(sentence -> sentence.contains("I can"))
                .collect(Collectors.toList());

        System.out.println("filtered data: " + filteredData);

        return filteredData;
    }
}