import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class MathUtilsTest {
   
    @BeforeAll
    static void initAll(){
        System.out.println("=== Bất đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("=== Kết thúc ===");
    }
    @Test
    @DisplayName("Kiểm thử phân vùng tương đương cho hàm max")
    void testMaxEquivalancepartitioning(){
        assertEquals(10, MathUtils.max(10, 5));
        assertEquals(10, MathUtils.max(10, 10));
        assertEquals(7, MathUtils.max(3, 7));
    }

    @Test
    @DisplayName("Kiểm thử giá trị biên cho hàm max")
    void testMaxBoundaryValueAnalysis(){
        assertEquals(-10, MathUtils.max(Integer.MIN_VALUE, -10));
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 1000));
    }

    @Test
    @DisplayName("Kiểm thử phân vùng tương đường cho hàm divide")
    void testDivideEP(){
        assertEquals(5, MathUtils.divide(10, 2));
        assertEquals(-4,MathUtils.divide(100, -25));

        Exception exception=assertThrows(IllegalArgumentException.class, () ->{
           MathUtils.divide(10, 0);
        });
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}
