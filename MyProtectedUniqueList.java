package TEST;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyProtectedUniqueList<T> implements Iterable<T> {

    private String secretWord;
    private List<T> words;
    private int count;

    public MyProtectedUniqueList(String secretWord, List<T> words) {
        this.secretWord = secretWord;
        this.words = words;
        this.count = words.size();
    }

    @Override
    public String toString() {
        return "Your list contains " + this.words;
    }

    public List<T> getWords() {
        return this.words;
    }

    public void setWords(List<T> words) {
        this.words = words;
    }

    private String getSecretWord() {
        return secretWord;
    }

    public void Add(T word, String key) throws Exception {
        try {
            if (word == "" || word == null) throw new Exception("Invalid word!");
            else if (!getSecretWord().equals(key)) throw new Exception("Invalid key!");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        this.count++;
        this.words.add(word);
    }

    public void Remove(T word, String key) throws Exception {
        try {
            if (word == "" || word == null) throw new Exception("Invalid word!");
            else if (!getSecretWord().equals(key)) throw new Exception("Invalid key!");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        this.count--;
        this.words.remove(word);
    }

    public void RemoveAt(int index, String key) throws Exception {
        try {
            if (index < 0 || index > this.words.size()) throw new Exception("Invalid index!");
            else if (!getSecretWord().equals(key)) throw new Exception("Invalid key!");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        this.count--;
        this.words.remove(index);
    }

    public void Clear(String key) throws Exception {
        try {
            if (!getSecretWord().equals(key)) throw new Exception("Invalid key!");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        this.count = 0;
        this.words.clear();
    }

    public void Sort(String key) throws Exception {
        try {
            if (!getSecretWord().equals(key)) throw new Exception("Invalid key!");
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        this.words.sort(MyListComparator());
    }


    // Add comparator so we can sort the list:
    public Comparator<T> MyListComparator() {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String word1 = (String) o1;
                    String word2 = (String) o2;
                    return word1.compareTo(word2);
                } else if (o1 instanceof Character && o2 instanceof Character) {
                    char first = (char) o1;
                    char second = (char) o2;
                    return first - second;
                } else if (o1 instanceof Integer && o2 instanceof Integer) {
                    int first = (int) o1;
                    int second = (int) o2;
                    return first - second;
                } else if (o1 instanceof Double && o2 instanceof Double) {
                    double first = (double) o1;
                    double second = (double) o2;
                    return (int) (first - second);
                }
                return 0;
            }
        };
    }

//   FOREACH: (question 8)

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new myListIterator(this);
    }

    private class myListIterator implements Iterator<T> {

        private MyProtectedUniqueList myProList;
        private int index = 0;

        public myListIterator(MyProtectedUniqueList list) {
            this.myProList = list;
        }

        @Override
        public boolean hasNext() {
            return (this.index < myProList.count);
        }

        @Override
        public T next() {
            return (T) myProList.getWords().get(index++);
        }
    }
}

