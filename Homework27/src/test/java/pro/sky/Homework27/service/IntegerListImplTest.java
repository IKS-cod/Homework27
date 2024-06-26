package pro.sky.Homework27.service;

import org.junit.jupiter.api.Test;
import pro.sky.Homework27.exception.ArrayIsFullException;
import pro.sky.Homework27.exception.ElementNullException;
import pro.sky.Homework27.exception.ExitForBorderArrayException;
import pro.sky.Homework27.exception.NotFoundElementException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private final IntegerListImpl stringList = new IntegerListImpl();

    @Test
    void addOneTest() {
        assertThat(stringList.size()).isEqualTo(0);
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        stringList.add(4);
        stringList.add(5);
        stringList.add(6);
        stringList.add(7);
        stringList.add(8);
        stringList.add(9);
        stringList.add(10);
        assertThat(stringList.size()).isEqualTo(10);
        assertThat(stringList.contains(1)).isEqualTo(true);
        assertThat(stringList.indexOf(1)).isEqualTo(0);
    }
    @Test
    void addOne_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.add(null));
    }
    @Test
    void addOne_ArrayIsFullException_Test() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        assertThatExceptionOfType(ArrayIsFullException.class).isThrownBy(() -> stringList.add(2));
    }
    @Test
    void AddTwoTest() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        assertThat(stringList.add(2, 1)).isEqualTo(1);

    }

    @Test
    void AddTwo_ArrayIsFullException_Test() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        assertThatExceptionOfType(ArrayIsFullException.class).isThrownBy(() -> stringList.add(4, 2));
    }

    @Test
    void AddTwo_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.add(9, 1));
    }

    @Test
    void AddTwo_ElementNullException_Test() {
        Integer d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.add(d));
    }

    @Test
    void setTest() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThat(stringList.set(1, 2)).isEqualTo(2);
    }
    @Test
    void set_ExitForBorderArrayException_Test() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.set(11, 2));
    }

    @Test
    void set_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.set(0, null));
    }
    @Test
    void removeTest() {
        stringList.add(1);

        assertThat(stringList.remove((Integer) 1)).isEqualTo(1);

    }

    @Test
    void remove_NotFoundElementException_Test() {
        stringList.add(1);
        assertThatExceptionOfType(NotFoundElementException.class).isThrownBy(() -> stringList.remove((Integer) 2));
    }

    @Test
    void remove_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.remove(null));
    }

    @Test
    void removeTwoTest() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThat(stringList.remove(1)).isEqualTo(1);
    }

    @Test
    void removeTwo_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.remove(10));
    }

    @Test
    void containsTest() {
        assertThat(stringList.size()).isEqualTo(0);
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        stringList.add(4);
        stringList.add(5);
        stringList.add(6);
        stringList.add(7);
        stringList.add(8);
        stringList.add(9);
        stringList.add(10);
        assertThat(stringList.size()).isEqualTo(10);
        assertThat(stringList.contains(1)).isEqualTo(true);
        assertThat(stringList.indexOf(1)).isEqualTo(0);
    }

    @Test
    void containsNegativeTest() {
        assertThat(stringList.size()).isEqualTo(0);
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        stringList.add(4);
        stringList.add(5);
        stringList.add(6);
        stringList.add(7);
        stringList.add(8);
        stringList.add(9);
        stringList.add(10);
        assertThat(stringList.size()).isEqualTo(10);
        assertThat(stringList.contains(11)).isEqualTo(false);
        assertThat(stringList.indexOf(1)).isEqualTo(0);
    }

    @Test
    void contains_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.contains(null));
    }

    @Test
    void indexOfTest() {
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertEquals(1, stringList.indexOf(2));
    }

    @Test
    void indexOfNegativeTest() {
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertEquals(-1, stringList.indexOf(4));
    }

    @Test
    void indexOf_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.indexOf(null));
    }

    @Test
    void lastIndexOfTest() {
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertEquals(1, stringList.lastIndexOf(2));
    }

    @Test
    void lastIndexOfNegativeTest() {
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertEquals(-1, stringList.lastIndexOf(4));
    }

    @Test
    void lastIndexOf_ElementNullException_Test() {
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.lastIndexOf(null));
    }

    @Test
    void getTest() {
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertThat(stringList.get(1)).isEqualTo(2);
    }
    @Test
    void get_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.get(10));
    }
    @Test
    void EqualsTest() {
        Integer[] expected = new Integer[4];
        expected[0]=1;
        expected[1]=1;
        expected[2]=1;
        expected[3]=1;

        assertThat(stringList.size()).isEqualTo(0);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThat(stringList.size()).isEqualTo(4);
        assertThat(Arrays.equals(stringList.toArray(),expected)).isEqualTo(true);
    }
    @Test
    void EqualsNegativeTest() {
        Integer[] expected = new Integer[4];
        expected[0]=1;
        expected[1]=1;
        expected[2]=1;
        expected[3]=1;

        assertThat(stringList.size()).isEqualTo(0);
        stringList.add(2);
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThat(stringList.size()).isEqualTo(4);
        assertThat(Arrays.equals(stringList.toArray(),expected)).isEqualTo(false);
    }

    @Test
    void size() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);

        assertThat(stringList.size()).isEqualTo(3);
    }

    @Test
    void isEmptyTest() {
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    void isEmptyNegativeTest() {
        stringList.add(1);
        assertThat(stringList.isEmpty()).isEqualTo(false);
    }
    @Test
    void clear() {
        stringList.add(1);
        stringList.add(1);
        stringList.add(1);
        assertThat(stringList.isEmpty()).isEqualTo(false);
        stringList.clear();
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    void toArrayTest() {
        Integer[] expected = new Integer[3];
        expected[0]=1;
        expected[1]=2;
        expected[2]=3;
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        assertThat(stringList.toArray()).isEqualTo(expected);
    }
}