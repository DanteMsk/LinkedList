
public class Stract {                                           // Данный класс реализует односторонний список
    private Element First;                                      // Первый узел списка

    Stract(Element _first) {                                    // Конструктор класса
        First = _first;
    }

    public void AddPlusSort(String Value) {
        Element New = new Element();                     // Выделение памяти для нового узла
        New.value = Value;                               // Инициализация значения узла заданным
        Element pred = null;                             // Cсылка на предыдущий узел
        Element current = First;                         // Текущий узел по умолчанию является первым в спике
        while (current != null) {
            if (current.value.compareTo(Value) >= 0) {          // Если значение узла должно находиться до текущего
                New.next = current;
                if (pred != null) {                             // Вставка элемента на первую позицию в списке
                    pred.next = New;
                } else First = New;

                return;
            } else {
                if (current.next == null) {
                    current.next = New;
                    New.next = null;
                    return;
                }
            }
            pred = current;
            current = current.next;
        }
    }

    public void Remove(int Index) {
        if (Index < 0)
            throw new IndexOutOfBoundsException(Index + " < 0");         // Обработка исключения, если индекс <0
        // Удаление элемента по индексу
        int Check = 0;
        Element current = First;
        Element pred = null;
        if (Index == 0) {
            First = current.next;                           // Удаление первого элемента
        } else {
            while (current != null) {
                if ((Check == Index)) {                      // Удаление элемента с индексом введеным пользователем
                    pred.next = current.next;
                    return;
                }
                Check++;
                pred = current;
                current = current.next;
            }
            throw new IndexOutOfBoundsException(Index + " >= " + Check);
        }
    }

    public void PrintMylist() {                                  // Вывод всех элементов списка
        int index = 0;
        for (Element x = First; x != null; x = x.next) {
            System.out.println("Элемент с индексом " + index + " :  " + x.value);
            index++;
        }
        System.out.println();
    }

    public int NumberOfElements() {                               // Метод подсчета элементов списка
        int LengList = 0;
        for (Element x = First; x != null; x = x.next) {
            LengList++;
        }
        return LengList;
    }
}