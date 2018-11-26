package abstractClass.challenge;

public class Node extends ListItem {
    public Node(Object value){
        this(value,null,null);
    }
    public Node(Object value, ListItem leftListItem, ListItem rightListItem) {
        super(value, leftListItem, rightListItem);
    }

    @Override
    ListItem moveRight() {
        return this.rightListItem;
    }

    @Override
    ListItem setRightListItem(ListItem item) {
        return this.rightListItem = item;
    }

    @Override
    ListItem moveLeft() {
        return this.leftListItem;
    }

    @Override
    ListItem setLeftListItem(ListItem item) {
        return this.leftListItem = item;
    }

    @Override
    int compareTo(ListItem listItem) {
        if(listItem == null) return 0;
        return this.getValue().toString().compareTo(listItem.getValue().toString());
    }

    int compareTo(Object value){
        return this.getValue().toString().compareTo(value.toString());
    }
}
