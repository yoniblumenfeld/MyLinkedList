package abstractClass.challenge;

public abstract class ListItem {
    protected Object value;
    protected ListItem leftListItem = null;
    protected ListItem rightListItem = null;

    public ListItem(Object value,ListItem leftListItem,ListItem rightListItem) {
        this.value = value;
        this.leftListItem = leftListItem;
        this.rightListItem = rightListItem;
    }
    public Object getValue() { return value; }
    public void setValue(Object value) {this.value = value;}

    public ListItem getLeftListItem() {
        return leftListItem;
    }

    public ListItem getRightListItem() {
        return rightListItem;
    }


    abstract ListItem moveRight();
    abstract ListItem setRightListItem(ListItem item);
    abstract ListItem moveLeft();
    abstract ListItem setLeftListItem(ListItem item);
    abstract int compareTo(ListItem listItem);

}
