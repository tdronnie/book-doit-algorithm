// ����8-7
// ���� ����Ʈ Ŭ����

import java.util.Comparator;

public class CircularLinkedList<E> {

	//--- ��� ---//
	class Node<E> {
		E data;					// ������
		Node<E> next;		// ���� ������(���� ��忡 ���� ����)

		//--- ������ ---//
		Node(E data) {
			this.data = data;
			this.next = this;
		}

		//--- ������ ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;			// �Ӹ� ���
	private Node<E> tail;			// ���� ���
	private Node<E> crnt;			// ���� ���

	//--- ������ ---//
	public CircularLinkedList() {
		head = tail = crnt = null;
	}

	//--- ��� �˻� ---//
	public E search(E o, Comparator<? super E> c) {
		if (head != null) {
			Node<E> ptr = head;					// ���� ��ĵ ���� ���

			do {
				if (c.compare(o, ptr.data) == 0) {	// �˻� ����
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next; 						// ���� ��带 ����
			} while (ptr != head);
		}
		return null;										// �˻� ����
	}

	//--- �Ӹ��� ��带 ���� ---//
	public void addFirst(E o) {
		if (head == null)
			head = tail = crnt = new Node<E>(o);
		else {
			Node<E> ptr = head;
			head = crnt = new Node<E>(o, ptr);
			tail.next = head;
		}
	}

	//--- ������ ��带 ���� ---//
	public void addLast(E o) {
		if (head == null)			// ����Ʈ�� ��� ������ 
			addFirst(o);				// �Ӹ��� ����
		else {
			Node<E> ptr = tail;
			ptr.next = crnt = tail = new Node<E>(o, head);
		}
	}

	//--- �Ӹ� ��带 ���� ---//
	public void removeFirst() {
		if (head != null) {					// ����Ʈ�� ��� ���� ������
			if (head == tail)
				head = tail = crnt = null;
			else {
				Node<E> ptr = head.next;
				head = crnt = ptr;
				tail.next = head;
			}
		}
	}

	//--- ���� ��带 ���� ---//
	public void removeLast() {
		if (head != null) {
			if (head == tail)					// ��尡 �ϳ����̸� 
				removeFirst();					// �Ӹ� ��带 ����
			else {
				Node<E> ptr = head;			// ��ĵ ���� ���
				Node<E> pre = head;			// ��ĵ ���� ����� ���� ���

				while (ptr.next != head) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = head;				// pre�� ���� ���� ���� ���
				tail = crnt = pre;
			}
		}
	}

	//--- ��� p�� ���� ---//
	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head)					// p�� �Ӹ� ����̸� 
				removeFirst();				// �Ӹ� ��带 ����
			else if (p == tail)			// p�� ���� ����̸� 
				removeLast();					// ���� ��带 ����
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == head) return;	// p�� ����Ʈ�� ����
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
		if (crnt == null || crnt.next == head)
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
		if (head != null) {
			Node<E> ptr = head;

			do {
				System.out.println(ptr.data.toString());
				ptr = ptr.next;
			} while (ptr != head);
		}
	}

	//--- ���۷�����c�� ���� ���� ��带 ã�� ��� ��带 ���� ---//
	public void purge(Comparator<? super E> c) {
		if (head == null) return;
		Node<E> ptr = head;

		do {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;

			while (pre.next != head) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					remove(ptr2);
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
		} while (ptr.next != head);
		crnt = head;
	}

	//--- �Ӹ����� n�� �� ����� �����Ϳ� ���� ������ ��ȯ ---//
	public E retrieve(int n) {
		if (head != null) {
			Node<E> ptr = head;

			while (n >= 0) {
				if (n-- == 0) {
					crnt = ptr;
					return ptr.data;			// �˻� ����
				}
				ptr = ptr.next;						// ���� ��带 ����
				if (ptr == head) break;
			}
		}
		return null;
	}
}
