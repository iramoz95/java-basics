//A simple version of the Quicksort
class Quicksort {
    // Set up a call to the actual Quicksort method
    static void qsort(char[] items) {
        qs(items, 0, items.length - 1);
    }

    // A recursive version of Quicksort for characters
    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;

        i = left;
        j = right;
        x = items[(left + right) / 2];

        do {
            while ((items[i] < x) && (i < right))
                i++;
            while ((x < items[j]) && (j > left))
                j--;

            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j)
            qs(items, left, j);
        if (i < right)
            qs(items, i, right);
    }
}

class QSDemo {
    public static void main(String[] args) {
        int i;
        char[] a = { 'J', 'a', 'v', 'a', '/', '/', 'U', 's', 'e', 'a', 's', 't', 'a', 't', 'i', 'c', 'b', 'l', 'o', 'c',
                'k', 'c', 'l', 'a', 's', 's', 'S', 't', 'a', 't', 'i', 'c', 'B', 'l', 'o', 'c', 'k', '{', 's', 't', 'a',
                't', 'i', 'c', 'd', 'o', 'u', 'b', 'l', 'e', 'r', 'o', 'o', 't', 'o', 'f', '2', ';', 's', 't', 'a', 't',
                'i', 'c', 'd', 'o', 'u', 'b', 'l', 'e', 'r', 'o', 'o', 't', 'o', 'f', '3', ';', '/', '/', 'T', 'h', 'i',
                's', 'b', 'l', 'o', 'c', 'k', 'i', 's', 'e', 'x', 'e', 'c', 'u', 't', 'e', 'd', 'w', 'h', 'e', 'n', 't',
                'h', 'e', 'c', 'l', 'a', 's', 's', 'i', 's', 'l', 'o', 'a', 'd', 'e', 'd', 's', 't', 'a', 't', 'i', 'c',
                '{', 'S', 'y', 's', 't', 'e', 'm', '.', 'o', 'u', 't', '.', 'p', 'r', 'i', 'n', 't', 'l', 'n', '(', '"',
                'I', 'n', 's', 'i', 'd', 'e', 's', 't', 'a', 't', 'i', 'c', 'b', 'l', 'o', 'c', 'k', '"', ')', ';', 'r',
                'o', 'o', 't', 'o', 'f', '2', '=', 'M', 'a', 't', 'h', '.', 's', 'q', 'r', 't', '(', '2', '.', '0', ')',
                ';', 'r', 'o', 'o', 't', 'o', 'f', '3', '=', 'M', 'a', 't', 'h', '.', 's', 'q', 'r', 't', '(', '3', '.',
                '0', ')', ';', '}', 'S', 't', 'a', 't', 'i', 'c', 'B', 'l', 'o', 'c', 'k', '(', 'S', 't', 'r', 'i', 'n',
                'g', 'm', 's', 'g', ')', '{', 'S', 'y', 's', 't', 'e', 'm', '.', 'o', 'u', 't', '.', 'p', 'r', 'i', 'n',
                't', 'l', 'n', '(', 'm', 's', 'g', ')', ';', '}', '}', 'c', 'l', 'a', 's', 's', 'S', 'D', 'e', 'm', 'o',
                '3', '{', 'p', 'u', 'b', 'l', 'i', 'c', 's', 't', 'a', 't', 'i', 'c', 'v', 'o', 'i', 'd', 'm', 'a', 'i',
                'n', '(', 'S', 't', 'r', 'i', 'n', 'g', '[', ']', 'a', 'r', 'g', 's', ')', '{', 'S', 't', 'a', 't', 'i',
                'c', 'B', 'l', 'o', 'c', 'k', 'o', 'b', '=', 'n', 'e', 'w', 'S', 't', 'a', 't', 'i', 'c', 'B', 'l', 'o',
                'c', 'k', '(', '"', 'I', 'n', 's', 'i', 'd', 'e', 'c', 'o', 'n', 's', 't', 'r', 'u', 'c', 't', 'o', 'r',
                '"', ')', ';', 'S', 'y', 's', 't', 'e', 'm', '.', 'o', 'u', 't', '.', 'p', 'r', 'i', 'n', 't', 'l', 'n',
                '(', '"', 'S', 'q', 'u', 'a', 'r', 'e', 'r', 'o', 'o', 't', 'o', 'f', '2', 'i', 's', '"', '+', 'S', 't',
                'a', 't', 'i', 'c', 'B', 'l', 'o', 'c', 'k', '.', 'r', 'o', 'o', 't', 'o', 'f', '2', ')', ';', 'S', 'y',
                's', 't', 'e', 'm', '.', 'o', 'u', 't', '.', 'p', 'r', 'i', 'n', 't', 'l', 'n', '(', '"', 'S', 'q', 'u',
                'a', 'r', 'e', 'r', 'o', 'o', 't', 'o', 'f', '3', 'i', 's', '"', '+', 'S', 't', 'a', 't', 'i', 'c', 'B',
                'l', 'o', 'c', 'k', '.', 'r', 'o', 'o', 't', 'o', 'f', '3', ')', ';', '}', '}' };

        System.out.println("Original array: ");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();

        Quicksort.qsort(a);
        System.out.println("\nSorted array");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }
}