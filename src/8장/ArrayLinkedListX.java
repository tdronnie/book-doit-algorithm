// ����8-6
// ���� ����Ʈ Ŭ����(�迭  Ŀ�� ����)

import java.util.Comparator;

public class ArrayLinkedListX<E> {

	//--- ��� ---//
	class Node<E> {
		private E data;			// ������
		private int next;		// ����Ʈ�� ���� ������
		private int dnext;	// ���� ����Ʈ�� ���� ������

		//--- data�� next�� ���� ---//
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n;		// ����Ʈ ��ü
	private int size;				// ����Ʈ�� �뷮(�ִ� �����ͼ�)
	private int max;				// ��� ���� ���� ���ڵ�
	private int head;				// �Ӹ� ���
	private int tail;				// ���� ���
	private int crnt;				// ���� ���
	private int deleted;		// ���� ����Ʈ�� �Ӹ� ���
	private static final int NULL = -1;	// ���� ��尡 ����/����Ʈ�� ���� ��

	//--- ������ ---//
	public ArrayLinkedListX(int capacity) {
		head = tail = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++)
				n[i] = new Node<E>();
			size = capacity;
		}
		catch (OutOfMemoryError e) {		// �迭�� ������ ����
			size = 0;
		}
	}

	//--- ������ �����ϴ� ���ڵ��� �ε����� ���մϴ� ---//
	private int getInsertIndex() {
		if (deleted == NULL) {					// ������ ���ڵ尡 ����
			if (max < size)
				return ++max;								// �� ���ڵ带 ���
			else
				return NULL;								// �뷮 ��ħ(over)
		} else {
			int rec = deleted;						// ���� ����Ʈ���� 
			deleted = n[rec].dnext;				// �Ӹ� rec�� ����
			return rec;
		}
	}

	//--- ���ڵ�idx�� ���� ����Ʈ�� ��� ---//
	private void deleteIndex(int idx) {
		if (deleted == NULL) {					// ������ ���ڵ尡 ����
			deleted = idx;								// idx�� ���� ����Ʈ�� 
			n[idx].dnext = NULL;					// �Ӹ��� ���
		} else {
			int rec = deleted;						// idx�� ���� ����Ʈ�� 
			deleted = idx;								// �Ӹ��� ����
			n[idx].dnext = rec;
		}
	}

	//--- ��� �˻� ---//
	public E search(E o, Comparator<? super E> c) {
		int ptr = head;									// ���� ��ĵ ���� ���

		while (ptr != NULL) {
			if (c.compare(o, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data;					// �˻� ����
			}
			ptr = n[ptr].next;						// ���� ��带 ����
		}
		return null;										// �˻� ����
	}

	//--- �Ӹ��� ��带 ���� ---//
	public void addFirst(E o) {
		boolean empty = (tail == NULL);
		int ptr = head;									// ���� ���� �Ӹ� ���
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec;						// �ε��� rec �� ���ڵ忡 ����
			n[head].set(o, ptr);
			if (empty) tail = crnt;
		}
	}

	//--- ������ ��带 ���� ---//
	public void addLast(E o) {
		if (head == NULL)								// ����Ʈ�� ��� ������ 
			addFirst(o);									// �Ӹ��� ����
		else {
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, NULL);
				tail = rec;
			}
		}
	}

	//--- �Ӹ� ��带 ���� ---//
	public void removeFirst() {
		if (head != NULL) {							// ����Ʈ�� ��� ���� ������
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
			if (head == NULL) tail = NULL;
		}
	}

	//--- ���� ��带 ���� ---//
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL)			// ��尡 �ϳ����̸� 
				removeFirst();							// �Ӹ� ��带 ����
			else {
				int ptr = head;							// ��ĵ ���� ���
				int pre = head;							// ��ĵ ���� ����� ���� ���

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;					// pre�� ���� ���� ���� ���
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}

	//--- ���ڵ�p�� ���� ---//
	public void remove(int p) {
		if (head != NULL) {
			if (p == head)								// p�� �Ӹ� ����̸� 
				removeFirst();							// �Ӹ� ��带 ����
			else if (p == tail)						// p�� ���� ����̸� 
				removeLast();								// ���� ��带 ����
			else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == NULL) return;	// p�� ����Ʈ�� ����
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
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
		while (head != NULL)						// ��忡 �ƹ��͵� ���� ������
			removeFirst();								// �Ӹ� ��带 ����
		crnt = NULL;
	}

	//--- ���� ��带 �ϳ� �������� ���� ---//
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false;									// ���ư� �� ����
		crnt = n[crnt].next;
		return true;
	}

	//--- ���� ��带 ��� ---//
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("������ ��尡 �����ϴ�.");
		else
			System.out.println(n[crnt].data.toString());
	}

	//--- ��� ��带 ��� ---//
	public void dump() {
		int ptr = head;

		while (ptr != NULL) {
			System.out.println(n[ptr].data.toString());
			ptr = n[ptr].next;
		}
	}

	//--- ���۷�����c�� ���� ���� ��带 ã�� ��� ��带 ���� ---//
	public void purge(Comparator<? super E> c) {
		int ptr = head;

		while (ptr != NULL) {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;

			while (n[pre].next != NULL) {
				ptr2 = n[pre].next;
				if (c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				} else
					pre = ptr2;
			}
			if (count == 0)
				ptr = n[ptr].next;
			else {
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
		}
		crnt = head;
	}

	//--- �Ӹ����� n�� �� ����� �����Ϳ� ���� ������ ��ȯ ---//
	public E retrieve(int n) {
		int ptr = head;

		while (n >= 0 && ptr != NULL) {
			if (n-- == 0) {
				crnt = ptr;
				return this.n[ptr].data;				// �˻� ����
			}
			ptr = this.n[ptr].next;						// ���� ��带 ����
		}
		return null;
	}
}

