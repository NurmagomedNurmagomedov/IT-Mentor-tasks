package task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки
Асинхронность выполнения нитей.
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью), которая в методе run 1000 раз (index = 0-999) сделает следующие действия:
2.1. Используя метод addNote добавит заметку с именем [getName() + "-Note" + index], например, при index=4
"Thread-0-Note4"
2.2. Заснет на 1 миллисекунду
2.3. Используя метод removeNote удалит заметку
2.4. В качестве параметра в removeNote передай имя нити - метод getName()


Requirements:
1. Класс Solution должен содержать public static класс NoteThread.
2. Класс NoteThread должен быть нитью.
3. В методе run класса NoteThread должен быть цикл.
4. Метод run класса NoteThread должен 1000 раз вызывать метод addNote c параметром (getName() + "-Note" + index).
5. Метод run класса NoteThread должен 1000 раз вызывать Thread.sleep() c параметром (1).
6. Метод run класса NoteThread должен 1000 раз вызывать метод removeNote c параметром (getName()).
*/

public class Solution {
    public static class NoteThread extends Thread {
        public void run() {
            for (int index = 0; index < 5; index++) {
                Note.addNote(getName() + "-Note" + index);
                System.out.println("поток" + getName() + "добавил заметку");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Note.removeNote(getName());
            }
        }
    }

    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static synchronized void removeNote(String threadName) {
            String note;
            if (notes.size() > 0) {
                note = notes.remove(0);
            } else note = null;
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку или нечего удалять");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }
}
