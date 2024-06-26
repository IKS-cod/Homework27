package pro.sky.Homework27.service;

import org.springframework.stereotype.Service;

@Service
public interface IntegerList {
    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(Integer[] otherList);

    int size();

    boolean isEmpty();

    void clear();
    Integer[] toArray();
}
