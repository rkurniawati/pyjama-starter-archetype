import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void sumNumbers0() {
        int[] a = {};
        assertEquals(0, App.sumNumbers(a, 1));
    }

    @Test
    void sumNumbers3() {
        int[] a = {1, 2, 3};
        assertEquals(6, App.sumNumbers(a, 1));
    }

    @Test
    void sumNumbers10() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(55, App.sumNumbers(a, 2));
    }

}