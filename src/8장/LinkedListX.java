// ����8-3
// ���� ����Ʈ Ŭ����(���� �����͵� ����)

import java.util.Comparator;

public class LinkedListX<E> {

	//--- ��� ---//
	class Node<E> {
		private E data;         // ������
		private Node<E> next;   // ���� ������(���� ��忡 ���� ����)

		//--- ������ ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;		// �Ӹ� ������(�Ӹ� ��忡 ���� ����)
	private Node<E> tail;		// ���� ������(���� ��忡 ���� ����)
	private Node<E> crnt;		// ���� ������(���� ��忡 ���� ����)

	//--- ������ ---//
	public LinkedListX() {
		head = tail = crnt = null;
	}

	//--- ��� �˻� ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;							// ���� ��ĵ ���� ���

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {			// �˻� ����
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;								// ���� ��带 ����
		}
		return null;										// �˻� ����
	}

	//--- �Ӹ��� ��带 ���� ---//
	public void addFirst(E o) {
		boolean empty = (tail == null);
		Node<E> ptr = head;							// ���� ���� �Ӹ� ���
		head = crnt = new Node<E>(o, ptr);
		if (empty) tail = crnt;
	}

	//--- ������ ��带 ���� ---//
	public void addLast(E o) {
		if (head == null)			// ����Ʈ�� ��� ������ 
			addFirst(o);				// �Ӹ��� ����
		else {
			tail.next = crnt = new Node<E>(o, null); //������ ��� ���� �����ͷ� ���� ������ ������Ʈ �� ��� �߰�
			tail = crnt;
		}
	}

	//--- �Ӹ� ��带 ���� ---//
	public void removeFirst() {
		if (head != null) {					 // ����Ʈ�� ��� ���� ������
			head = crnt = head.next;
			if (head == null) tail = null;
		}
	}

	//--- ���� ��带 ���� ---//
	public void removeLast() {
		if (head != null) {
			if (head.next == null)		           // ��尡 �ϳ����̸� 
				removeFirst();					// �Ӹ� ��带 ����
			else {
				Node<E> ptr = head;			// ��ĵ ���� ���
				Node<E> pre = head;			// ��ĵ ���� ����� ���� ���

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;				// pre�� ���� ���� ���� ���
				tail = crnt = pre; //���� �����͸� ���� �����Ϳ� �Բ� ������Ʈ
			}
		}
	}

	//--- ��� p�� ���� ---//
	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head)						// p�� �Ӹ� ����̸� 
				removeFirst();					// �Ӹ� ��带 ����
			else if (p == tail)				// p�� ���� ����̸� 
				removeLast();						// ���� ��带 ����
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;	// p�� ����Ʈ�� ����
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	//--- ���� ��带 ���� ---//
	public void removeCurrentNode() {
		remove(crnt);
	}

	//--- ��� ��带 ���� ---//
	public void clear() {
		while (head != null)		// ��忡 �ƹ��͵� ���� ������
			removeFirst();				// �Ӹ� ��带 ����
		crnt = null;
	}

	//--- ���� ��带 �ϳ� �������� ���� ---//
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;					// ���ư� �� ����
		crnt = crnt.next;
		return true;
	}

	//--- ���� ��带 ��� ---//
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("������ ��尡 �����ϴ�.");
		else
			System.out.println(crnt.data.toString());
	}

	//--- ��� ��带 ��� ---//
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data.toString());
			ptr = ptr.next;
		}
	}

	//---������8-1�� ���۷�����c�� ���� ���� ��带 ã�� ��� ��带 ���� ---//
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head;

		while (ptr != null) {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;

			while (pre.next != null) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++;
				} else
					pre = ptr2;
			}
			if (count == 0)
				ptr = ptr.next;
			else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
		crnt = head;
	}

  //---������8-2�� �Ӹ����� n�� �� ����� �����Ϳ� ���� ������ ��ȯ ---//
	public E retrieve(int n) {
		Node<E> ptr = head;

		while (n >= 0 && ptr != null) {
			if (n-- == 0) {
				crnt = ptr;
				return ptr.data;						// �˻� ����
			}
			ptr = ptr.next;							// ���� ��带 ����
		}
		return null;
	}
}
