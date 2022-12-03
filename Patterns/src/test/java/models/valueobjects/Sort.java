package models.valueobjects;

import java.io.Serializable;

public class Sort implements Serializable {
    private String sort;

    public Sort() {
    }

    public Sort(String sort) {
        if (!sort.isBlank() || !sort.isEmpty()) {
            this.sort = sort;
        } else {
            throw new IllegalArgumentException("Сортировка не может быть пустой!");
        }
    }

    public String getSort() {
        return this.sort;
    }

    public boolean equals(Sort otherSort) {
        return this.sort.equals(otherSort.sort);
    }
}
