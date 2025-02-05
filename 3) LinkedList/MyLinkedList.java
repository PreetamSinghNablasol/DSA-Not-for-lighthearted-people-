class MyLinkedList{
    int value;
    MyLinkedList next;
}

class Main 
{
public static void main(String[] args) {
    {
        MyLinkedList obj1 = new MyLinkedList();
        MyLinkedList obj2 = new MyLinkedList();
        MyLinkedList obj3 = new MyLinkedList();
        MyLinkedList obj4 = new MyLinkedList();
        MyLinkedList obj5 = new MyLinkedList();
        MyLinkedList obj6 = new MyLinkedList();

        obj1.value = 15;
        obj1.next = obj2;
        obj2.value = 15;
        obj2.next = obj3;
        obj3.value = 15;
        obj3.next=obj4;
        obj4.value = 15;
        obj4.next= obj5;
        obj5.value = 15;
        obj5.next=obj6;
        obj6.value = 15;
    }
}