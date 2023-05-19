package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(numbers));

        List<Integer> actual1 = App.take(numbersList, 3);
        List<Integer> expected1 = Arrays.asList(1, 2, 3);
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> actual2 = App.take(numbersList, 0);
        List<Integer> expected2 = new ArrayList<>();
        assertThat(actual2).isEqualTo(expected2);

        List<Integer> actual3 = App.take(numbersList, 9);
        List<Integer> expected3 = Arrays.asList(numbers);
        assertThat(actual3).isEqualTo(expected3);
        // END
    }
}
