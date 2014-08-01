/* DList.java */

/**
 *  A DList is a mutable doubly-linked list.  (No sentinel, not
 *  circularly linked.)
 */

public class DList {

  /**
   *  head references the first node.
   *  tail references the last node.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected DListNode tail;
  protected long size;

  /* DList invariants:
   *  1)  head.prev == null.
   *  2)  tail.next == null.
   *  3)  For any DListNode x in a DList, if x.next == y and x.next != null,
   *      then y.prev == x.
   *  4)  For any DListNode x in a DList, if x.prev == y and x.prev != null,
   *      then y.next == x.
   *  5)  The tail can be accessed from the head by a sequence of "next"
   *      references.
   *  6)  size is the number of DListNodes that can be accessed from the
   *      head by a sequence of "next" references.
   */

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   *  DList() constructor for a one-node DList.
   */
  public DList(Run a) {
    head = new DListNode();
    tail = head;
    head.item = a;
    size = 1;
  }

  /**
   *  DList() constructor for a two-node DList.
   */
  public DList(Run a, Run b) {
    head = new DListNode();
    head.item = a;
    tail = new DListNode();
    tail.item = b;
    head.next = tail;
    tail.prev = head;
    size = 2;
  }

  /**
   *  insertFront() inserts an item at the front of a DList.
   */
  public void insertFront(Run i) {
    if (head == null) {
      head = new DListNode(i);
      tail = head;
      head.prev = null;
    } else {
      DListNode oldHead = head;
      head = new DListNode(i);
      head.next = oldHead;
      oldHead.prev = head;
    }
    size ++;
  }

  /**
   *  removeFront() removes the first item (and node) from a DList.  If the
   *  list is empty, do nothing.
   */
  public void removeFront() {
    if (head == null) {
      return;
    } else if (size == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }
    size --;
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head;
    while (current != null) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }
}