package abstractClass.challenge;

public class Main {
    private static MyLinkedList myLinkedList = new MyLinkedList(null);
    public static void main(String[] args) {
        String stringData = "Ramat-Hasharon Melbourne Paris New-York";
        String[] data = stringData.split(" ");
        for(String s : data){
            myLinkedList.addItem(new Node(s));
        }
        myLinkedList.traverse(myLinkedList.getRoot());
        if(myLinkedList.removeItem(new Node("Paris"))){
            System.out.println("removed item with the value of Paris");
        }
        myLinkedList.traverse(myLinkedList.getRoot());
        myLinkedList.addItem(new Node("Tel-Aviv"));
        myLinkedList.traverse(myLinkedList.getRoot());

    }


}
