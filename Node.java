class Node {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public DoublyLinkedList() {
        this.head = null;
    }
    
    public void reverse() {
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        if (temp != null) {
            head = temp.prev;
        }
    }
    
    public void display() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Создаем узлы списка
        Node[] nodes = new Node[15];
        
        // Заполняем список значениями
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        
        // Устанавливаем связи между узлами
        for (int i = 0; i < nodes.length-1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i + 1].prev = nodes[i];
        }
        
        list.head = nodes[0];
        
        // Выводим исходный список
        System.out.print("Исходный список: ");
        list.display();
        
        // Разворачиваем список
        list.reverse();
        
        // Выводим развернутый список
        System.out.print("Развернутый список: ");
        list.display();
    }
}
