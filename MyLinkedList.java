package abstractClass.challenge;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (newItem == null) return false;
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparisonResult = currentItem.compareTo(newItem);
            if (comparisonResult > 0) {
                //current item is lexicographically higher than the other item.
                //we need to the add the node to the index before the current.
                //if the node has no node before it, make the new node root and place current node after it.
                if (currentItem.moveLeft() == null) {
                    //make new item root and return true
                    currentItem.setLeftListItem(newItem);
                    newItem.setRightListItem(currentItem);
                    this.root = newItem;
                    return true;
                } else {
                    //add the new node as the node before the current
                    newItem.setRightListItem(currentItem);
                    newItem.setLeftListItem(currentItem.moveLeft());
                    currentItem.moveLeft().setRightListItem(newItem);
                    currentItem.setLeftListItem(newItem);
                    return true;
                }
            } else if (comparisonResult < 0) {
                //current item is lexicographically lower than the other item.
                //if current node has no following node, add the new node after this one.
                //other wise, skip to the next node.
                if (currentItem.moveRight() == null) {
                    currentItem.setRightListItem(newItem);
                    newItem.setLeftListItem(currentItem);
                    return true;
                } else currentItem = currentItem.moveRight();

            } else {
                //current item is lexicographically equal to other item.
                //do not add the new node
                System.out.println("Node with the value " + newItem.getValue() + " already exists! didnt add");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (this.root == null) {
            //if list is empty, return false
            System.out.println("List is empty");
            return false;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            if (currentItem.getValue().equals(item.getValue())) {
                System.out.println("Removing item with the value of " + item.getValue());
                ListItem nextItem = currentItem.moveRight();
                ListItem previousItem = currentItem.moveLeft();
                if (nextItem == null && previousItem == null) {
                    //means only one item in list
                    this.root = null;
                    return true;
                }
                if (nextItem == null) {
                    //means last item in list
                    previousItem.setRightListItem(null);
                    currentItem.setLeftListItem(null);
                    return true;
                }
                if (previousItem == null) {
                    //means first item in list
                    nextItem.setLeftListItem(null);
                    currentItem.setRightListItem(null);
                    this.root = nextItem;
                    return true;
                }
                previousItem.setRightListItem(nextItem);
                nextItem.setLeftListItem(previousItem);
                currentItem.setRightListItem(null);
                currentItem.setLeftListItem(null);
                return true;
            } else currentItem = currentItem.moveRight();

        }
        return false;
    }


    @Override
    public void traverse(ListItem root) {
        if (root == null) System.out.println("Reached end of list");
        else {
            System.out.println("Node -> " + root.getValue());
            traverse(root.moveRight());
        }
    }
}
