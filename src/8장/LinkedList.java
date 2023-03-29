
// ���� ����Ʈ Ŭ����

import java.util.Comparator;

public class LinkedList<E> {
	// --- ��� ---//
	class Node<E> {
		private E data; // ������
		private Node<E> next; // ���� ������(���� ��忡 ���� ����)

		// --- ������(constructor) ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // �Ӹ� ������(�Ӹ� ��忡 ���� ����)
	private Node<E> crnt; // ���� ������(���� ��忡 ���� ����)

	// --- ������(constructor) ---//
	public LinkedList() {
		head = crnt = null;
	}

	// --- ��� �˻� ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // ���� ��ĵ ���� ���

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) { // �˻� ����
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // ���� ��忡 �ָ�
		}
		return null; // �˻� ����
	}

	// --- �Ӹ� ��� ���� ---//
	public void addFirst(E obj) {
		Node<E> ptr = head; // ���� ���� �Ӹ� ���
		head = crnt = new Node<E>(obj, ptr);
	}

	// --- ���� ��� ���� ---//
	public void addLast(E obj) {
		if (head == null) // ����Ʈ�� ���������
			addFirst(obj); // �Ӹ��� ����
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}

	// --- �Ӹ���� ���� ---//
	public void removeFirst() {
		if (head != null) // ����Ʈ�� ������� ������
			head = crnt = head.next;
	}

	// --- ������� ���� ---//
	public void removeLast() {
		if (head != null) {
			if (head.next == null) // ��尡 �ϳ��� ������
				removeFirst(); // �Ӹ���� ����
			else {
				Node<E> ptr = head; // ��ĵ ���� ���
				Node<E> pre = head; // ��ĵ ���� ����� ���� ���

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; // pre�� ���� ���� ���� ���
				crnt = pre;
			}
		}
	}

	// --- ���p ���� ---//
	public void remove(Node p) {
		if (head != null) {
			if (p == head) // p�� �Ӹ� ����̸�
				removeFirst(); // �Ӹ� ��� ����
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null)
						return; // p�� ����Ʈ�� ����
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	// --- ���� ��� ���� ---//
	public void removeCurrentNode() {
		remove(crnt);
	}

	// --- ��ü��� ���� ---//
	public void clear() {
		while (head != null) // ��� �� ������
			removeFirst(); // �Ӹ� ��� ����
		crnt = null;
	}

	// --- ���� ��带 �ϳ� �������� ���� ---//
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false; // ���ư� �� ����
		crnt = crnt.next;
		return true;
	}

	// --- ���� ��� ǥ�� ---//
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("�ָ��尡 �����ϴ�.");
		else
			System.out.println(crnt.data);
	}

	// --- ��ü ��� ǥ�� ---//
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	// ---������8-1�� ���۷�����c�� ���� ���� ��带 ã�� ��� ��带 ���� ---//
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head; //ó������ �˻����� ������ ����

		while (ptr != null) { //���� �˻�
			int count = 0;
			Node<E> ptr2 = ptr; //�� ������
			Node<E> pre = ptr; //Ž�� ������

			while (pre.next != null) {
				ptr2 = pre.next; //���ϱ� ���� �����͸� Ž���� �״��� �����ͷ� ����
				if (c.compare(ptr.data, ptr2.data) == 0) { //Ÿ�� �����Ϳ� ���� �� �������� �����Ϳ� ���� ���
					pre.next = ptr2.next; //���� ���� ���� ���������� �� �������� �ѱ�
					count++; //�ߺ��Ǵ� ��� ���� + 1
				} else
					pre = ptr2; //Ž�� �����͸�  �񱳿Ϸ��� �����ͷ� ������Ʈ
			}
			if (count == 0) //�ߺ��Ǵ� ��尡 �����ٸ�
				ptr = ptr.next; //�������� ������ �ѱ�
			else {
				Node<E> temp = ptr; //���� ������ �����صΰ�
				remove(ptr); //���� ������ ��� ����
				ptr = temp.next; //���� �����͸� ���� �����ͷ� ������Ʈ
			}
		}
		crnt = head; //���� �����͸� �Ӹ���� �����ͷ� �ٽ� ������Ʈ �س��´�.
	}

	// ---������8-2�� �Ӹ����� n�� �� ����� �����Ϳ� ���� ������ ��ȯ ---//
	public E retrieve(int n) {
		Node<E> ptr = head; //ó������ �˻�

		while (n >= 0 && ptr != null) { //n�� ���� ����, ������ null������
			if (n-- == 0) { //n�� 0�� ������ ���̳ʽ�
				crnt = ptr; //������ �����͸� ���� �����ͷ� ������Ʈ
				return ptr.data; // �˻� ����
			}
			ptr = ptr.next; // ���� ��带 ����
		}
		return null; //n�� ���� ��尡 ���ų�
	}
}