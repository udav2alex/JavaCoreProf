package homework1.fruits_and_boxes;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> storage = new ArrayList<>();

    public void put(T fruit) {
        storage.add(fruit);
    }

    public T get() {
        if (storage.size() == 0) return null;
        return storage.remove(storage.size() - 1);
    }

    // TODO Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов
    // и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах)
    public float getWeight() {
        final float[] result = new float[1];
        storage.forEach(t -> result[0] += t.getWeight());
        return result[0];
    }

    // TODO Внутри класса Box сделать метод compare, который позволяет сравнить текущую коробку другой:
    // true – если она равны по весу, false – иначе (Box с яблоками можем сравнивать с Box с апельсинами)
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // TODO Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
    // (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
    // В текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    // Не забываем про метод добавления фрукта в коробку. Можно пересыпать из коробки в саму себя.
    public void move(Box<T> toBox) {
        if (toBox == this) return;

        storage.forEach(toBox::put);
        storage.clear();
    }
}
