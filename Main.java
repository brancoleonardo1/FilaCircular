public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        try {
            queue.add(6);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Elementos na fila após adições:");
        printQueue(queue);

        System.out.println("Elemento removido: " + queue.remove());
        System.out.println("Elemento removido: " + queue.remove());

        System.out.println("Elementos na fila após remoções:");
        printQueue(queue);

        queue.clear();

        System.out.println("Elementos na fila após limpeza:");
        printQueue(queue);
    }

    public static <T> void printQueue(CircularQueue<T> queue) {
        T[] elements = queue.toArray();
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}